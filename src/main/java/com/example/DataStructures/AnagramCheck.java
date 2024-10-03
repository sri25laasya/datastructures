package com.example.DataStructures;

//import java.util.Arrays;

public class AnagramCheck {
    public boolean areAnagrams(String s1, String s2) {
        // If lengths of the strings are different, they can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create a frequency array for 26 lowercase letters
        int[] count = new int[26];

        // Increment frequency for characters in s1 and decrement for characters in s2
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        // If all counts are 0, then the strings are anagrams
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        AnagramCheck anagramCheck = new AnagramCheck();
        
        String s1 = "listen";
        String s2 = "silent";
        
        if (anagramCheck.areAnagrams(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams.");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams.");
        }
    }
}

