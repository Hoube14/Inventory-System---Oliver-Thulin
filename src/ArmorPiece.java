public class ArmorPiece extends Armor {
  private String armorType;

  public ArmorPiece(String name, String description, int quantity, int value, int weight, int durability,
      int defense, Material material, String armorType) {
    super(name, description, quantity, value, weight, durability, defense, material);
    this.armorType = armorType;
  }

  public String getArmorType() {
    return armorType;
  }

  public void setArmorType(String armorType) {
    this.armorType = armorType;
  }

  @Override
  public void displayArmorStats() {
    System.out.println("Armor Type: " + armorType);
    super.displayArmorStats();
  }
}
