import java.util.ArrayList;

public class Demonstration {
    public static void main(String[] args) {
        ItemUtils itemUtils = ItemUtils.loadItemUtils();
        String name = "champion scroll";

        ArrayList<Item> list = itemUtils.getItemsByName(name);
        System.out.println(list.size() + " items match \"" + name + "\"");
        for (Item item : list) {
            System.out.print(String.format("%s (id = %d)\n", item.getName(), item.getModelID()));
        }


    }
}
