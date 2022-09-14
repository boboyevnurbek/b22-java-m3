package uz.b22.service;

import java.util.Date;

public class App3 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("date = " + date);

        Date expiredDate = new Date(date.getTime() + 30 * 60 * 1000);
        System.out.println("expiredDate = " + expiredDate);

        // .....
//        if (new Date().before(expiredDate)) {
//            if(passwords){
//                // ....
//            }
//        }


    }
}
