class BrowserHistory {

    Map<Integer,String> map;
    int current,max;
    public BrowserHistory(String homepage) {
        current=max=1;
        map = new HashMap<>();
        map.put(current,homepage);
    }

    public void visit(String url) {
        current++;
        map.put(current,url);
        max= current;
    }

    public String back(int steps) {
        current = Math.max(current -steps,1);
        return map.get(current);
    }

    public String forward(int steps) {
        current =Math.min(current +steps,max);
        return map.get(current);
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */