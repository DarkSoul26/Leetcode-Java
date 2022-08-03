class ListNode {
    public int start, end;
    public ListNode next;
    public ListNode(int s, int e, ListNode n) {
        start = s;
        end = e;
        next = n;
    }
}

class MyCalendar {
    ListNode calendar;
    public MyCalendar() {
        ListNode tail = new ListNode(Integer.MAX_VALUE, Integer.MAX_VALUE, null);
        calendar = new ListNode(-1, -1, tail);
    }
    
    public boolean book(int start, int end) {
        ListNode curr = calendar, last = curr;
        while (start >= curr.end) {
            last = curr;
            curr = curr.next;
        }
        if (curr.start < end)
            return false;
        last.next = new ListNode(start, end, curr);
        return true;
    }
}