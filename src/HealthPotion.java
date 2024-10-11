public class HealthPotion extends Consumables {

  public HealthPotion(String name, String description, int quantity, int value, int weight, int durability) {
    super(name, description, quantity, value, weight, durability);
  }

  @Override
  public void use() {
    if (isUsable()) {
      consume();
      reduceDurability(1);
      int currentQuantity = getQuantity();
      if (currentQuantity > 1) {
        setQuantity(currentQuantity - 1);
      } else {
        setUsedUp(true);
      }
    } else {
      System.out.println(getName() + " cannot be used, it's already used up.");
    }
  }

  @Override
  public void consume() {
    System.out.println(getName() + " is consumed, restoring 50 health.");
  }
}
