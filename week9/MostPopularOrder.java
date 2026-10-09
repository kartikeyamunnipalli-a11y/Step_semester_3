import java.util.HashMap;
import java.util.Map;

public class MostPopularOrder {

    public static Object[] mostPopular(String[] orders) {
        Map<String, Integer> counts = new HashMap<>();

        for (String item : orders) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        int maxCount = 0;
        String bestItem = "";

        for (String item : orders) {
            if (counts.get(item) > maxCount) {
                maxCount = counts.get(item);
                bestItem = item;
            }
        }

        return new Object[]{bestItem, maxCount};
    }

    public static void main(String[] args) {
        String[] orders = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};

        Object[] result = mostPopular(orders);
        System.out.println("Item: " + result[0] + ", Count: " + result[1]);
        // Output: Item: dosa, Count: 3
    }
}