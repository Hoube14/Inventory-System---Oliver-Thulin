public class Weapon extends Item implements Equippable, Destructible, Usable {
  private int damage;
  private String weaponType;
  private Material material;

  public Weapon(String name, String description, int quantity, int value, int weight, int durability,
      int damage, String weaponType, Material material) {
    super(name, description, quantity, value, weight, durability);
    this.damage = Math.max(damage, 0);
    this.weaponType = weaponType;
    this.material = material;
  }

  @Override
  public void equip() {
    if (!isDestroyed()) {
      System.out.println(getName() + " is equipped. Damage: " + damage);
    } else {
      System.out.println(getName() + " is broken and cannot be equipped.");
    }
  }

  @Override
  public void unequip() {
    System.out.println(getName() + " has been unequipped.");
  }

  @Override
  public void use() {
    attack();
  }

  @Override
  public boolean isUsable() {
    return getDurability() > 0;
  }

  public void attack() {
    if (!isDestroyed()) {
      System.out.println(getName() + " is used to attack, dealing " + damage + " damage.");
      reduceDurability(1);
      System.out.println("Durability: " + getDurability());
      if (isDestroyed()) {
        System.out.println(getName() + " is broken and cant be used anymore.");
      }
    } else {
      System.out.println(getName() + " is broken and cant be used anymore.");
    }
  }

  public boolean isDestroyed() {
    return getDurability() == 0;
  }

  @Override
  public void repair(int amount) {
    int newDurability = getDurability() + amount;
    setDurability(Math.min(newDurability, material.getBaseDurability()));
    System.out.println(getName() + " has been repaired by " + amount + " points." + " Durability: " + getDurability());
  }

  @Override
  public void takeDamage(int amount) {
    reduceDurability(amount);
    if (isDestroyed()) {
      System.out.println(getName() + " has been destroyed.");
    }
  }

  public int getDamage() {
    return damage;
  }

  public String getWeaponType() {
    return weaponType;
  }

  public Material getMaterial() {
    return material;
  }

  public void displayWeaponStats() {
    System.out.println("Weapon: " + getName());
    System.out.println("Type: " + weaponType);
    System.out.println("Damage: " + damage);
    System.out.println("Durability: " + getDurability());
  }
}
