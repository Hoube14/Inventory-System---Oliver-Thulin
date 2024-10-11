public class Sword extends Weapon {

  public Sword(String name, String description, int quantity, int value, int weight, int durability,
      int damage, Material material) {
    super(name, description, quantity, value, weight, durability, damage, "Sword", material);
  }

  @Override
  public void attack() {
    if (!isDestroyed()) {
      System.out.println(getName() + " slashes through the air, dealing " + getDamage() + " damage.");
      takeDamage(1);
    } else {
      System.out.println(getName() + " is broken and can't be used anymore.");
    }
  }

}
