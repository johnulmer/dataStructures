package dataStructures;

public class MyArrayList<T> {
    private T[] things;
    public int[] intThings;  // added to demonstrate sorts - see comment line 55
    private int size;
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        super();
        this.things = (T[]) new Object[10];
        this.size = 0;
    }
    public int append(T o) {
        if (this.size == things.length) {
            this.expand(this.size);
        }
        this.things[this.size] = o;
        this.size++;
        return this.size;
    }
    public int getSize() {
        return this.size;
    }
    public Object getThing(int idx) {
        if (idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return this.things[idx];
    }
    public void setThing(T o, int idx) {
        if (idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        things[idx] = o;
    }
    //
    public void expand(int toSize) {
        if (this.size + toSize > this.things.length) {
           @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[this.size + toSize];
            for (int i = 0; i < this.things.length; i++) {
                newArray[i] = this.things[i];
            }
            this.things = (T[]) newArray;
        }
    }
    public Object remove(int idx) {
        Object temp = this.getThing(idx);
        for (int i = idx; i < this.size - 1; i++) {
            this.things[i] = this.things[i + 1];
        }
        this.size--;
        return temp;
    }
    // created second array just for ints instead of objects
    // could perform these sorts on the base "things" array but would have 
    // to check and cast each item first and throw an error if they weren't all numeric
    public void insertionSort() {
    	for (int i=0; i<this.size; i++) {
    		int temp = this.intThings[i];
    		int j;
    		for (j = i-1; ((j>= 0) && (temp > intThings[i])); j--) {
    			intThings[j+1] = intThings[j];
    		} // end internal for loop
    		intThings[j+1] = temp;
    	} // end external for loop
    } // end insertionSort
    
    public void bubbleSort() {
    	boolean swapping = true; // needed to stop iterating early if sort completes
    	int compareValue; // needed to "bubble" values through array
    	while (swapping) {
    		swapping = false; // set to false in case sort completes but will set to true if swap occurs
    		for (int i= 0; i<intThings.length-1; i++) {
    			if (intThings[i] > intThings[i+1]) {
    				compareValue = intThings[i];
    				intThings[i] = intThings[i+1];
    				intThings[i+1] = compareValue;
    				swapping = true;
    			} // end if
    		} // end for
    	} // end while
    }  // end bubbleSort
    public String showIntArray() {
    	String arrayContents = "";
    	for (int i = 0; i < intThings.length; i++) {
    		arrayContents += intThings[i] + "  ";
    	}
    	return arrayContents;
    }
    
    public static void main(String[] args) {
        MyArrayList<Object> list = new MyArrayList<Object>();
        list.append(9);
        list.append("hi");
        list.append("bye");
        list.remove(1);
        System.out.println(list.getSize());
        System.out.println(list.getThing(0));
        System.out.println(list.getThing(1));
        int[] intsToSort = {-5, -12, 213, 417, 122, 3};
        list.intThings = intsToSort;
        System.out.println("unsorted int array: " + list.showIntArray());
        list.bubbleSort();
        System.out.println("int array after bubble sort: " + list.showIntArray());
        int[] intsToSort2 = {7, -1, 16, 243, 22, 11};
        list.intThings = intsToSort2;
        System.out.println("unsorted int array: " + list.showIntArray());
        list.bubbleSort();
        System.out.println("int array after insertion sort: " + list.showIntArray());
    }
}