package dictionary2;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DictionaryManagement{  
   static Dictionary ad = new Dictionary();
   
    public void insertFromFile() {      
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
    
    public String dictionaryLookup(String target) {
        int mark = 1;
        String mean = new String();
        for (Word words : ad.list)
         {
            if (words.getWord_target().equals(target)) {
                mean = words.getWord_explain();
                mark ++;
            }
            else {
                continue;
            }
          }
        if (mark == 1) {
             mean = ("Khong tim thay tu!");
        }
        return mean;
    }
 
    public void removeWord(String target) { 
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
    }
    
    //Chuc nang them du lieu tu dien
    public void addWord(String target, String explain) {
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
      
    public int binarySearch(Dictionary ad, String key) {
        int r = ad.list.size() - 1;
        int l = 0;
        int o = -1;
        int m = 0;
        if (ad.list.get(r).getWord_target().startsWith(key)) {
            o = r;
        } else if (ad.list.get(l).getWord_target().startsWith(key)) {
            o = l;
        } else {

            while (l < r) {
                m = (int) (r + l) / 2;
                if (ad.list.get(m).getWord_target().startsWith(key)) {
                    o = m;
                    break;
                } else if (m == l && l + 1 == r) {
                    return -1;
                } else if (ad.list.get(m).getWord_target().compareTo(key) > 0) {
                    r = m;
                } else {
                    l = m;
                }
            }
            while (o >= 1 && ad.list.get(o - 1).getWord_target().startsWith(key)) {
                o--;
            }
        }
        return o;

    }
    public ArrayList<String> dictionarySearcher(String key) {
       ArrayList<String> targets = new ArrayList<>();
        int id = binarySearch(ad, key);
        if (id != -1) {
            while (ad.list.get(id).getWord_target().startsWith(key)) {
                targets.add(ad.list.get(id).getWord_target());
                //System.out.println(ad.list.get(id).getWord_target() + '\t' + ad.list.get(id).getWord_explain());
                if (id < ad.list.size() - 1) {
                    id++;
                } else {
                    break;
                }
            }
        } else {
            targets.add("Khong tim thay tu!");
        }
        return targets;
    }
        
}