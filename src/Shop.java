public class Shop {
  private Inventory shopInventory;
  private String shopName;

  public Shop(String shopName) {
    this.shopName = shopName;
    this.shopInventory = new Inventory();
  }

  public void addItemToShop(Item item) {
    shopInventory.addItem(item);
  }

  public void displayShopInventory() {
    System.out.println(shopName + " Inventory:");
    shopInventory.displayInventory();
  }

  public void buyItem(Player player, Item item) {
    if (shopInventory.getItems().contains(item)) {
      if (player.hasEnoughGold(item.getValue())) {
        player.adjustGold(-item.getValue());
        shopInventory.removeItem(item);
        player.addItem(item);
        System.out.println(player.getName() + " has bought " + item.getName() + " for " + item.getValue() + " gold.");
      } else {
        System.out.println(player.getName() + " doesn't have enough gold to buy " + item.getName() + ".");
      }
    } else {
      System.out.println(item.getName() + " is not available in the shop.");
    }
  }

  public void sellItem(Player player, Item item) {
    if (player.getInventory().getItems().contains(item)) {
      int sellPrice = item.getValue() / 2;
      player.adjustGold(sellPrice);
      player.removeItem(item);
      shopInventory.addItem(item);
      System.out.println(player.getName() + " sold " + item.getName() + " for " + sellPrice + " gold.");
    } else {
      System.out.println(player.getName() + " doesn't have " + item.getName() + " to sell.");
    }

  }
}
