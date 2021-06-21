import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        int x = 3;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Vvv.text"));
            writer.write(x);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Vvv.text"));
            int line;
            line = reader.read();
            System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
