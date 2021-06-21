public class Test {
    public static void main(String[] args) {
        String test = "какой/цвет/green/vet/black";
        String[] result = test.split("/", 3); //разделяет строку
        for (String token:result){
            System.out.println(token);
        }

    }
}
