public class Item {
    private String name;
    private String description;
    private int quantity;
    private int value;
    private double weight;
    private int durability;

    public Item(String name, String description, int quantity, int value, double weight,
            int durability) {
        this.name = name;
        this.description = description;
        this.quantity = Math.max(quantity, 0);
        this.value = value;
        this.weight = weight;
        this.durability = Math.max(durability, 0);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getValueInGold() {
        return value + " gold";
    }

    public int getValue() {
        return value;
    }

    public void displayItemDetails() {
        System.out.println("Item: " + name);
        System.out.println("Description: " + description);
        System.out.println("Quantity: " + quantity);
        System.out.println("Value: " + getValueInGold());
        System.out.println("Weight: " + weight);
        System.out.println("Durability: " + durability);
    }

    public double getWeight() {
        return weight;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void reduceDurability(int amount) {
        if (durability > 0) {
            durability -= amount;
            System.out.println("Durability reduced to " + durability);
            if (durability <= 0) {
                durability = 0;
                System.out.println(name + " is now broken/gone.");
            }
        }
    }

    public void repair(int amount) {
        durability += amount;
        System.out.println(
                name + " has been repaired to " + durability + " durability." + " New durability: " + durability);
    }
}
