public class Bin {
    private int[][] temp;
    private int countBin;

    public Bin(int n) {
        temp = new int[n][n];
        countBin = 0;
    }

    public int bestfit(int[] weight, int c, int n) {
        int[] remainList = new int[n];

        for (int i = 0; i < n; i++) {
            int min = c + 1, bi = 0;
            for (int j = 0; j < countBin; j++) {
                if (remainList[j] >= weight[i] && remainList[j] - weight[i] < min) {
                    bi = j;
                    min = remainList[j] - weight[i];
                }
            }

            if (min == c + 1) {
                remainList[countBin] = c - weight[i];
                temp[countBin][0] = weight[i]; // Assign the weight to the first position in the bin
                countBin++;
            } else {
                remainList[bi] -= weight[i];
                for (int k = 0; k < n; k++) {
                    if (temp[bi][k] == 0) {
                        temp[bi][k] = weight[i]; // Find the first empty slot in the bin and assign the weight
                        break;
                    }
                }
            }
        }
        printBestFitValue(); // Print only the filled bins
        return countBin;
    }

    public void printBestFitValue() {
        for (int i = 0; i < countBin; i++) {
            System.out.print("Bin " + (i + 1) + ": ");
            for (int j = 0; j < temp[i].length; j++) {
                if (temp[i][j] != 0) {
                    System.out.print(temp[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}