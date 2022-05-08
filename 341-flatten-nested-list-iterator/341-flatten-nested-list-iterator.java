/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer>ans;
    int i;
    int n;
    public NestedIterator(List<NestedInteger> nestedList) {
        i=0;
        ans=resolve(nestedList);
        n=ans.size();
    }

    @Override
    public Integer next() {
        return ans.get(i++);
    }

    @Override
    public boolean hasNext() {
        if(i<n)
        {
            return true;
        }
        return false;
    }
    public List<Integer> resolve(List<NestedInteger> list)
    {
        List<Integer>ans=new ArrayList<>();
        for(NestedInteger el:list)
        {
            if(el.isInteger())
            {
                ans.add(el.getInteger());
            }
            else
            {
                ans.addAll(resolve(el.getList()));
            }
        }
        return ans;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */