package com.company;

public class DictionaryCommandLine extends Dictionary {
    public void showAllWord(){
        int i;

        for (i=0; i< this.list.size(); i++)
        {

            System.out.print(" "+i);
            System.out.print("         |");
            System.out.print(list.get(i).getWord_target());
            System.out.print("      |");
            System.out.println(list.get(i).getWord_explain());

        }
    }
    public void dictionaryBasic(){
        Word keyword = new Word();
        DictionaryManagement nhap = new DictionaryManagement();
        int i;
        for(i=0; i<this.list.size(); i++) {
            nhap.insertFromCommandline(keyword);

        }
        System.out.println(" No        |English      |Vietnamese");

        this.showAllWord();
    }


}
