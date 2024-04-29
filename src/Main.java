import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        String filename14 = "E:\\Nottingham\\documents\\ArtificialIntelligent\\Assignment\\project\\Test\\src\\TEST0014.txt";
        String filename30 = "E:\\Nottingham\\documents\\ArtificialIntelligent\\Assignment\\project\\Test\\src\\TEST0030.txt";
        String filename44 = "E:\\Nottingham\\documents\\ArtificialIntelligent\\Assignment\\project\\Test\\src\\TEST0044.txt";
        String filename49 = "E:\\Nottingham\\documents\\ArtificialIntelligent\\Assignment\\project\\Test\\src\\TEST0049.txt";
        String filename82 = "E:\\Nottingham\\documents\\ArtificialIntelligent\\Assignment\\project\\Test\\src\\TEST0082.txt";

        ReadDataFromFile file14 = new ReadDataFromFile(filename14);
        ReadDataFromFile file30 = new ReadDataFromFile(filename30);
        ReadDataFromFile file44 = new ReadDataFromFile(filename44);
        ReadDataFromFile file49 = new ReadDataFromFile(filename49);
        ReadDataFromFile file82 = new ReadDataFromFile(filename82);
        int[] data14 = file14.readDataFromFile();
        int[] data30 = file30.readDataFromFile();
        int[] data44 = file44.readDataFromFile();
        int[] data49 = file49.readDataFromFile();
        int[] data82 = file82.readDataFromFile();

        Bestfit bestfit14 = new Bestfit(data14);
        System.out.println("TEST0014");
        bestfit14.process();
        Bestfit bestfit30 = new Bestfit(data30);
        System.out.println("TEST0030");
        bestfit30.process();
        Bestfit bestfit44 = new Bestfit(data44);
        System.out.println("TEST0044");
        bestfit44.process();
        Bestfit bestfit49 = new Bestfit(data49);
        System.out.println("TEST0049");
        bestfit49.process();
        Bestfit bestfit82 = new Bestfit(data82);
        System.out.println("TEST0082");
        bestfit82.process();
    }
}