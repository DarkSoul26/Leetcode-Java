class Bitset {
    boolean a[];
    int count0;
    int size;
    boolean flip;
    public Bitset(int sizeA) {
        a = new boolean[sizeA];
        size = sizeA;
        count0 = sizeA;
    }
    
    public void fix(int idx) {
        if(!(a[idx]^flip)){
            a[idx]^= true;
            count0--;
        }
    }
    
    public void unfix(int idx) {
        if(a[idx]^flip){
            a[idx]^= true;
            count0++;
        }
    }
    
    public void flip() {
        flip^=true;
        count0 = size-count0;
    }
    
    public boolean all() {
        if(size-count0 == size)
            return true;
        return false;
    }
    
    public boolean one() {
        if(size-count0>=1)
            return true;
        return false;
    }
    
    public int count() {
        return size-count0;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<this.size;i++){
            if(a[i]^flip)
                sb.append(1);
            else
                sb.append(0);
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */