package dk.mrspring.javanbt.nbt;

import com.google.gson.internal.LinkedTreeMap;
import dk.mrspring.javanbt.NBTJson;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Map;

/**
 * Created by Konrad on 16-07-2015.
 */
public class NBTJsonCompound extends NBTJsonBase<NBTTagCompound>
{
    Map<String, Object> value;

    public NBTJsonCompound(LinkedTreeMap<String, Object> value)
    {
        super();
        this.value = value;
    }

    @Override
    public NBTTagCompound makeNBTTag()
    {
        return NBTJson.createFromJsonObject(this.value);
    }
}
