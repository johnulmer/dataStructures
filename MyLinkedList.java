package dataStructures;

public class MyLinkedList {
    
	private Node head;
	
	/* added constructors to support car / cdr / cons list operations
	 * 
	 */
	
    public MyLinkedList() {
	}
    
	public MyLinkedList(Node head) {
		this.head = head;
	}
    
    public static Object myCar(MyLinkedList list) {
    	if (list.size() > 0) {
    	return list.get(0);
    	} else {
    		return null;
    	}
    }
    public static MyLinkedList myCdr(MyLinkedList list) {
    	Node remainderHead = list.head.next;
       	MyLinkedList remainder = new MyLinkedList(remainderHead);
    	return remainder;
    }
    public static MyLinkedList myCons(Object[] args) {
    	//create new node, set it to first arg, add it to list as head node
    	Node headNode = new Node();
    	headNode.val = args[0];
    	MyLinkedList newList = new MyLinkedList(headNode);
    	
    	// TODO build remainder of list here in for loop
    	Node currentLink = headNode;
    	for (int i=1;i<args.length;i++) {
    		Node newLink = new Node();
    		newLink.val = args[i];
    		currentLink.next = newLink;
    		currentLink = newLink;
    	}
    	return newList;
    }
    
    public int size() {
          int n = 0;
          Node current = this.head;
          while (current != null) {
               n++;
               current = current.next;
          }
          return n;
    }
   
    public Object get(int idx) {
          if (idx < 0) {
               throw new IndexOutOfBoundsException();
          }
          int n = 0;
          Node current = this.head;
          while (current != null) {
               if (n == idx) {
                     return current.val;
               }
               n++;
               current = current.next;
          }
          throw new IndexOutOfBoundsException();
    }
   
    public void set(int idx, Object o) {
          if (idx < 0) {
               throw new IndexOutOfBoundsException();
          }
          int n = 0;
          Node current = this.head;
          while (current != null) {
               if (n == idx) {
                     current.val = o;
                     return;
               }
               n++;
               current = current.next;
          }
          throw new IndexOutOfBoundsException();
    }
    
    public void insert(Object o, int idx){
          int n = 0;
          if (this.head == null){
               //TO DO throw error>
          }
          //n - 1;
          Node current = this.head;
          Node previous = null;
          while (n < idx){
        	  previous = current;
              current = current.next;
              n++;
          }
          Node temp = new Node();
          temp.val = o;
          temp.next = previous.next;
          previous.next = temp;
          return;
    }
   
   
    public int append(Object o) {
          if (this.head == null) {
               this.head = new Node();
               this.head.val = o;
               return 1;
          }
          int n = 1;
          Node current = this.head;
          Node prev = null;
          while (current != null) {
               n++;
               prev = current;
               current = current.next;
          }
          prev.next = new Node();
          prev.next.val = o;
          return n;
    }
   
    public static void main(String[] args) {
          MyLinkedList list = new MyLinkedList();
          list.append("hi");
          list.append("yo");
          list.append("bye");
          System.out.println(list.size());
          System.out.println(list.get(0));
          System.out.println(list.get(1));
          System.out.println(list.get(2));
          list.insert("We are awesome", 1);
          System.out.println(list.get(0));
          System.out.println(list.get(1));
          System.out.println(list.get(2));
          MyLinkedList secondTest;
          String[] listPieces = {"test1", "another entry", "final entry"};
          secondTest = MyLinkedList.myCons(listPieces);
          System.out.println(secondTest.size());
    }
   
}
class Node {
    public Object val;
    public Node next;
}