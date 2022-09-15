import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        // random ni ishlatish
//
//        // 1-usul
//        double num1 = Math.random();
//        System.out.println("num1 = " + num1);
//
//        // 2-usul
        Random random = new Random();
//        int num2 = random.nextInt(100); // 0..99
//        System.out.println("num2 = " +

        for (int i = 26; i <= 27; i++) {
            System.out.println(i + " -> "+random.nextInt(1, 3));
        }
    }
}
