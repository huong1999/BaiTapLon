package com.company;

public class DictionaryCommandLine extends Dictionary {
    public void showAllWord() {
        int i;
        System.out.println(" No     |English    |Vietnamese");
        for (i = 1; i <= 3; i++) {

            System.out.print(" " + (i));
            System.out.print("         |");
            System.out.print(list.get(i-1).getWord_target());
            System.out.print("      |");
            System.out.println(list.get(i-1).getWord_explain());

        }
    }

    public void dictionaryBasic() {

        Word keyword1 = new Word();
        Word keyword2 = new Word();
        Word keyword3 = new Word();
        DictionaryManagement input = new DictionaryManagement();
        input.insertFromCommandline(keyword1);
        addWord(keyword1);
        input.insertFromCommandline(keyword2);
        addWord(keyword2);
        input.insertFromCommandline(keyword3);
        addWord(keyword3);
        this.showAllWord();
    }
}
