class MyCircularQueue {
    private int tail, head, size, n;
    private final int[] a;
    public MyCircularQueue(int k) {
        a = new int[n = k];
        tail = -1;
    }
    
    public boolean enQueue(int x) {
        if (size == n) return false;
        a[tail = ++tail % n] = x;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (size == 0) return false;
        head = ++head % n;
        size--;
        return true;
    }
    
    public int Front() {
        return size == 0 ? -1 : a[head];
    }
    
    public int Rear() {
        return size == 0 ? -1 : a[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == n;
    }
}
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */