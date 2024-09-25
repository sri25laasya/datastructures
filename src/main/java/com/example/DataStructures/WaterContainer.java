package com.example.DataStructures;
import java.util.Scanner;
public class WaterContainer {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int width = r - l;
            int minHeight = Math.min(height[l], height[r]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }}
        return maxArea;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of containers: ");
        int n = scanner.nextInt();
        int[] height = new int[n];
        System.out.println("Enter the heights of the containers:");
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        WaterContainer solution = new WaterContainer();
        System.out.println("Maximum area of water: " + solution.maxArea(height));
        scanner.close();
    }}