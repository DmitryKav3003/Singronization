import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;

public class Write {
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Writer");
        fileWriter.write("Hello");
        fileWriter.close();
        //таким образом мы записываем строку, если вдруг наш файл нужно прочитвть не в ява,
        //а например в каком-то текстовом редакторе
    }
}
