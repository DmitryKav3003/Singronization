import java.io.*;

public class Buffered implements Serializable{


    public static void main(String[] args) {


        String outputFileName = "file.txt";
        String[] array = { "one", "two", "three", "four" };

        try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String value : array) {
                writter.write(value + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileReaderExample {
    public static void main(String[] args) {
        String inputFileName = "file.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) { //прочитай текст и присвой его значение переменной line
                System.out.println(line + "\n"); //пока тут есть строки для чтения, выводи их на экран
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}