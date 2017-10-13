public class Demonstration {
    public static void main(String[] args) {
        ItemUtils itemUtils = new ItemUtils();
        itemUtils.listAllModelIDs();
        System.out.println(itemUtils.getItems().size());
    }
}
