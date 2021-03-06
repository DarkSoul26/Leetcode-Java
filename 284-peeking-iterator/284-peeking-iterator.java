// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> stk;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    stk = new LinkedList<>();
        while(iterator.hasNext()){
            stk.add(iterator.next());
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return stk.peek();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return stk.remove();
	}
	
	@Override
	public boolean hasNext() {
	    if(stk.isEmpty())
            return false;
        return true;
	}
}