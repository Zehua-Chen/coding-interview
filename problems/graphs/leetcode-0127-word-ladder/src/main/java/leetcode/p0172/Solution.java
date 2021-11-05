package leetcode.p1072;

import java.util.*;

class Solution {
    private boolean diffByOne(String a, String b) {
        int diff = 0;
        
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 1;
    }
    
    private int findPath(String begin, String end, Map<String, Set<String>> edges) {
        var queue = new LinkedList<String>();
        var expanded = new HashSet<String>();
        var previous = new HashMap<String, String>();
        
        queue.add(begin);
        expanded.add(begin);
        
        while (!queue.isEmpty()) {
            String head = queue.remove();
            Set<String> connections = edges.get(head);
            
            if (head.equals(end)) {
                break;
            }
            
            for (String connection: connections) {
                if (expanded.contains(connection)) {
                    continue;
                }
                
                expanded.add(connection);
                queue.add(connection);
                previous.put(connection, head);
            }
        }
        
        int count = 1;
        
        String current = end;
        
        while (!current.equals(begin)) {
            current = previous.get(current);
            count++;
            
            if (current == null) {
                return 0;
            }
        }
        
        return count;
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var edges = new HashMap<String, Set<String>>();
        
        edges.put(beginWord, new HashSet<>());
        
        for (String word : wordList) {
            edges.put(word, new HashSet<>());
        }
        
        Set<String> nodes = edges.keySet();
        
        for (String wordA : nodes) {
            for (String wordB : nodes) {
                if (diffByOne(wordA, wordB)) {
                    var wordAEdges = edges.get(wordA);
                    var wordBEdges = edges.get(wordB);

                    wordAEdges.add(wordB);
                    wordBEdges.add(wordA);
                }
            }
        }
        
        for (String word : edges.keySet()) {
            System.out.printf("%s: ", word);
            Set<String> connections = edges.get(word);
            
            System.out.println(String.join(", ", connections));
        }
        
        return findPath(beginWord, endWord, edges);
    }
}
