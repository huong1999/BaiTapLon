package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DictionaryManagement{
    // Phien ban so khai
    public void insertFromCommandline(Dictionary ad) {
        Scanner scan = new Scanner(System.in);
        System.out.print("So luong tu can nhap : ");
        int size = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < size; i++) {
            System.out.print("Nhap tu moi : ");
            String target = scan.nextLine();           
            System.out.print("Nhap nghia : ");
            String explain = scan.nextLine();          
            Word nhapTu = new Word(target, explain);
            ad.list.add(nhapTu);
        }

    }
    
    //Phien ban cai tien lan 1
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
                String vn = str.substring(0,idx);
                String en = str.substring(idx+1);
                Word nhapTu = new Word(vn, en);
                ad.list.add(nhapTu);
            }
        } 
       catch (Exception e){
             System.err.println("getMessage():" + e.getMessage());
         }
    }
    
    public void dictionaryLookup(Dictionary ad) {
        System.out.print("Nhap tu can tim : ");
        Scanner scan = new Scanner(System.in);
        String target = scan.nextLine();
        int mark = 1;
        for (Word words : ad.list)
         {
            if (words.getWord_target().equals(target)) {
                System.out.println(words.getWord_target() + '\t' + words.getWord_explain());
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
    //Phien ban cai tien lan 2
    // Chuc nang xoa du lieu tu dien
    public void removeWord(Dictionary ad) { 
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap tu can xoa khoi tu dien : ");
        String target = scan.nextLine();
        for (Word words : ad.list)
             {
                 if (words.getWord_target().equals(target))
                 {
                     ad.list.remove(words);
                     break;
                 }
              }
    }
    
    // Chuc nang sua du lieu trong tu dien
    public void editWord(Dictionary ad) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap tu can sua trong tu dien : ");
        String target = scan.nextLine();
        System.out.println("Nhap tu vung moi : ");
        String newTarget = scan.nextLine();
        System.out.println("Nhap nghia : ");
        String explain = scan.nextLine();
        
    }
    
    //Chuc nang them du lieu tu dien
    public void addWord(Dictionary ad) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap tu vung can them : ");
        String target = scan.nextLine();
        System.out.println("Nhap nghia : ");
        String explain = scan.nextLine();
        Word words = new Word(target, explain);
        ad.list.add(words);
        Collections.sort(ad.list, new Comparator<Word>()
                {
                    @Override
                    public int compare(Word w1, Word w2)
                    {
                        return (w1.getWord_target().compareTo(w2.getWord_target()));
                    }
                });
    }
    
    public void dictionaryExportToFile(Dictionary ad) {
        System.out.println("Nhap ten file de xuat du lieu : ");
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        try {
            FileWriter writer = new FileWriter(path);
            for (Word word : ad.list) {
                writer.write(word.getWord_target() + "\t" + word.getWord_explain() + "\r\n");
            }
            writer.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
        
}
