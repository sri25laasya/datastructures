package com.example.DataStructures;

public class ZeroBruteForce {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZerosToEnd(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void moveZerosToEnd(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] != 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
    }
}
