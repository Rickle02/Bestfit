import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
//        int[] weight = { 2, 5, 4, 7, 1, 3, 8 };
//        int capacity = 10;
//        int length = weight.length;
        String filename = "E:\\Nottingham\\documents\\ArtificialIntelligent\\Assignment\\project\\Test\\src\\TEST0049.txt";
//        File absolutePath1 = new File("E:\\Nottingham\\documents\\ArtificialIntelligent\\Assignment\\project\\Test\\src\\TEST0049.txt");

        int[] data = ReadDataFromFile.readDataFromFile(filename);
        int rows = data[0];
        int capacity = data[1];
        int[][] weightCounts = new int[rows][2];
        for (int i = 0; i < rows; i++) {
            weightCounts[i][0] = data[i * 2 + 2]; // Weight
            weightCounts[i][1] = data[i * 2 + 3]; // Count
        }
        System.out.println("Number of data: " + rows);
        System.out.println("Capacity: " + capacity);
        System.out.println("Data:");
        for (int i = 0; i < rows; i++) {
            System.out.println(weightCounts[i][0] + " " + weightCounts[i][1]);
        }
        int []weight = new int[rows];
        for (int i = 0; i< rows; i++){
            weight[i] = weightCounts[i][0];
        }
        for (int i = 0; i < rows; i++) {
            System.out.println(weight[i]);
        }



        Bestfit bestfit = new Bestfit(rows);
        bestfit.bestfit(weight, capacity, rows);
//        System.out.print("Number of bins required in Best Fit :  " + bestfit.getCountBin());
    }
}