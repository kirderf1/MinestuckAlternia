package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.world.biome.AlterniaBiomes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class BiomeProvider implements IDataProvider {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
	private final DataGenerator generator;
	
	public BiomeProvider(DataGenerator generator) {
		this.generator = generator;
	}
	
	@Override
	public void act(DirectoryCache cache) throws IOException {
		Function<Supplier<Biome>, DataResult<JsonElement>> biomeSaver = JsonOps.INSTANCE.withEncoder(Biome.BIOME_CODEC);
		Path path = generator.getOutputFolder();
		
		for(Pair<RegistryKey<Biome>, Biome> entry : makeBiomes()) {
			Path file = getPath(path, entry.getFirst());
			
			Optional<JsonElement> result = biomeSaver.apply(entry::getSecond).resultOrPartial(LOGGER::error);
			if(result.isPresent())
				IDataProvider.save(GSON, cache, result.get(), file);
		}
	}
	
	protected List<Pair<RegistryKey<Biome>, Biome>> makeBiomes() {
		return AlterniaBiomes.makeBiomesForDataGen();
	}
	
	private Path getPath(Path path, RegistryKey<Biome> key) {
		return path.resolve("data/" + key.getLocation().getNamespace() + "/worldgen/biome/" + key.getLocation().getPath() + ".json");
	}
	
	@Override
	public String getName() {
		return "Biomes";
	}
}