import java.util.Arrays;

public class MergeTokenQueues {

    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        int nA = counterA.length;
        int nB = counterB.length;
        int[] merged = new int[nA + nB];

        int i = 0, j = 0, k = 0;

        while (i < nA && j < nB) {
            if (counterA[i] <= counterB[j]) {
                merged[k++] = counterA[i++];
            } else {
                merged[k++] = counterB[j++];
            }
        }

        while (i < nA) {
            merged[k++] = counterA[i++];
        }

        while (j < nB) {
            merged[k++] = counterB[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] counterA = {3, 8, 15, 20};
        int[] counterB = {5, 8, 12};

        int[] result = mergeTokens(counterA, counterB);
        System.out.println(Arrays.toString(result));
        // Output: [3, 5, 8, 8, 12, 15, 20]
    }
}