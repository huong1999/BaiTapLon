package com.company;

import java.util.Scanner;

public class DictionaryCommandLine{
    
    //Phien ban so khai
    public void showAllWord(Dictionary ad) {   
        System.out.println(" No         |English    |Vietnamese");
        int j = 1;
        for (int i = 0; i < ad.list.size(); i++) {

            System.out.print(" " + j);
            System.out.print("          |");
            System.out.print(ad.list.get(i).getWord_target());
            System.out.print("         |");
            System.out.println(ad.list.get(i).getWord_explain());
            j++;
        }
    }
    
    public void dictionaryBasic() {
        Dictionary word = new Dictionary();
        DictionaryManagement input = new DictionaryManagement();     
        input.insertFromCommandline(word);
        showAllWord(word);
    }
    
    //Phien ban cai tien lan 1
    public void dictionaryAdvanced() {
        Dictionary word = new Dictionary();
        DictionaryManagement input = new DictionaryManagement();
        input.insertFromFile(word);
        input.dictionaryLookup(word);
        showAllWord(word);
    }
    
    //Phien ban cai tien lan 2
    
    public void dictionarySearcher(Dictionary ad) {
        DictionaryManagement input = new DictionaryManagement();
        System.out.print("Nhap tu can tra : ");
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        int id = input.binarySearch(ad, key);
        if (id != -1) {
            while (ad.list.get(id).getWord_target().startsWith(key)) {
                System.out.println(ad.list.get(id).getWord_target() + '\t' + ad.list.get(id).getWord_explain());
                if (id < ad.list.size() - 1) {
                    id++;
                } else {
                    break;
                }
            }
        } else {
            System.out.println("Khong tim thay tu!");
        }
    }
}
