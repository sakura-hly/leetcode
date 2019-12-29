package com.sakura.leetcode.top100like;

public class Trie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, TrieNode root) {
        if (word == null || word.length() == 0) {
            root.isWord = true;
            return;
        }
        if (root.children == null) root.children = new TrieNode[26];
        if (root.children[word.charAt(0) - 'a'] == null) root.children[word.charAt(0) - 'a'] = new TrieNode();
        insert(word.substring(1), root.children[word.charAt(0) - 'a']);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode root) {
        if (root == null) return false;
        if (word == null || word.length() == 0) return root.isWord;
        if (root.children == null) return false;
        return search(word.substring(1), root.children[word.charAt(0) - 'a']);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    private boolean startsWith(String prefix, TrieNode root) {
        if (root == null) return false;
        if (prefix == null || prefix.length() == 0) return true;
        if (root.children == null) return false;
        return startsWith(prefix.substring(1), root.children[prefix.charAt(0) - 'a']);
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        System.out.println(trie.search("app"));
    }
}