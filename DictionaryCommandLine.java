package com.company;

public class DictionaryCommandLine{
    Dictionary word = new Dictionary();
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
        input.insertFromCommandline(word);// them tu
        showAllWord(word);   //in ra cac tu da nhap
    }
}
