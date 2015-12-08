package dk.mrspring.javanbt.nbt;

import dk.mrspring.javanbt.NBTJsonBaseWrapper;
import net.minecraft.nbt.NBTBase;

/**
 * Created by Konrad on 15-07-2015.
 */
public abstract class NBTJsonBase<T extends NBTBase>
{
    public abstract T makeNBTTag();
}
