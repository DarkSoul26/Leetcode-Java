class Solution {
    public int totalMoney(int n) {
    	int mondaySavings = 1;
    	int savings = 0;
    	int daySavings = mondaySavings;
    	for(int i = 1; i <= n; i++) {
    		if(i == 1) {
    			savings += mondaySavings;
    		}else {
    			if(i % 7 == 1) {
    				savings += ++mondaySavings;
    				daySavings = mondaySavings;
    			}else {
    				savings += ++daySavings;
    			}
    		}
    	}
    	return savings;
    }
}