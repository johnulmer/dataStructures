package dataStructures;

public class MyArrayList<T> {
    private T[] things;
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
    public static void main(String[] args) {
        MyArrayList<Object> list = new MyArrayList<Object>();
        list.append(9);
        list.append("hi");
        list.append("bye");
        list.remove(1);
        System.out.println(list.getSize());
        System.out.println(list.getThing(0));
        System.out.println(list.getThing(1));
    }
}