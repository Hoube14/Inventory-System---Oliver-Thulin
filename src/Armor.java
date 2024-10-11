public class Armor extends Item implements Equippable, Destructible {
  private int defense;
  private Material material;

  public Armor(String name, String description, int quantity, int value, int weight, int durability,
      int defense, Material material) {
    super(name, description, quantity, value, weight, Math.max(durability, 0));
    this.defense = Math.max(defense, 0);
    this.material = material;
    this.setDurability((int) (getDurability() * material.getBaseDurability()));
  }

  @Override
  public void equip() {
    if (!isDestroyed()) {
      System.out.println(getName() + " is equipped, providing " + defense + " defense.");
    } else {
      System.out.println(getName() + " is broken and cannot be equipped.");
    }
  }

  @Override
  public void unequip() {
    System.out.println(getName() + " has been unequipped.");
  }

  @Override
  public void takeDamage(int amount) {
    reduceDurability(amount);
    if (isDestroyed()) {
      System.out.println(getName() + " has been destroyed.");
    }
  }

  @Override
  public void repair(int amount) {
    int newDurability = getDurability() + amount;
    setDurability(Math.min(newDurability, (int) material.getBaseDurability()));
    System.out
        .println(getName() + " has been repaired by " + amount + " points." + " New durability: " + getDurability());
    ;
  }

  public boolean isDestroyed() {
    return getDurability() == 0;
  }

  public int getDefense() {
    return defense;
  }

  public Material getMaterial() {
    return material;
  }

  public void displayArmorStats() {
    System.out.println("Armor: " + getName());
    System.out.println("Material: " + material);
    System.out.println("Defense: " + defense);
    System.out.println("Durability: " + getDurability());
  }
}
