class Item {
    String itemName;
    int stock;

    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public void restock(int stock) {
        this.stock += stock;
    }

    public void printStock() {
        System.out.println(itemName + " | Final Stock: " + stock);
    }
}
