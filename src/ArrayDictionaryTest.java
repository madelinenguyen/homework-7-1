import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDictionaryTest {
    @Test
    public void demo() {
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        assertTrue(dict.add(2, 82));
        assertTrue(dict.add(4, 84));
        assertTrue(dict.add(7, 87));
        System.out.println(dict);
    }

    @Test
    public void remove() {
    	//ArrayDictionary<Integer, Integer> dict = new ArrayDictionary<Integer, Integer>();
    	ArrayDictionary dict = new ArrayDictionary(1);
    	
    	// empty dictionary<int, int>, contain returns false with key -1
    	assertTrue(!dict.remove(-1));
    	// empty dictionary<int, int>, contain returns false with key 0
    	assertTrue(!dict.remove(0));
    	// empty dictionary<int, int>, contain returns false with key 1
    	assertTrue(!dict.remove(1));
    	
    	
    	ArrayDictionary dict1 = new ArrayDictionary(1);
    	dict1.add(0, 1);
    	dict1.add(0, 0);
    	dict1.add(0, 3);
    	
    	// dictionary<int, int>, capacity 1, init values {0:103}, key=2 returns false
    	assertTrue(!dict1.remove(2));
    	// dictionary<int, int>, capacity 1, init values {0:103}, key=0 returns true
    	assertTrue(dict1.remove(0));
    	
    	
    	ArrayDictionary dict2 = new ArrayDictionary(2);
    	dict2.add(0, 1);
    	dict2.add(0, 0);
    	dict2.add(0, 3);
    	dict2.add(1, 1);
    	dict2.add(1, 0);
    	dict2.add(1, 5);
    	
    	// dictionary<int, int>, capacity 2, init values {0:103, 1:105}, key=0 returns true
    	assertTrue(dict2.remove(0));
    	// dictionary<int, int>, capacity 2, init values {0:103, 1:105}, key=1 returns true
    	assertTrue(dict2.remove(1));
    	// dictionary<int, int>, capacity 2, init values {0:103, 1:105}, key=2 returns false
    	assertTrue(!dict2.remove(2));
    	// dictionary<int, int>, capacity 2, init values {0:103, 1:105}, key=3 returns false
    	assertTrue(!dict2.remove(3));
    	
    	
    	ArrayDictionary dict3 = new ArrayDictionary(3);
    	dict3.add(0, 1);
    	dict3.add(0, 0);
    	dict3.add(0, 3);
    	dict3.add(1, 1);
    	dict3.add(1, 0);
    	dict3.add(1, 5);
    			
    	// dictionary<int, int>, capacity 3, init values {0:103, 1:105}, key=3 returns false
    	assertTrue(!dict3.remove(3));
    	dict3.add(2, 2);
    	dict3.add(2, 0);
    	dict3.add(2, 6);
    	
        // dictionary<int, int>, capacity 3, init values {0:103, 1:105, 2:206}, key=1 returns true
    	assertTrue(dict3.remove(1));
    }

    @Test
    public void contains() {
    	
    	//ArrayDictionary<Integer, Integer> dict = new ArrayDictionary<Integer, Integer>();
    	ArrayDictionary dict = new ArrayDictionary(1);
    	
    	// empty dictionary<int, int>, contain returns false with key -1
    	assertTrue(!dict.contains(-1));
    	// empty dictionary<int, int>, contain returns false with key 0
    	assertTrue(!dict.contains(0));
    	// empty dictionary<int, int>, contain returns false with key 1
    	assertTrue(!dict.contains(1));
    	
    	
    	ArrayDictionary dict1 = new ArrayDictionary(1);
    	dict1.add(0, 1);
    	dict1.add(0, 0);
    	dict1.add(0, 3);
    	
    	// dictionary<int, int>, capacity 1, init values {0:103}, key=2 returns false
    	assertTrue(!dict1.contains(2));
    	// dictionary<int, int>, capacity 1, init values {0:103}, key=0 returns true
    	assertTrue(dict1.remove(0));
    	
    	
    	ArrayDictionary dict2 = new ArrayDictionary(2);
    	dict2.add(0, 1);
    	dict2.add(0, 0);
    	dict2.add(0, 3);
    	dict2.add(1, 1);
    	dict2.add(1, 0);
    	dict2.add(1, 5);
    	
    	// dictionary<int, int>, capacity 2, init values {0:103, 1:105}, key=0 returns true
    	assertTrue(dict2.remove(0));
    	// dictionary<int, int>, capacity 2, init values {0:103, 1:105}, key=1 returns true
    	assertTrue(dict2.remove(1));
    	// dictionary<int, int>, capacity 2, init values {0:103, 1:105}, key=2 returns false
    	assertTrue(!dict2.remove(2));
    	// dictionary<int, int>, capacity 2, init values {0:103, 1:105}, key=3 returns false
    	assertTrue(!dict2.remove(3));
    	
    	
    	ArrayDictionary dict3 = new ArrayDictionary(3);
    	dict3.add(0, 1);
    	dict3.add(0, 0);
    	dict3.add(0, 3);
    	dict3.add(1, 1);
    	dict3.add(1, 0);
    	dict3.add(1, 5);
    			
    	// dictionary<int, int>, capacity 3, init values {0:103, 1:105}, key=3 returns false
    	assertTrue(!dict3.remove(3));
    	dict3.add(2, 2);
    	dict3.add(2, 0);
    	dict3.add(2, 6);
    	
        // dictionary<int, int>, capacity 3, init values {0:103, 1:105, 2:206}, key=1 returns true
    	assertTrue(dict3.remove(1));
    }
}