import java.io.*;

public class People {
    static final long serialVersionID = 8167471624091168737L;

    public static void main(String[] args) throws Exception{
            Options options = new Options();
            options.getX();
            options.getName();
try {

    FileOutputStream fileOutputStream = new FileOutputStream("Text");
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(options);
    objectOutputStream.close();

    FileInputStream fileInputStream = new FileInputStream("Text");
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    options = (Options) objectInputStream.readObject();
    objectInputStream.close();
    System.out.println(options.getX());
    System.out.println(options.getName());
}
catch (Exception e){
    e.printStackTrace();
}
    }
}
