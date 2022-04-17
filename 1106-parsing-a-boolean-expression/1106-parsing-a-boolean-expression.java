class Solution {
    
    public boolean parseBoolExpr(String expression) {
	if (expression == null || expression.length() == 0) return false;

	Stack<Character> ops = new Stack<>();
	Stack<Boolean> operands = new Stack<>();

	for (int i = 0; i < expression.length(); i++) {
		char ch = expression.charAt(i);

		if (ch == 'f')
			operands.push(false);
		else if (ch == 't')
			operands.push(true);
		else if (ch == '(')
			operands.push(null);
		else if (ch == ')') {
			char operator = ops.pop();

			boolean res = true;
			if (operator == '|')
				res = false;

			while (!operands.isEmpty() && operands.peek() != null) {
				if (operator == '|') 
					res |= operands.pop();
				else if (operator == '&')
					res &= operands.pop();
				else if (operator == '!')
					res = !operands.pop(); 
			}
			operands.pop();
			operands.push(res);

		} else if (ch == ',') 
			continue;
		else {
			ops.push(ch);
		}
	}
	return operands.peek();
}
}