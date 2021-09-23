package other.gas_station;

import java.util.*;
import java.io.*;

class Main {

    public static String GasStation(String[] strArr) {
        // code goes here
        for(int i = 1; i < strArr.length; i++) {
            if (checkStart(i, strArr)) {
                return String.valueOf(i);
            }
        }
        return "impossible";
    }

    private static boolean checkStart(int startIdx, String[] strArr) {
        int tank = 0;
        int index = startIdx;
        boolean finished = false;
        while(!finished) {
            tank += Integer.valueOf(strArr[index].split(":")[0]);
            tank -= Integer.valueOf(strArr[index].split(":")[1]);
            if (tank < 0) {
                return false;
            }

            if (++index == strArr.length) {
                index = 1;
            }

            if (index == startIdx) {
                finished = true;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(GasStation(new String[] {"4","0:1","2:2","1:2","3:1"}));
    }

}
