import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ItemUtils {

    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    public static ItemUtils loadItemUtils() {
        Gson gson = new Gson();
        return gson.fromJson(getStringFromJson("osrs_items.json"), ItemUtils.class);
    }

    public void listAllModelIDs() {
        for (Item item : items) {
            System.out.println(item.getModelID());
        }
    }

    private static String getStringFromJson(String filename) {
        final Path path = FileSystems.getDefault().getPath("data", filename);
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            System.out.println(filename + " does not exist!");
            System.exit(-1);
            return null;
        }
    }

    public Item getHighestAlchItem() {
        Item highest = items.get(0);
        for (Item item : items) {
            if (item.getValue() > highest.getValue()) {
                highest = item;
            }
        }
        return highest;
    }

    public Item getItemWithLongestName() {
        Item longest = items.get(0);
        for (Item item : items) {
            if (item.getName().length() > longest.getName().length()) {
                longest = item;
            }
        }
        return longest;
    }

    public ArrayList<Item> getItemsByName(String name) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                result.add(item);
            }
        }
        return result;
    }


}
