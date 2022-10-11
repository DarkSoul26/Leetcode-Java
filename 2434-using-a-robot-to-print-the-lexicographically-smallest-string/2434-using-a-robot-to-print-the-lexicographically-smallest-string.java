class Solution {
    public String robotWithString(String s) {
        int[] counter = new int[26];
        for (char c: s.toCharArray()) counter[c -'a']++;

        int idx = 0;
        while (counter[idx] == 0) idx++;

        StringBuffer sb = new StringBuffer();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() - 'a' <= idx)
                sb.append(stack.pop());

            if (c - 'a' <= idx) sb.append(c);
            else stack.push(c);

            counter[c - 'a']--;
            while (idx < 26 && counter[idx] == 0) idx++;
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }
}