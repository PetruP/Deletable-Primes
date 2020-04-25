package ro.problemeCC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DeletablePrimes {

    private static int ways = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        reduceNumber(n);
        System.out.println("Ways: " + ways);
    }

    private static void reduceNumber(long nr ) {
        ArrayList<Integer> arr = longToArray(nr);
        if (!isPrime(nr)) {
            return;
        } else if (arr.size() == 1) {
            ways++;
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Integer> arr2 = new ArrayList<Integer>(arr);
            arr2.remove(i);
            reduceNumber(arrayToLong(arr2));
        }
    }


    private static long arrayToLong(ArrayList<Integer> arr) {
        long suma = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            suma += arr.get(i) * Math.pow(10, arr.size() - i - 1);
        }
        return suma;
    }

    private static ArrayList<Integer> longToArray(long nr) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        long x = nr;
        int i = 0;
        int nrC = 0;
        while (x != 0) {
            long c = x % 10;
            nrC++;
            arr.add((int) c);
            i++;
            x = x / 10;
        }
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        int j = 0;
        for (i = nrC - 1; i >= 0; i--) {
            arr2.add(arr.get(i));
            j++;
        }
        return arr2;
    }

    public static boolean isPrime(long number) {
        if (number == 1 || number == 0) {
            return false;
        }
        long sq = (long) Math.sqrt(number);
        for (long i = 2; i <= sq; i++) {
            if (number % i == 0) {
                return false; //number is divisible so its not prime
            }
        }
        return true;  //number is prime now
    }

}
