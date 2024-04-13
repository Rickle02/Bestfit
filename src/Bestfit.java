public class Bestfit {
    private int[][] temp;
    private int countBin;

    public Bestfit(int n) {
        temp = new int[n][n];
        countBin = 0;
    }

    public int[][] getTemp() {
        return temp;
    }

    public void setTemp(int[][] temp) {
        this.temp = temp;
    }

    public int getCountBin() {
        return countBin;
    }

    public void setCountBin(int countBin) {
        this.countBin = countBin;
    }

    public void bestfit(int[] weight, int c, int n) {
        int[] remainList = new int[n];

        for (int i = 0; i < n; i++) {
            int min = c + 1, best = 0;
            for (int j = 0; j < countBin; j++) {
                if (remainList[j] >= weight[i] && remainList[j] - weight[i] < min) {
                    best = j;
                    min = remainList[j] - weight[i];
                }
            }

            if (min == c + 1) {
                remainList[countBin] = c - weight[i];
                temp[countBin][0] = weight[i]; // Assign the weight to the first position in the bin
                countBin++;
            } else {
                remainList[best] -= weight[i];
                for (int k = 0; k < n; k++) {
                    if (temp[best][k] == 0) {
                        temp[best][k] = weight[i]; // Find the first empty slot in the bin and assign the weight
                        break;
                    }
                }
            }
        }
        printBestFitValue(); // Print only the filled bins
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