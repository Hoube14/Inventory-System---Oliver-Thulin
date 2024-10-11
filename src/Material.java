public enum Material {
  WOOD(10, 0.5),
  IRON(25, 1.0),
  STEEL(40, 3),
  MITHRIL(60, 5),
  ADAMANTITE(80, 10);

  private final int baseDurability;
  private final double weightMultiplier;

  Material(int baseDurability, double weightMultiplier) {
    this.baseDurability = baseDurability;
    this.weightMultiplier = weightMultiplier;
  }

  public int getBaseDurability() {
    return baseDurability;
  }

  public double getWeightMultiplier() {
    return weightMultiplier;
  }
}
