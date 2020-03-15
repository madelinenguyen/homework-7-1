public class ArrayDictionary implements Dictionary {
    private int capacity; // size of KVEntry array
    private int count;
    private KVEntry[] entries;

    public ArrayDictionary(int capacity) {
        this.capacity = capacity;
        entries = new KVEntry[capacity];
    }

    private int hashFunction(int key) {
        return key % capacity;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean add(int key, int value) {

        int hashedKey = hashFunction(key);

        // when there's no entry yet
        if (entries[hashedKey] == null) {
            if (count == capacity) return false;
            
            // create new KVEntry at index in entries
            entries[hashedKey] = new KVEntry(key, value);
            count++;
            return true;
        }
        
        KVEntry ptr = entries[hashedKey];
        KVEntry pNewNode = null;
        while (ptr != null) {
            // update value if key already exists
            if (ptr.key == key) {
                ptr.value = value;
                return true;
            }
            pNewNode = ptr; // keep track of old entry
            ptr = ptr.next; // go to next chained value if any
        }

        // add an entry to the end of the chain
        pNewNode.next = new KVEntry(key, value);
        return true;
    }

    // Delete the entry with the given key from the dictionary
    // Return true if an entry is deleted, false otherwise
    /*
    @Override
    public boolean remove(int key) {
        if (capacity<1) {
        	return false;
        }
        if (key<0) {
        	return false;
        }
        int hashedKey = hashFunction(key);
        if (entries[hashedKey]==null) {
        	return false;
        }
        
        if (entries[hashedKey].key == key) {
        	entries[hashedKey] = entries[hashedKey].next;
        	return true;
        }
        
        KVEntry prev = entries[hashedKey];
        KVEntry curr = prev.next;
        while (curr != null) {
        	if (curr.key==key) {
        		prev.next = curr.next;
        		return true;
        	}
        	prev=curr;
        	curr=curr.next;
        }
        return false;
    }
    */
    
    
    @Override
    public boolean remove(int key) {
    	// create array index
    	int hashedKey = hashFunction(key);
    	
    	// check capacity
    	if (capacity<1) return false;
    	// check that key is valid
    	if (key<0) return false;
    	if (entries[hashedKey]==null) return false;
    	
    	// check if first key is passed in key
    	if (entries[hashedKey].key == key) {
    		entries[hashedKey] = entries[hashedKey].next;
    		return true;
    	}
    	
    	KVEntry ptr = entries[hashedKey];
    	KVEntry nextKey = ptr.next;
    	
    	while (nextKey != null) {
    		// check if the key at ptr is equal to the key
    		if (nextKey.key == key) {
    			ptr.next = nextKey.next; // remove
    			count--;
    			return true;
    		}
    		ptr = nextKey;
    		nextKey = nextKey.next;
    	}
    	return false;
    }
    

    // Return true when the dictionary contains an entry
    // with the key
    @Override
    public boolean contains(int key) {
    	
    	int hashedKey = hashFunction(key);
    	// check capacity
    	if (capacity<1) return false;
    	if (key<0) return false;
    	// if there's no entry yet
    	if (entries[hashedKey] == null) return false;
    	
    	KVEntry ptr = entries[hashedKey];
    	//KVEntry nextKey = ptr.next;
    	while (ptr != null) {
    		if (ptr.key == key) {
    			return true;
    		}
    		ptr = ptr.next;
    	}
        return false;
    }

    // Return the entry value with the given key
    // Return null if no entry exists with the given key
    @Override
    public Integer get(int key) {
        // NOT IMPLEMENTED
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            if (entries[i] == null) {
                builder.append("dictionary["+ i + "] = null\n");
                continue;
            }
            KVEntry ptr = entries[i];
            builder.append("dictionary["+i+"] = {");
            while (ptr != null) {
                builder.append("(" + ptr.key + ", " + ptr.value + ")");
                ptr = ptr.next;
            }
            builder.append("}\n");
        }
        return builder.toString();
    }
}
