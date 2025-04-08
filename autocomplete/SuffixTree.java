package com.example.autocomplete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SuffixTree {
    class Node {
        HashMap<Character, Node> children = new HashMap<>();
        boolean isEndOfWord;
        List<Integer> indexes = new ArrayList<>();

        public Node() {
            this.isEndOfWord = false;
        }
    }

    private final Node root;
    private final String text;
    private final List<String> titles;

    public SuffixTree(String text, List<String> titles) {
        this.root = new Node();
        this.text = text;
        this.titles = titles;
        buildSuffixTree();
    }

    private void buildSuffixTree() {
        for (int i = 0; i < text.length(); i++) {
            insertSuffix(text.substring(i), i);
        }
    }

    private void insertSuffix(String suffix, int index) {
        Node current = root;
        for (char c : suffix.toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new Node());
            current.indexes.add(index);
        }
        current.isEndOfWord = true;
    }

    public List<String> findByPrefix(String prefix) {
        Node current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return List.of();
            }
            current = current.children.get(c);
        }

        return collectTitlesStartingWith(current, prefix);
    }

    private List<String> collectTitlesStartingWith(Node node, String prefix) {
        List<String> results = new ArrayList<>();
        for (int index : node.indexes) {
            int startIndex = text.lastIndexOf('#', index - 1) + 1;
            int endIndex = text.indexOf('#', startIndex);

            if (startIndex != -1 && endIndex != -1) {
                String title = text.substring(startIndex, endIndex);
                if (title.startsWith(prefix) && !results.contains(title)) {
                    results.add(title);
                }
            }
        }
        return results;
    }
}
