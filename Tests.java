package com.company;

import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {
       DictionaryCommandLine listWord = new DictionaryCommandLine();
       Dictionary ad = new Dictionary();
       DictionaryManagement input = new DictionaryManagement();
       input.insertFromFile(ad);
       System.out.println("TỪ ĐIỂN ANH - VIỆT");
       System.out.println("Các chức năng : ");
       System.out.println("1) Tra Từ ");
       System.out.println("2) Hiển thị toàn bộ dữ liệu trong từ điển ");
       System.out.println("3) Thêm, sửa, xóa dữ liệu trong từ điển ");
       System.out.println("4) Xuất dữ liệu trong từ điển ra file ");
       System.out.println("5) Thoát ");
        Scanner sc = new Scanner(System.in);
        int id;
      do { 
          System.out.print("Nhập lựa chọn chức năng từ điển : ");
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
               System.out.println("1) Thêm dữ liệu ");
               System.out.println("2) Sửa dữ liệu ");
               System.out.println("3) Xóa dữ liệu ");
                System.out.println("4) Thoát ");
               System.out.print("Nhập lựa chọn : ");
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
