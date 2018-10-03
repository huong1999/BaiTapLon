package com.company;

import java.util.Scanner;

public class DictionaryManagement {
    
    public void insertFromCommandline(Dictionary ad) {
        Scanner scan = new Scanner(System.in);
        System.out.print("So luong tu can nhap : ");
        int size = scan.nextInt();
        String target,explain;
        scan.nextLine();
        for(int i = 0; i < size; i++) {
            Word nhapTu= new Word();
            System.out.print("Nhap tu moi : ");

            target = scan.nextLine();            //nhap tu tieng Anh
            nhapTu.setWord_target(target);

            System.out.print("Nhap nghia : ");

            explain = scan.nextLine();           //nhap nghĩa tieng Viet
            nhapTu.setWord_explain(explain);
            ad.list.add(nhapTu);
        }

    }
}
