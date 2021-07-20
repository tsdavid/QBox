package com.dk.codingTest.DeliveryHero4;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        String a = "nvoices.pdf";
        String b = a.substring(a.lastIndexOf("."));

        ArrayList<String> fileCriteria = new ArrayList<>();
        fileCriteria.add(".doc"); fileCriteria.add(".xls"); fileCriteria.add(".pdf");
        if(fileCriteria.contains(b)){
            System.out.println("Heelo");
        }
    }
}
