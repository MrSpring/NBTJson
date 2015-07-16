package dk.mrspring.javanbt;

import com.google.gson.internal.LinkedTreeMap;
import dk.mrspring.javanbt.nbt.*;

import java.util.List;

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
            },
    SHORT(2)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonShort(((Double) value).shortValue());
                }
            },
    INTEGER(3)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonInteger(((Double) value).intValue());
                }
            },
    LONG(4)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonLong(((Double) value).longValue());
                }
            },
    FLOAT(5)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonFloat(((Double) value).longValue());
                }
            },
    DOUBLE(6)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonDouble((Double) value);
                }
            },
    BYTE_ARRAY(7)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonBytes((List<Double>) value);
                }
            },
    STRING(8)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonString((String) value);
                }
            },
    LIST(9)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonList((List) value);
                }
            },
    COMPOUND(10)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonCompound((LinkedTreeMap<String, Object>) value);
                }
            },
    INTEGER_ARRAY(11)
            {
                @Override
                public NBTJsonBase makeNBT(Object value)
                {
                    return new NBTJsonIntegers((List<Double>) value);
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
        return null;
    }

    public NBTJsonBase makeNBT(Object value)
    {
        return null;
    }
}
