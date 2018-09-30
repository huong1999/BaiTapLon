package com.company;

import java.util.ArrayList;

public class Dictionary {

    ArrayList<Word> list = new ArrayList<Word>();

    public void addWord(Word word) {
        list.add(word);
    }
}
