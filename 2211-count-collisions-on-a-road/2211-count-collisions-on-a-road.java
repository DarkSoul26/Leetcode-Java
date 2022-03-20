class Solution {

    public int countCollisions(String directions) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : directions.toCharArray()) {
            if (c == 'R') {
                stack.push('R');
            } else if (c == 'S') {
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    stack.pop();
                    res++;
                }
                stack.push('S');
            } else {
                if (!stack.isEmpty() && stack.peek() == 'R') {
                    stack.pop();
                    res += 2;
                    //pop the other 'R'
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        stack.pop();
                        res++;
                    }
                    stack.push('S');
                } else if (!stack.isEmpty() && stack.peek() == 'S') {
                    res++;
                }
            }
        }
        return res;
    }
}