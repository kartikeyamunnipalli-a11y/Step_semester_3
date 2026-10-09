import java.util.Arrays;

public class WarehouseGridSummary {

    public static Object[] warehouseSummary(int[][] grid) {
        int totalItems = 0;
        int maxVal = -1;
        int[] maxCoord = new int[]{0, 0};

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                totalItems += val;

                if (val > maxVal) {
                    maxVal = val;
                    maxCoord[0] = r;
                    maxCoord[1] = c;
                }
            }
        }

        return new Object[]{totalItems, maxCoord};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        Object[] result = warehouseSummary(grid);
        int total = (int) result[0];
        int[] coord = (int[]) result[1];

        System.out.println("Total Items: " + total + ", Max Position: " + Arrays.toString(coord));
        // Output: Total Items: 49, Max Position: [2, 1]
    }
}