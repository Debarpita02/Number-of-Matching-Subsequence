class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<Character, Queue<String>> map = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<>());
        }

        for (String word : words) {
            map.get(word.charAt(0)).offer(word);
        }

        for (char c : s.toCharArray()) {
            Queue<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).offer(word.substring(1));
                }
            }
        }

        return count;
    }
}
