package uz.b22.service;

public class App4 {
    public static void main(String[] args) {

        int result  = m1();
        System.out.println(result);
    }

    private static int m1() {
        try {
            // System.exit(0);
            return 10;
        }catch (Exception e){
            return 15;
        }finally {
//            System.out.println("finally");
            return 20;
        }
    }
}
