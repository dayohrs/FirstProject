public class Item {
    private String name;
    private boolean members;
    private boolean tradeable;
    private boolean cosmetic;
    private int modelid;
    private int value;

    public String getName() {
        return name;
    }

    public boolean isMembers() {
        return members;
    }

    public boolean isTradeable() {
        return tradeable;
    }

    public boolean isCosmetic() {
        return cosmetic;
    }

    public int getModelID() {
        return modelid;
    }

    public int getValue() {
        return value;
    }
}
