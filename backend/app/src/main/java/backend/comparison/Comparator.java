package main.java.backend.comparison;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.lang.Math;
import main.java.backend.conversion.Token;

public class Comparator {
    

    public double compare(ArrayList<Token> list1, ArrayList<Token> list2) {
        return calcJaccard(list1, list2);
    }

    private double calcJaccard(ArrayList<Token> list1, ArrayList<Token> list2) {
        HashSet<Token> set1 = new HashSet<>(list1);
        HashSet<Token> set2 = new HashSet<>(list2);

        Set<Token> intersection = new HashSet<>();
        intersection.addAll(set1);
        intersection.retainAll(set2);

        Set<Token> union = new HashSet<>();
        union.addAll(set1);
        union.addAll(set2);

        System.out.println(intersection);
        System.out.println(union);

        if (union.isEmpty()) {
            return 0.0; // Avoid division by zero
        }

        return (double) intersection.size() / union.size();
        
    }

    private double calcCosine(ArrayList<Token> list1, ArrayList<Token> list2) {
        return 0.0;
    }

    private int calcEditDist()
}
