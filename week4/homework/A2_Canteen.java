class Item {
    private final String itemName;
    private int stock;

    public Item(String itemName, int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Initial stock cannot be negative");
        }
        this.itemName = itemName;
        this.stock = stock;
    }

    public void restock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Restock quantity cannot be negative");
        }
        stock += quantity;
    }

    public void printStock() {
        System.out.println(itemName + " | Final Stock: " + stock);
    }
}

public class A2_Canteen {
    public static void main(String[] args) {
        Item[] items = {
                new Item("Samosa", 15),
                new Item("Tea Powder", 40),
                new Item("Bread", 8),
                new Item("Biscuit Packs", 25)
        };

        for (Item item : items) {
            item.restock(20);
            item.printStock();
        }
    }
}