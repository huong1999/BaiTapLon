package com.company;

import java.util.Scanner;

public class DictionaryCommandLine {

    //Phien ban so khai
    public void showAllWord(Dictionary ad) {
        System.out.printf("%-2s     |%-30s|%s\n", "No", "English", "Vietnamese");
        for (int i = 0; i < ad.list.size(); i++) {
            System.out.printf("%-2d     |%-30s|%s\n", i + 1 , ad.list.get(i).getWord_target(), ad.list.get(i).getWord_explain());
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
        System.out.printf("%-14s     |%-30s|%s\n", "No. of word", "English", "Vietnamese");
        if (id != -1) {
            while (ad.list.get(id).getWord_target().startsWith(key)) {
                System.out.printf("%-14d     |%-30s|%s\n", id , ad.list.get(id).getWord_target(), ad.list.get(id).getWord_explain());
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
