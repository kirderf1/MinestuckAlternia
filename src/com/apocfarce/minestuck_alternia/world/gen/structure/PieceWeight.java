package com.apocfarce.minestuck_alternia.world.gen.structure;

import com.apocfarce.minestuck_alternia.world.gen.structure.Components.VillageComponentInterface;

public class PieceWeight
{
    public Class <? extends VillageComponentInterface > villagePieceClass;
    public final int villagePieceWeight;
    public int villagePiecesSpawned;
    public int villagePiecesLimit;

    public PieceWeight(Class <? extends VillageComponentInterface > p_i2098_1_, int p_i2098_2_, int p_i2098_3_)
    {
        this.villagePieceClass = p_i2098_1_;
        this.villagePieceWeight = p_i2098_2_;
        this.villagePiecesLimit = p_i2098_3_;
    }

    public boolean canSpawnMoreVillagePiecesOfType(int componentType)
    {
        return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
    }

    public boolean canSpawnMoreVillagePieces()
    {
        return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
    }
}
