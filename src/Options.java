import java.io.ObjectStreamClass;
import java.io.Serializable;

public class Options implements Serializable {
    private int x = 10;
    transient private String name = "Alex";  //не сохраняем этот тип, намеренно его пропускаем

    public String getName() {
        return name;
    }
    public int getX() {
        return x;
    }

    public static void main(String[] args) {
        ObjectStreamClass c = ObjectStreamClass.lookup(Buffered.class);
        long serialID = c.getSerialVersionUID();
        System.out.println(serialID);

    }
}
