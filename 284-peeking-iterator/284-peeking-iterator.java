// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Queue<Integer>arr;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        arr=new LinkedList<>();
        while(iterator.hasNext())
        {
            arr.add(iterator.next());
        }
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return arr.peek();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int tmp=arr.remove();
        return tmp;
	}
	
	@Override
	public boolean hasNext() {
	   return arr.size()>0;
	}
}