class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
         Set<String> set = new HashSet<>();
        for (String word : wordList) set.add(word);
        if (!set.contains(endWord))
                return new ArrayList<>();
      
        
        Map<String, Node> next = new HashMap<>();
        Map<String, Node> curr = new HashMap<>();
        curr.put(beginWord, new Node(beginWord));
        
        while (!curr.isEmpty() && !curr.containsKey(endWord)) {
            for (String word : curr.keySet()) {
                Node currNode = curr.get(word);
                StringBuilder sb = new StringBuilder(word);
                boolean stop = false;
                for (int i = 0; i < sb.length() && !stop; i++) {
                    char ori = sb.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(i, c);
                        String key = sb.toString();
                        if (key.equals(endWord)) {
                            if (next.containsKey(endWord)) next.get(endWord).prev.add(currNode);
                            else {
                                Node endNode = new Node(endWord);
                                endNode.prev.add(currNode);
                                next.put(endWord, endNode);
                            }
                            stop = true;
                            break;
                        } else if (set.contains(key)) {
                            if (next.containsKey(key)) next.get(key).prev.add(currNode);
                            else {
                                Node nextNode = new Node(key);
                                nextNode.prev.add(currNode);
                                next.put(key, nextNode);
                            }
                        }
                    }
                    sb.setCharAt(i, ori);
                }
            }
            
            
            for (String word : next.keySet()) set.remove(word);
            Map<String, Node> temp = curr;
            curr = next;
            next = temp;
            next.clear();
        }
        
        Node node = curr.get(endWord);
        return node == null ? new ArrayList<>() : node.output();
    }
    
    class Node {
        String val;
        List<Node> prev;
        
        public Node(String val) {
            this.val = val;
            this.prev = new ArrayList<>();
        }
        
        public List<List<String>> output() {
            List<List<String>> output = new ArrayList<>();
            if (prev.isEmpty()) output.add(new ArrayList<>(Arrays.asList(this.val)));
            else {
                for (Node node : this.prev) {
                    for (List<String> seq : node.output()) {
                        seq.add(this.val);
                        output.add(seq);
                    }
                }
            }
            return output;
        }
    }
}