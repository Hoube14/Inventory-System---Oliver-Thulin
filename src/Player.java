import java.util.ArrayList;

public class Player {
  private String name;
  private int health;
  private int maxHealth;
  private Inventory inventory;
  private ArrayList<Item> equippedItems;
  private int gold;

  public Player(String name, int maxHealth, int startingGold) {
    this.name = name;
    this.maxHealth = maxHealth;
    this.health = maxHealth;
    this.gold = startingGold;
    this.inventory = new Inventory();
    this.equippedItems = new ArrayList<>();
  }

  public void addItem(Item item) {
    inventory.addItem(item);
    System.out.println(item.getName() + " has been added to " + name + "'s inventory.");
  }

  public void removeItem(Item item) {
    inventory.removeItem(item);
  }

  public void adjustGold(int amount) {
    this.gold += amount;
    System.out.println(name + " now has " + gold + " gold.");
  }

  public boolean hasEnoughGold(int amount) {
    return gold >= amount;
  }

  public int getGold() {
    return gold;
  }

  public void equipArmor(Armor armor) {
    if (armor instanceof Equippable && inventory.getItems().contains(armor)) {
      (armor).equip();
      inventory.removeItem(armor);
      equippedItems.add(armor);
    } else {
      System.out.println("Cannot equip this item.");
    }
  }

  public void unequipArmor(Armor armor) {
    if (equippedItems.contains(armor)) {
      (armor).unequip();
      equippedItems.remove(armor);
      inventory.addItem(armor);
    } else {
      System.out.println("Armor is not equipped.");
    }
  }

  public void equipWeapon(Weapon weapon) {
    if (weapon instanceof Equippable && inventory.getItems().contains(weapon)) {
      (weapon).equip();
      inventory.removeItem(weapon);
      equippedItems.add(weapon);
    } else {
      System.out.println("Cannot equip this item.");
    }
  }

  public void unequipWeapon(Weapon weapon) {
    if (equippedItems.contains(weapon)) {
      (weapon).unequip();
      equippedItems.remove(weapon);
      inventory.addItem(weapon);
    } else {
      System.out.println("Weapon is not equipped.");
    }
  }

  public void attackWithWeapon(Weapon weapon) {
    if (weapon instanceof Usable) {
      weapon.attack();
    } else {
      System.out.println("Cannot use this item.");
    }
  }

  public void useConsumable(Consumables consumable) {
    if (consumable instanceof Usable && inventory.getItems().contains(consumable)) {
      ((Usable) consumable).use();
      if (consumable.isUsedUp()) {
        removeItem(consumable);
      }
    } else {
      System.out.println("Cannot use this item.");
    }
  }

  public void displayStats() {
    System.out.println("Player: " + name);
    System.out.println("Health: " + health + "/" + maxHealth);
    System.out.println("Inventory: ");
    for (Item item : inventory.getItems()) {
      System.out.println("- " + item.getName());
    }
    System.out.println("Equipped Items: ");
    for (Item item : equippedItems) {
      System.out.println("- " + item.getName());
    }
  }

  public void takeDamage(int damage) {
    health -= damage;
    if (health < 0) {
      health = 0;
    }
    System.out.println(name + " takes " + damage + " damage. Health is now " + health + ".");
  }

  public void heal(int amount) {
    health += amount;
    if (health > maxHealth) {
      health = maxHealth;
    }
    System.out.println(name + " heals for " + amount + " points. Health is now " + health + ".");
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public ArrayList<Item> getEquippedItems() {
    return equippedItems;
  }
}
