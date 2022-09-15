package uz.b22.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {

        String str = "pdp";

        str.substring(-5, 16);

        Scanner scanner=new Scanner(System.in);

        try{
            System.out.print("1-son: ");
            int a=scanner.nextInt();
            System.out.print("2-son: ");
            int b=scanner.nextInt();


            try {
                System.out.println("(a/b) = "+(a/b));
            } catch (ArithmeticException e) {
                System.out.println("Nolga bo'lish mumkin emas");
            }

            System.out.println("(a+b) = "+(a+b));


        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array indeksi bilan ishkal");
        }
        catch (InputMismatchException e){
            System.out.println("Son yozish kerak edi");
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("e = " + e);
            System.out.println("qanday dir xato bo'ldi");
        }


        try {
            int[] arr = {10, 20, 30};

            int t = 0;

            for (int i = 0; i < arr.length ; i++) {
                t += arr[i];
            }

            System.out.println("t = " + t);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
