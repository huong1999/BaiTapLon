package com.company;

public class Tests {
    public static void main(String[] args) {
        Word keyword1 = new Word();
        DictionaryCommandLine listWord = new DictionaryCommandLine();
//        DictionaryManagement nhap1 = new DictionaryManagement();
//        nhap1.insertFromCommandline(keyword1);
        listWord.addWord(keyword1);
//        listWord.addWord(keyword);

        listWord.dictionaryBasic();
    }
}
