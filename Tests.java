package com.company;

import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {
       DictionaryCommandLine listWord = new DictionaryCommandLine();
       Dictionary ad = new Dictionary();
       DictionaryManagement input = new DictionaryManagement();
       input.insertFromFile(ad);
       System.out.println("TU DIEN ANH - VIET");
       System.out.println("Cac chuc nang : ");
       System.out.println("1) Tra tu ");
       System.out.println("2) Hien thi toan bo du lieu trong tu dien ");
       System.out.println("3) Them, sua, xoa du lieu trong tu dien ");
       System.out.println("4) Xuat du lieu trong tu dien ra file ");
       System.out.println("5) Thoat ");
        Scanner sc = new Scanner(System.in);
        int id;
      do { 
          System.out.print("Nhap lua chon chuc nang trong tu dien : ");
           id = sc.nextInt();
           while (!(id >= 1 && id <=5 ))
       {
           System.out.print("Nhap sai, xin nhap lai : ");
           id = sc.nextInt();    
       }
          switch (id) {
           case 1 : 
           {
               listWord.dictionarySearcher(ad);
               break;
           }
           case 2 :
           {
               listWord.showAllWord(ad);
               break;
           }
           case 3 :
           {
               System.out.println("1) Them du lieu ");
               System.out.println("2) Sua du lieu ");
               System.out.println("3) Xoa du lieu ");
                System.out.println("4) Thoat ");
               System.out.print("Nhap lua chon : ");
               int a = sc.nextInt();
               while (!(a >= 1 && a <=4 ))
                    {
                        System.out.print("Nhap sai, xin nhap lai : ");
                        a = sc.nextInt();    
                    }
               switch(a) {
                   case 1 : 
                   {
                       input.addWord(ad);
                       break;
                   }
                   case 2 : 
                   {
                       input.editWord(ad);
                       break;
                   }
                   case 3 : 
                   {
                       input.removeWord(ad);
                       break;
                   }
                   case 4 :
                   {
                       break;
                   }
               }
               break;
           }
           case 4 :
           {
               input.dictionaryExportToFile(ad);
               break;
           }
       } }
      while (id != 5);

    }
}
