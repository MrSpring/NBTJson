package dk.mrspring.nbtjson;

import com.google.gson.internal.LinkedTreeMap;
import dk.mrspring.nbtjson.nbt.*;
import net.minecraft.nbt.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Konrad on 15-07-2015.
 */
public enum NBTType
{
    UNKNOWN(-1),
    END(0),
    BYTE(1)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonByte(((Double) value).byteValue());
                }

                @Override
                public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
                {
                    return new NBTJsonBaseWrapper(getId(), ((NBTTagByte) tag).func_150290_f());
                }
            },
    SHORT(2)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonShort(((Double) value).shortValue());
                }

                @Override
                public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
                {
                    return new NBTJsonBaseWrapper(getId(), ((NBTTagShort) tag).func_150289_e());
                }
            },
    INTEGER(3)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonInteger(((Double) value).intValue());
                }

                @Override
                public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
                {
                    return new NBTJsonBaseWrapper(getId(), ((NBTTagInt) tag).func_150287_d());
                }
            },
    LONG(4)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonLong(((Double) value).longValue());
                }

                @Override
                public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
                {
                    return new NBTJsonBaseWrapper(getId(), ((NBTTagLong) tag).func_150291_c());
                }
            },
    FLOAT(5)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonFloat(((Double) value).longValue());
                }

                @Override
                public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
                {
                    return new NBTJsonBaseWrapper(getId(), ((NBTTagFloat) tag).func_150288_h());
                }
            },
    DOUBLE(6)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonDouble((Double) value);
                }

                @Override
                public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
                {
                    return new NBTJsonBaseWrapper(getId(), ((NBTTagDouble) tag).func_150286_g());
                }
            },
    BYTE_ARRAY(7)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonBytes((List<Double>) value);
                }

                @Override
                public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
                {
                    return new NBTJsonBaseWrapper(getId(), ((NBTTagByteArray) tag).func_150292_c());
                }
            },
    STRING(8)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonString((String) value);
                }

                @Override
                public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
                {
                    return new NBTJsonBaseWrapper(getId(), ((NBTTagString) tag).func_150285_a_());
                }
            },
    LIST(9)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonList((List) value);
                }

                @Override
                public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
                {
                    List<NBTJsonBaseWrapper> wrappers = new ArrayList<NBTJsonBaseWrapper>();
                    NBTTagList tagList = (NBTTagList) tag.copy();
                    while (tagList.tagCount() > 0)
                    {
                        NBTBase tagFromList = tagList.removeTag(0);
                        if (tagFromList == null) continue;
                        NBTJsonBaseWrapper wrapper = NBTJsonCompile.compileTag(tagFromList);
                        if (wrapper != null) wrappers.add(wrapper);
                    }
                    return new NBTJsonBaseWrapper(getId(), wrappers);
                }
            },
    COMPOUND(10)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonCompound((LinkedTreeMap<String, Object>) value);
                }

                @Override
                public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
                {
//                    return super.makeWrapper(tag);
                    Map<String, Object> tags = new LinkedTreeMap<String, Object>();
                    NBTTagCompound compound = (NBTTagCompound) tag;
                    for (String tagName : (Set<String>) compound.func_150296_c())
                    {
                        NBTBase tagFromCompound = compound.getTag(tagName);
                        if (tagFromCompound == null) continue;
                        NBTJsonBaseWrapper wrapper = NBTJsonCompile.compileTag(tagFromCompound);
                        if (wrapper != null) tags.put(tagName, wrapper);
                    }
                    return new NBTJsonBaseWrapper(getId(), tags);
                }
            },
    INTEGER_ARRAY(11)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonIntegers((List<Double>) value);
                }

                @Override
                public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
                {
                    return new NBTJsonBaseWrapper(getId(), ((NBTTagIntArray) tag).func_150302_c());
                }
            };

    private final int id;

    NBTType(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public static NBTType fromId(int id)
    {
        for (NBTType type : values()) if (type.getId() == id) return type;
        return UNKNOWN;
    }

    public NBTJsonBase makeNBT(Object value)
    {
        return null;
    }

    public NBTJsonBaseWrapper makeWrapper(NBTBase tag)
    {
        return null;
    }
}
