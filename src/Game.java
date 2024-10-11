public class Game {
    public static void main(String[] args) {
        // TESTPROGRAM DEL 1
        Player player = new Player("Hero", 100, 2000);
        Inventory playerInventory = player.getInventory();
        Shop shop = new Shop("Adventurer's Emporium");

        System.out.println("\n--- Inventory Actions ---");

        Sword sword = new Sword("Iron Sword", "A sharp iron sword", 1, 100, 5, 25, 10, Material.IRON);
        ArmorPiece helmet = new ArmorPiece("Steel Helmet", "A sturdy steel helmet", 1, 150, 3, 50, 8,
                Material.STEEL, "Helmet");
        HealthPotion potion = new HealthPotion("Health Potion", "Restores 50 health", 3, 50, 1, 1);

        player.addItem(sword);
        player.addItem(helmet);
        player.addItem(potion);

        System.out.println("Player's Inventory after adding items:");
        playerInventory.displayInventory();

        System.out.println("\n--- Removing Health Potion ---");
        player.removeItem(potion);
        playerInventory.displayInventory();

        System.out.println("\n--- Using Items ---");
        player.equipWeapon(sword);
        player.attackWithWeapon(sword);
        sword.repair(1);
        player.equipArmor(helmet);

        System.out.println("\n--- Player takes damage and uses Health Potion ---");
        player.takeDamage(20);
        player.addItem(potion);
        player.useConsumable(potion);

        System.out.println("\nFinal Player Inventory and equipped items:");
        playerInventory.displayInventory();
        System.out.println("Equipped Items: ");
        for (Item item : player.getEquippedItems()) {
            System.out.println("- " + item.getName());
        }

        // TESTPROGRAM DEL 2
        System.out.println("\n--- Shop and Player Interaction ---");

        ArmorPiece chestplate = new ArmorPiece("Mithril Chestplate", "A magical mithril chestplate", 1, 300, 7,
                80, 15, Material.MITHRIL, "Chestplate");
        Weapon axe = new Weapon("Adamantite Axe", "A powerful adamantite axe", 1, 200, 10, 60, 20, "Axe",
                Material.ADAMANTITE);
        HealthPotion regularPotion = new HealthPotion("Health Potion", "Restores 50 health", 5, 50, 1, 1);

        shop.addItemToShop(chestplate);
        shop.addItemToShop(axe);
        shop.addItemToShop(regularPotion);

        shop.displayShopInventory();

        System.out.println("\n--- Player Buys Items from Shop ---");
        System.out.println("Player buys the Mithril Chestplate from the shop.");
        shop.buyItem(player, chestplate);

        System.out.println("\nPlayer Inventory after purchases:");
        player.getInventory().displayInventory();

        System.out.println("\n--- Player Equips Mithril Chestplate ---");
        player.equipArmor(chestplate);

        System.out.println("\n--- Player Sells Mithril Chestplate to the Shop ---");
        player.unequipArmor(chestplate);
        shop.sellItem(player, chestplate);

        System.out.println("\n--- Final Inventory and Shop States ---");
        System.out.println("Player Inventory:");
        player.getInventory().displayInventory();
        System.out.println("Equipped Items: ");
        for (Item item : player.getEquippedItems()) {
            System.out.println("- " + item.getName());
        }

        System.out.println("\nShop Inventory:");
        shop.displayShopInventory();
    }
}
