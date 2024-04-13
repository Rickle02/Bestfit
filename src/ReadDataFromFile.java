import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromFile {

    public static int[] readDataFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int[] data = new int[10000];
        int index = 0;
        String line;
        boolean isFirstLine = true;
        while ((line = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue; // Skip the first line
            }
            String[] parts = line.trim().split("\\s+");
            for (String part : parts) {
                data[index++] = Integer.parseInt(part);
            }
        }
        reader.close();
        int[] result = new int[index];
        System.arraycopy(data, 0, result, 0, index);
        return result;
    }
}
