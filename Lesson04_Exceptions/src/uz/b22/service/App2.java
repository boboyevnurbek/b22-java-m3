package uz.b22.service;

public class App2 {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().maxMemory() / 1024. / 1024 / 1024);

        //byte[] arr = new byte[1_000_000_000];
        //int[] arr = new int[1_000_000_000];
        // System.out.println(arr[2]);

        recursion();
    }

    private static  int counter = 0;

    private static void recursion() {
        System.out.println("counter = "+(++counter));
        recursion();
    }


}
