public class Main{
    public static void main(String[] args) {
        int[] weight = { 2, 5, 4, 7, 1, 3, 8 };
        int capacity = 10;
        int length = weight.length;

        Bin binPackingUtils = new Bin(length);
        System.out.print("Number of bins required in Best Fit :  " + binPackingUtils.bestfit(weight, capacity, length));
    }
}