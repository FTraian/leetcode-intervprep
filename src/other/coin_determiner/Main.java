package other.coin_determiner;

import java.util.*;
import java.io.*;

class Main {

    private final static int[] allCoins = {11, 9, 7, 5, 1};

    public static int CoinDeterminer(int num) {
        // code goes here
        LinkedList<Integer> results = new LinkedList<>();
        addCoins(new LinkedList<Integer>(), 0, num, results);

        return results.stream().min(Integer::compare).orElseGet(() -> 0);
    }

    private static void addCoins(LinkedList<Integer> coins, int sum, int num, List<Integer> results) {
        for(int c:allCoins) {
            if (sum + c == num) {
                results.add(coins.size() + 1);
            } else if (sum + c < num) {
                coins.add(c);
                addCoins(coins, sum + c, num, results);
                coins.pop();
            }
        }
    }

    public static void main (String[] args) {
        System.out.print(CoinDeterminer(8));
    }

}
