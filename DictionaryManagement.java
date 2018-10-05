package com.company;

import java.util.Scanner;
import java.io.File;

public class DictionaryManagement {

    public void insertFromCommandline(Dictionary ad) {
        Scanner scan = new Scanner(System.in);
        System.out.print("So luong tu can nhap : ");
        int size = scan.nextInt();
        String target, explain;
        scan.nextLine();
        for (int i = 0; i < size; i++) {
            Word nhapTu = new Word();
            System.out.print("Nhap tu moi : ");

            target = scan.nextLine();            //nhap tu tieng Anh
            nhapTu.setWord_target(target);

            System.out.print("Nhap nghia : ");

            explain = scan.nextLine();           //nhap nghĩa tieng Viet
            nhapTu.setWord_explain(explain);
            ad.list.add(nhapTu);
        }

    }

    public void insertFromFile(Dictionary ad) {

        try (Scanner sc = new Scanner(new File("dictionaries.txt"))) {
            String str;

            while (sc.hasNext()) {

                str = sc.nextLine();
                Word nhapTu = new Word();
                int idx = 0;
                for (int i = 0; i < str.length(); i++) {

                    if (str.charAt(i) == '\t') {
                        idx = i;
                        break;
                    }
                }
                
                String vn = str.substring(0, idx);
                String en = str.substring(idx + 1);
                nhapTu.setWord_target(vn);
                nhapTu.setWord_explain(en);
                ad.list.add(nhapTu);
            }
            
        } catch (Exception e) {
        }
    }

    public void dictionaryLookup(Dictionary ad) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap tu can tim ");
        String find = scan.nextLine();
        int num = 1;

        for (Word element : ad.list) {
            if (element.getWord_target().contains(find)) {
                System.out.printf("|%-7d|%-50s|%-50s|\n",num, element.getWord_target(), element.getWord_explain());
            } else {
                num++;
            }
        }

    }
}
