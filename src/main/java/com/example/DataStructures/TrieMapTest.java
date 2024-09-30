package com.example.DataStructures;

import java.util.HashMap;
import java.util.Map;

// Node class representing each character in the Trie
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

// TrieMap class representing the whole Trie structure
class TrieMap {
    private TrieNode root;

    public TrieMap() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
        }
        return current.isEndOfWord;
    }

    // Check if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    // Delete a word from the Trie (optional, more advanced)
    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false; // Word not found
            }
            current.isEndOfWord = false;
            return current.children.isEmpty(); // If leaf node, allow deletion
        }
        char c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if (node == null) {
            return false; // Word not found
        }
        boolean shouldDeleteNode = delete(node, word, index + 1);
        if (shouldDeleteNode) {
            current.children.remove(c);
            return current.children.isEmpty() && !current.isEndOfWord;
        }
        return false;
    }
}

public class TrieMapTest {
    public static void main(String[] args) {
        TrieMap trie = new TrieMap();
        trie.insert("hello");
        trie.insert("hey");
        trie.insert("world");

        System.out.println(trie.search("hello")); // true
        System.out.println(trie.search("hell"));  // false
        System.out.println(trie.startsWith("he")); // true
        System.out.println(trie.startsWith("wo")); // true
        System.out.println(trie.delete("hello"));  // true (if deleted)
        System.out.println(trie.search("hello"));  // false
    }
}
