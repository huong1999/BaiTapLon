package com.company;

import java.io.File;
import java.util.Scanner;
//import java.io.FileReader;

public class DictionaryManagement{
    
    public void insertFromCommandline(Dictionary ad) {
        Scanner scan = new Scanner(System.in);
        System.out.print("So luong tu can nhap : ");
        int size = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < size; i++) {
            System.out.print("Nhap tu moi : ");
            String target = scan.nextLine();            //nhap tu tieng Anh
            System.out.print("Nhap nghia : ");
            String explain = scan.nextLine();           //nhap nghĩa tieng Viet
            Word nhapTu = new Word(target, explain);
            ad.list.add(nhapTu);
        }

    }
    
         public void insertFromFile(Dictionary ad) {

        
        
       try (Scanner sc = new Scanner(new File("Dictionary.txt"))) {
            String str;
 
            while (sc.hasNext()) {
              
                str = sc.nextLine();
                int idx = 0;
                for (int i = 0; i < str.length(); i++) {
                
                    if (str.charAt(i) == '\t') {
                        idx = i;
                        
                        break;
                    }

                }            
                String vn   = str.substring(0,idx);
                String en   = str.substring(idx+1);
                Word nhapTu = new Word(vn, en);
                ad.list.add(nhapTu);
            }
        } 
       catch (Exception e){
             System.err.println("getMessage():" + e.getMessage());
         }
}
         public void dictionaryLookup(Dictionary ad)
         {
             System.out.print("Nhap tu can tim : ");
             Scanner scan = new Scanner(System.in);
             String target = scan.nextLine();
             int mark = 1;
             for (Word words : ad.list)
             {
                 if (words.getWord_target().contains(target))
                 {
                    System.out.println(mark + ")    " + words.getWord_target() + '\t' + words.getWord_explain());
                    mark ++;
                 }
                 else {
                     continue;
                 }
             }
             if (mark == 1) {
                 System.out.println("Khong tim thay tu can nhap");
             }
         }

}
