public interface Destructible {
  void takeDamage(int damage);

  boolean isDestroyed();

  void repair(int amount);
}
