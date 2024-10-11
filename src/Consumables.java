public abstract class Consumables extends Item implements Usable {
    protected boolean isUsedUp;

    public Consumables(String name, String description, int quantity, int value, int weight,
            int durability) {
        super(name, description, quantity, value, weight, durability);
    }

    public abstract void consume();

    @Override
    public void use() {
        if (isUsable()) {
            consume();
            reduceDurability(1);

            if (getDurability() <= 0) {
                System.out.println(getName() + " is used up.");
            }
        } else {
            System.out.println(getName() + " cannot be used, it's already used up.");
        }
    }

    public void setUsedUp(boolean isUsedUp) {
        this.isUsedUp = isUsedUp;
    }

    public boolean isUsedUp() {
        return isUsedUp;
    }

    @Override
    public boolean isUsable() {
        return getDurability() > 0;
    }

    protected void reduceQuantity() {
        if (getQuantity() > 0) {
            setQuantity(getQuantity() - 1);
            System.out.println(getName() + " has been consumed. Remaining quantity: " + getQuantity());
        }
    }
}
