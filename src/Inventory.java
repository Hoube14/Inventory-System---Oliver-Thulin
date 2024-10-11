import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println(item.getName() + " has been removed from the inventory.");
        } else {
            System.out.println(item.getName() + " is not in the inventory.");
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public int getItemCount() {
        return items.size();
    }

    public void displayInventory() {
        if (items.isEmpty()) {
            System.out.println("The inventory is empty.");
        } else {
            for (Item item : items) {
                System.out.println(item.getName() + " - Quantity: " + item.getQuantity());
            }
        }
    }
}
