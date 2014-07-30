public final class FibonacciHeap<T>
{
	public static final class Entry<T> 
	{
		private int degree = 0; 					// Number of children
		private boolean isMarked = false;	// Whether this node is marked
		
		private Entry<T> next;					// Next element in the list
		private Entry<T> prev;					// Previous element in the list
		
		private Entry<T> parent;					// Parent in the tree, if any.
		
		private Entry<T> child;					// Child node, if any.
		
		private T 			  elem;					// Element being stored here
		private int	  priority;				// Its priority
		
		private Entry(T value, int priority)
		{
			this.next = prev = this;
			this.value = value;
			this.priority = priority;
		}
	}
	
	private Entry<T> min = null;
	
	private int size = 0;
	
	public Entry<T> enqueue(T value, int priority)
	{
		Entry<T> result = new Entry<T>(value, priority);
		
		min = mergeLists(min, result);
		
		++size;
		
		return result;
	}
	
	public Entry<T> dequeueMin()
	{
		--size;
		
		Entry<T> minElem = min;
		
		if (min.next == min)
		{
			min = null;
		}
		else
		{
			min.prev.next = min.next;
			min.next.prev = min.prev;
			min = min.next;
		}
		
		if (minElem.child != null)
		{
			Entry<?> curr = minElem.child;
			
			do
			{
				curr.parent = null;
				curr = curr.next;
			} while (curr != minElem.child);
			
			min = mergeLists(min, minElem.child);
			
			if (min == null) return minElem;
			
			List<Entry<T>> treeTable = new ArrayList<Entry<T>>();
			
			List<Entry<T>> toVisit = new ArrayList<Entry<T>>();
			
			for (Entry<T> curr = min; toVisit.isEmpty() || toVisit.get(0) != curr; curr = curr.next)
			{
				toVisit.add(curr);
			}
			
			for(Entry<T> curr: toVisit)
			{
				while(true)
				{
					while(curr.degree >= treeTable.size())
					{
						treeTable.add(null);
					}	
					
					if (treeTable.get(curr.degree) == null)
					{
						treeTable.set(curr.degree, curr);
						break;
					}
					Entry<T> other = treeTable.get(curr.degree);
					treeTable.set(curr.degree, null);
					
					Entry<T> min = (other.priority < curr.priority)? other : curr;
					Entry<T> max = (other.priority < curr.priority)? curr  : other;
					
					max.next.prev = max.prev;
					max.prev.next = max.next;
					
					max.next = max.prev = max;
					min.child = mergeLists(min.child, max);
					
					max.parent = min;
					
					max.isMarked = false;
					
					++min.degree;
					
					curr = min;
				}
				
				if (curr.priority <= min.priority) min = curr;
			}
			
			return minElem;
		}
	}
	
	private static <T> Entry<T> mergeLists(Entry<T> one, Entry<T> two)
	{
		if (one == null && two == null)
		{
			return null;
		}
		
		if (one == null)
		{
			return two;
		}
		
		if (two == null)
		{
			return one;
		}
		
		Entry<T> oneNext = one.next;
		
		one.next = two.next;
		one.next.prev = one;
		two.next = oneNext;
		two.next.prev = two;
		
		return one.priority < two.priority ? one : two;
	}
	
	private void decreaseKeyUnchecked(Entry<T> entry, int priority)
	{
		entry.priority = priority;
		
		if (entry.parent != null && entry.priority <= entry.parent.priority)
			cutNode(entry);
			
		if (entry.priority <= min.priority)
			min = entry;
	}
	
	private void cutNode(Entry<T> entry)
	{
		entry.isMarked = false;
		
		
		if (entry.parent == null) return;
		
		if (entry.next != entry)
		{
			entry.next.prev = entry.prev;
			entry.prev.next = entry.next;
		}
		
		if (entry.parent.child == entry)
		{
			if (entry.next != entry)
			{
				entry.parent.child = entry.next;
			}
			else
			{
				entry.parent.child = null;
			}
		}
		
		--entry.parent.degree;
		
		entry.prev = entry.next = entry;
		min = mergeLists(min, entry);
		
		if (entry.parent.isMarked)
			cutNode(entry.parent);
		else
			entry.parent.isMarked = true;
			
		entry.parent = null;
	}
}