public class Bestfit {
    private int[] data;
    private int[][] temp;
    private int countBin;

    public Bestfit(int[] data) {
        this.data = data;
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

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public void bestfit(int[] weight, int c, int n) {
        this.temp = new int[n][n];
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
        System.out.println("Number of bins required in Best Fit :  " + getCountBin());
        System.out.println();
    }

    public void process(){
        int rows = data[0];
        int capacity = data[1];
        int[][] weightCounts = new int[rows][2];
        for (int i = 0; i < rows; i++) {
            weightCounts[i][0] = data[i * 2 + 2]; // Weight
            weightCounts[i][1] = data[i * 2 + 3]; // Count
        }
        int []weight = new int[rows];
        for (int i = 0; i< rows; i++){
            weight[i] = weightCounts[i][0];
        }
        bestfit(weight, capacity, rows);
    }
}