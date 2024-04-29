import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

public class Bestfit  {
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
            int min = c, best = 0;
            for (int j = 0; j < countBin; j++) {
                if (remainList[j] >= weight[i] && remainList[j] - weight[i] < min) {
                    best = j;
                    min = remainList[j] - weight[i];
                }
            }

            if (min == c) {
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
//        drawBarChart();
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


//    private void drawBarChart() {
//        launch();
//    }
//
//    @Override
//    public void start(Stage stage) {
//        final CategoryAxis xAxis = new CategoryAxis();
//        final NumberAxis yAxis = new NumberAxis();
//        final BarChart<String, Number> barChart =
//                new BarChart<>(xAxis, yAxis);
//        barChart.setTitle("Bin Utilization");
//        xAxis.setLabel("Bins");
//        yAxis.setLabel("Total Weight");
//
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        for (int i = 0; i < getCountBin(); i++) {
//            int sum = 0;
//            for (int j = 0; j < temp[i].length; j++) {
//                if (temp[i][j] != 0) {
//                    sum += temp[i][j];
//                }
//            }
//            series.getData().add(new XYChart.Data<>("Bin " + (i + 1), sum));
//        }
//
//        Scene scene = new Scene(barChart, 800, 600);
//        barChart.getData().add(series);
//
//        stage.setScene(scene);
//        stage.show();
//    }

    public void process(){
        int rows = data[0];
        int capacity = data[1];
        int[][] weightCounts = new int[rows][2];
        for (int i = 0; i < rows; i++) {
            weightCounts[i][0] = data[i * 2 + 2]; // Weight
            weightCounts[i][1] = data[i * 2 + 3]; // Count
        }
        // Calculate the total size of weight[] array
        int totalWeights = 0;
        for (int i = 0; i < rows; i++) {
            totalWeights += weightCounts[i][1]; // Add count of each weight
        }

        // Populate weight[] array
        int[] weight = new int[totalWeights];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            int weightValue = weightCounts[i][0];
            int count = weightCounts[i][1];
            for (int j = 0; j < count; j++) {
                weight[index++] = weightValue; // Repeat weight according to count
            }
        }
        bestfit(weight, capacity, rows);
    }
}