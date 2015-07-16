import com.google.gson.Gson;
import dk.mrspring.javanbt.NBTJson;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Created by Konrad on 15-07-2015.
 */
public class Tester
{
    public static void main(String[] args)
    {
        System.out.println("Running...");

        Gson gson = new Gson();
        String json =
                "{\n" +
                        "  \"item_name\": \"kitchen:bread\",\n" +
                        "  \"metadata\": 3,\n" +
                        "  \"tag\": {\n" +
                        "    \"test_compound\": {\n" +
                        "      \"nbt_type\": 10,\n" +
                        "      \"value\": {\n" +
                        "        \"byte_value\": {\n" +
                        "          \"nbt_type\": 1,\n" +
                        "          \"value\": 2\n" +
                        "        },\n" +
                        "        \"short_value\": {\n" +
                        "          \"nbt_type\": 2,\n" +
                        "          \"value\": 3\n" +
                        "        },\n" +
                        "        \"integer_value\": {\n" +
                        "          \"nbt_type\": 3,\n" +
                        "          \"value\": 1337\n" +
                        "        },\n" +
                        "        \"long_value\": {\n" +
                        "          \"nbt_type\": 4,\n" +
                        "          \"value\": 1335485513887954\n" +
                        "        },\n" +
                        "        \"float_value\": {\n" +
                        "          \"nbt_type\": 5,\n" +
                        "          \"value\": 13.37\n" +
                        "        },\n" +
                        "        \"double_value\": {\n" +
                        "          \"nbt_type\": 6,\n" +
                        "          \"value\": 6006.13\n" +
                        "        },\n" +
                        "        \"byte_array_value\": {\n" +
                        "          \"nbt_type\": 7,\n" +
                        "          \"value\": [7, 8, 9, 4, 5, 6, 1, 2, 3]\n" +
                        "        },\n" +
                        "        \"string_value\": {\n" +
                        "          \"nbt_type\": 8,\n" +
                        "          \"value\": \"This is a String value. Love me! <3\"\n" +
                        "        },\n" +
                        "        \"list_value\": {\n" +
                        "          \"nbt_type\": 9,\n" +
                        "          \"value\": [\n" +
                        "            {\n" +
                        "              \"nbt_type\": 8,\n" +
                        "              \"value\": \"This is the first entry in the list.\"\n" +
                        "            }, {\n" +
                        "              \"nbt_type\": 8,\n" +
                        "              \"value\": \"This is the second thingy.\"\n" +
                        "            }\n" +
                        "          ]\n" +
                        "        },\n" +
                        "        \"compound_value\": {\n" +
                        "          \"nbt_type\": 10,\n" +
                        "          \"value\": {\n" +
                        "            \"tag_in_compound_first\": {\n" +
                        "              \"nbt_type\": 8,\n" +
                        "              \"value\": \"This is the first entry in the compound.\"\n" +
                        "            },\n" +
                        "            \"tag_in_compound_second\": {\n" +
                        "              \"nbt_type\": 6,\n" +
                        "              \"value\": 13.37\n" +
                        "            }\n" +
                        "          }\n" +
                        "        },\n" +
                        "        \"integer_array_value\": {\n" +
                        "          \"nbt_type\": 11,\n" +
                        "          \"value\": [3, 2, 1, 6, 5, 4, 9, 8, 7]\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "}";
        ItemWrapper item = gson.fromJson(json, ItemWrapper.class);
        NBTTagCompound compound = NBTJson.createFromJsonObject(item.tag);

        System.out.println("Got compound");

        if (compound == null)
        {
            System.out.println("Returned null.");
            return;
        }

        if (compound.hasKey("test_compound", 10))
        {
            System.out.println("Test compound found. Contains:\n");
            NBTTagCompound testCompound = compound.getCompoundTag("test_compound");

            if (testCompound.hasKey("byte_value", 1))
            {
                byte value = testCompound.getByte("byte_value");
                System.out.println("Found byte value: " + value);
            } else System.out.println("Byte value not found.");

            System.out.println("");

            if (testCompound.hasKey("short_value", 2))
            {
                short value = testCompound.getShort("short_value");
                System.out.println("Found short value: " + value);
            } else System.out.println("Short value not found.");

            System.out.println("");

            if (testCompound.hasKey("integer_value", 3))
            {
                int value = testCompound.getInteger("integer_value");
                System.out.println("Found integer value: " + value);
            } else System.out.println("Integer value not found.");

            System.out.println("");

            if (testCompound.hasKey("long_value", 4))
            {
                long value = testCompound.getLong("long_value");
                System.out.println("Found long value: " + value);
            } else System.out.println("Long value not found.");

            System.out.println("");

            if (testCompound.hasKey("float_value", 5))
            {
                float value = testCompound.getFloat("float_value");
                System.out.println("Found float value: " + value);
            } else System.out.println("Float value not found.");

            System.out.println("");

            if (testCompound.hasKey("double_value", 6))
            {
                double value = testCompound.getDouble("double_value");
                System.out.println("Found double value: " + value);
            } else System.out.println("Double value not found.");

            System.out.println("");

            if (testCompound.hasKey("byte_array_value", 7))
            {
                byte[] value = testCompound.getByteArray("byte_array_value");
                System.out.println("Found byte array value: " + Arrays.toString(value));
            } else System.out.println("Byte array value not found.");

            System.out.println("");

            if (testCompound.hasKey("string_value", 8))
            {
                String value = testCompound.getString("string_value");
                System.out.println("Found string value: " + value);
            } else System.out.println("String value not found.");

            System.out.println("");

            if (testCompound.hasKey("list_value", 9))
            {
                NBTTagList list = testCompound.getTagList("list_value", 8);
                System.out.println("Found list value:");
                for (int i = 0; i < list.tagCount(); i++)
                {
                    String entry = list.getStringTagAt(i);
                    System.out.println(" - " + entry);
                }
            } else System.out.println("Long value not found.");

            System.out.println("");

            if (testCompound.hasKey("compound_value", 10))
            {
                NBTTagCompound value = testCompound.getCompoundTag("compound_value");
                System.out.println("Found compound value:");
                if (value.hasKey("tag_in_compound_first", 8))
                {
                    String first = value.getString("tag_in_compound_first");
                    System.out.println("Found first: "+first);
                }else System.out.println("First not found.");
                if (value.hasKey("tag_in_compound_second", 6))
                {
                    double second =value.getDouble("tag_in_compound_second");
                    System.out.println("Found second: "+second);
                }else System.out.println("Second not found.");
            } else System.out.println("Compound value not found.");

            System.out.println("");

            if (testCompound.hasKey("integer_array_value", 11))
            {
                int[] value = testCompound.getIntArray("integer_array_value");
                System.out.println("Found integer array value: " + Arrays.toString(value));
            } else System.out.println("Integer array value not found.");

            System.out.println("");

        } else System.out.println("Test compound not found.");
    }
}
