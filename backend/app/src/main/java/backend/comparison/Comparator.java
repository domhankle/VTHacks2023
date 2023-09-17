package main.java.backend.comparison;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.lang.Math;
import main.java.backend.conversion.Token;
import main.java.backend.conversion.TokenType;

public class Comparator {
    

    public double compare(ArrayList<Token> list1, ArrayList<Token> list2) {
        return (calcJaccard(list1, list2) + calcEditDistance(list1, list2)) / 2.0;
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
            return 0.0;
        }

        return (double) intersection.size() / union.size();
        
    }

    private double calcCosine(ArrayList<Token> list1, ArrayList<Token> list2) {
        return 0.0;
    }

    
    private double calcEditDistance(ArrayList<Token> list1, ArrayList<Token> list2) {
        int m = list1.size();
        int n = list2.size();

        double[][] dp = new double[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int distance = calcObjectDistance(list1.get(i - 1), list2.get(j - 1));

                    dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + distance
                    );
                }
            }
        }

        // Normalize and return the edit distance
        double maxPossibleDistance = 100;
        return 1.0 - (dp[m][n] / maxPossibleDistance);
    }

    private int calcObjectDistance(Token tok1, Token tok2) {
        // If tok1 and tok2 are both user defined they are equal
        if (tok1.getType().equals(TokenType.USER_DEFINED) && tok2.getType().equals(TokenType.USER_DEFINED)) {
            return 0;
        } else {
            return calcStringDistance(tok1.toString(), tok2.toString());
        }
    }

    private static int calcStringDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + cost
                    );
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
