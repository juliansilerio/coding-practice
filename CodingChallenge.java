// Julian Silerio
// From Erin Kogan, Beespoke Consulting
// Completed 10/29/2018

import java.util.Arrays;
public class CodingChallenge {

    // zips alternating digits of integers a and b into a single string
    public static int integerZip(int a, int b) {

        // convert integers to char arrays for operations
        char[] a_arr = String.valueOf(a).toCharArray();
        char[] b_arr = String.valueOf(b).toCharArray();

        // new char array for new integer to be zipped
        char[] new_arr = new char[a_arr.length + b_arr.length];

        // if new arr length is greater than 9, new int is greater
        // than 100,000,000, so return -1
        if(new_arr.length > 9) {
            return -1;
        }

        // new indices for array manipulation
        int ind = 0;
        int new_arr_ind = 0;

        // while the index is less than the length of both integers a and b
        while( ind < a_arr.length && ind < b_arr.length ) {
            new_arr[new_arr_ind++] = a_arr[ind];
            new_arr[new_arr_ind++] = b_arr[ind++];
        }

        // while its only less than length of a, used to append extra values
        // ind > b_arr.length at this point
        while( ind < a_arr.length ) {
            new_arr[new_arr_ind++] = a_arr[ind++];
        }

        // while its only less than length of b, used to append extra values
        // ind > a_arr.length at this point
        while( ind < b_arr.length ) {
            new_arr[new_arr_ind++] = b_arr[ind++];
        }

        // parse int from string of char[]
        int new_int = Integer.parseInt(new String(new_arr));

        // one last check to see if it's greater than 100,000,000
        if (new_int > 100000000) {
            return -1;
        }

        return new_int;
    }

    // given an array and a sum, find a pair in the array that adds to the sum
    // returns int of two indexes of the integers in array or [-1, -1] if not there
    // looks at a given index i in arr and sums it with evrey index after it j
    // if arr[i] + arr[j] = sum, returns [i, j]
    // runtime: n log n, where n is the length of the arr
    public static int[] sumFind(int[] arr, int sum) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String args[]) {
        // testing integerZip
        System.out.println("Testing integerZip...");

        System.out.println(integerZip(12, 34));
        System.out.println("Expected 1324\n");

        System.out.println(integerZip(12345, 678));
        System.out.println("Expected 16273845\n");

        System.out.println(integerZip(1234, 0));
        System.out.println("Expected 10234\n");

        System.out.println(integerZip(12345, 12345));
        System.out.println("Expected -1\n");

        System.out.println(integerZip(10000, 1000));
        System.out.println("Expected -1\n");

        System.out.println("...integerZip tests done!\n");

        // testing sumFind
        System.out.println("\nTesting sumFind...");

        System.out.println(Arrays.toString(sumFind(new int[] {7, 3, -1, -1}, 6)));
        System.out.println("Expected [0,2]\n");

        System.out.println(Arrays.toString(sumFind(new int[] {7, 3, -1, -1}, 12)));
        System.out.println("Expected [-1, -1]\n");

        System.out.println(Arrays.toString(sumFind(new int[] {-8, -8, -1, -15}, -16)));
        System.out.println("Expected [0, 1]\n");

        System.out.println(Arrays.toString(sumFind(new int[] {-8, -9, -1, -15}, -16)));
        System.out.println("Expected [2, 3]\n");

        System.out.println(Arrays.toString(sumFind(new int[] {-1, -1, -1, -1, -1, -1, 1, 1}, 2)));
        System.out.println("Expected [6, 7]\n");

        System.out.println("...sumFind tests done!");
    }
}
