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
        try (Scanner scan = new Scanner(new File("dict.txt"))) {
            while(scan.hasNext()){
                String target = scan.next();
                String explain = scan.nextLine();
                Word words = new Word(target, explain);
                ad.list.add(words);
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
             System.out.println("Khong tim thay tu!");
        }
    }
    //Phien ban cai tien lan 2
    // Chuc nang xoa du lieu tu dien
    public void removeWord(Dictionary ad) { 
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap tu can xoa khoi tu dien : ");
        String target = scan.nextLine();
        int mark = 0;
        for (Word words : ad.list)
             {
                 if (words.getWord_target().equals(target))
                 {
                     ad.list.remove(words);
                     System.out.println("Da xoa!");
                     mark ++;
                     break;
                 }
              }
        if (mark == 0) {
            System.out.println("Tu khong co trong tu dien!");
        }
    }
    
    // Chuc nang sua du lieu trong tu dien
     public void editWord(Dictionary ad) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap tu can sua trong tu dien : ");
        String target = scan.nextLine();
        int mark = 0;
        for (Word words : ad.list)
             {
                 if (words.getWord_target().equals(target))
                 {
                     ad.list.remove(words);
                     mark ++;
                     break;
                 }
              }
        if (mark == 0) {
            System.out.println("Khong tim thay tu");
        }
        else {
            System.out.print("Nhap tu da sua : ");
            String newTarget = scan.nextLine();
            System.out.print("Nhap nghia : ");
            String explain = scan.nextLine();
            Word words = new Word(newTarget, explain);
            ad.list.add(words);
            Collections.sort(ad.list, new Comparator<Word>()
                {
                    @Override
                    public int compare(Word w1, Word w2)
                    {
                        return (w1.getWord_target().compareTo(w2.getWord_target()));
                    }
                }); 
          System.out.println("Da sua!");  
        }
    }
    //Chuc nang them du lieu tu dien
    public void addWord(Dictionary ad) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap tu vung can them : ");
        String target = scan.nextLine();
        System.out.print("Nhap nghia : ");
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
        System.out.println("Da them!");
    }
    
    public void dictionaryExportToFile(Dictionary ad) {
        System.out.print("Nhap ten file de xuat du lieu (duoi dang tenFile.txt) : ");
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
   public int binaryseach(Dictionary ad, String key) {
        int r = ad.list.size() -1;
        int l = 0;
        int o = -1;
        int m =0;
        if (ad.list.get(r).getWord_target().startsWith(key))
            o = r;
        else{
        while (l < r) {
             m = (int) (r + l) / 2;
            if (ad.list.get(m).getWord_target().startsWith(key)) { 
                o = m;
                System.out.println("int " + o);
                break;
            } else if (ad.list.get(m).getWord_target().compareTo(key) > 0) {
                r = m;
            } else {
                l = m;
            }
            if (m == l && l + 1 == r)
                return -1;
            }
        }
     
        while (o >= 1 && ad.list.get(o - 1).getWord_target().startsWith(key) ) {
            o--; 
        }
        return o;
    }
        
}
