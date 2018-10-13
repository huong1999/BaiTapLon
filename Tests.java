package com.company;

import java.util.Scanner;

public class Tests {

    public static void main(String[] args) {
        DictionaryCommandLine listWord = new DictionaryCommandLine();
        Dictionary ad = new Dictionary();
        DictionaryManagement input = new DictionaryManagement();
        input.insertFromFile(ad);
        System.out.println("<====================>   TU DIEN ANH - VIET   <====================>");
        System.out.println("      |      1) Tra tu tuong doi                            |");
        System.out.println("      |      2) Tra tu tuyet doi                            |");
        System.out.println("      |      3) Hien thi toan bo du lieu trong tu dien      |");
        System.out.println("      |      4) Them, sua, xoa du lieu trong tu dien        |");
        System.out.println("      |      5) Xuat du lieu trong tu dien ra file          |");
        System.out.println("      |      6) Thoat                                       |");
        System.out.println("<==================================================================>");
        Scanner sc = new Scanner(System.in);
        int id;
        do {
            System.out.print("Nhap lua chon chuc nang : ");
            id = sc.nextInt();
            while (!(id >= 1 && id <= 6)) {
                System.out.print("Nhap sai, xin nhap lai : ");
                id = sc.nextInt();
            }
            switch (id) {
                case 1: {
                    listWord.dictionarySearcher(ad);
                    break;
                }
                case 2: {
                    input.dictionaryLookup(ad);
                    break;
                }
                case 3: {
                    listWord.showAllWord(ad);
                    break;
                }
                case 4: {
                    System.out.println("1) Them du lieu ");
                    System.out.println("2) Sua du lieu ");
                    System.out.println("3) Xoa du lieu ");
                    System.out.println("4) Thoat ");
                    System.out.print("Nhap lua chon : ");
                    int a = sc.nextInt();
                    while (!(a >= 1 && a <= 4)) {
                        System.out.print("Nhap sai, xin nhap lai : ");
                        a = sc.nextInt();
                    }
                    switch (a) {
                        case 1: {
                            input.addWord(ad);
                            break;
                        }
                        case 2: {
                            input.editWord(ad);
                            break;
                        }
                        case 3: {
                            input.removeWord(ad);
                            break;
                        }
                        case 4: {
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    input.dictionaryExportToFile(ad);
                    break;
                }
                
            }
        } while (id != 6);

    }
}
