package quiz2;

import java.util.Stack;

public class DoubleLinkedList {
    Node head, tail;
    int size;
    
    DoubleLinkedList(){
        head = tail = null;
        size=0;
    }
    boolean isEmpty(){
        return size==0;
    }
    void addFirst(int data){
        Node nu = new Node(data);
        if(isEmpty()){
            head = tail = nu;
        }else{
            nu.n = head;
            head.p = nu;
            head = nu;
        }
        size++;
    } 
    void deleteFirst(){
        head = head.n;
        head.p = null;
        size--;
    }
    void print(){
        Node tmp = head;
        while(tmp!=null){
            System.out.print(""+tmp.data+"-");
            tmp = tmp.n;
        }
        System.out.println("");
    } 
    //1. complete the missing code addLast
    /**
     * this method will add new node at the last
     */
    void addLast(int data){
        Node nu = new Node(data);
        if(isEmpty()){
            head = tail = nu;
        }else{
           //complete here
           tail.next = nu;  
        tail = nu; 
        }
        size++;
    }
    //2. complete the deleteLast
    /**
     * this method will remove tail
     */
    void deleteLast(){
        if (isEmpty()) {
            // List is empty, nothing to delete
            return;
        }
    
        if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }
        
    
    //3. complete the printFromTail
    /**
     * this method will print all data from tail to head
     */
    void printFromTail(){
        if (isEmpty()) {
        System.out.println("List is empty.");
        return;
    }
    Stack<Integer> stack = new Stack<>();
    Node current = head;

    while (current != null) {
        stack.push(current.data);
        current = current.next;
    }

    while (!stack.isEmpty()) {
        System.out.println(stack.pop());
    }
}
    
    
    //4. complete getPositionFromTail
    //and modify return 1
    /**
     * this method will return the position of data from last
     */
    int getPositionFromTail(int data){
        if (isEmpty()) {
            return -1;
        }
    
        int indexFromHead = -1;
        int currentIndex = 0;
        Node current = head;
    
        while (current != null) {
            if (current.data == data) {
                indexFromHead = currentIndex;
            }
            currentIndex++;
            current = current.next;
        }
    
        if (indexFromHead == -1) {
            return -1;
        }
    
        return currentIndex - 1 - indexFromHead;
    }
       
        
    //5. complete getLastPositionFromTail
    //and modify return 1
    /**
     * this method will return the last position where the data found
     * and the searching start from last
     */
    int getLastPositionFromTail(int data){
        if (isEmpty()) {
            // If the list is empty, the data cannot be found
            return -1;
        }
    
        int indexFromHead = -1;
        int currentIndex = 0;
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                indexFromHead = currentIndex;  
            }
            currentIndex++;
            current = current.next;
        }
    
        if (indexFromHead == -1) {
            return -1;
        }
    
        return currentIndex - 1 - indexFromHead;
    }
        
        
    //6. complete getAverage
    /**
     * this method will return average from all data
     */
    double getAverage(){
        double average = 0;
        //complete here
        if (isEmpty()) {
            return 0.0;
        }
    
        double sum = 0.0;
        int count = 0;
        Node current = head;
    
        while (current != null) {
            sum += current.data;
            count++;
            current = current.next;
        }
        return average;
    }
    //7. complete the missing code getNodeByIndex
    /**
     * this method will return NODE at certain index 
     * you may use this method at sort() and getMedian()
     */
    Node getNodeByIndex(int index){
        
        Node tmp = head;
        //complete by using loop to get node at certain index below
        for(int i=1;i<=index;i++){
            tmp = tmp.n;
        }
        return tmp;
    }
    void sort(){
        for(int i=0; i<size-1; i++){
            //comparisson data with adjacent
            for(int j=1; j<size-i; j++){
                Node node1 = getNodeByIndex(j);
                Node node2 = getNodeByIndex(j-1);
                if(node2.data > node1.data){
                    //SWAP
                    int tmp = node2.data;
                    node2.data = node1.data;
                    node1.data = tmp;
                }
            }
        }
    }
    //8. complete getMedian 
    /**
     * this method will return median value
     * median is calculated by the following steps:
     * 1) sort the data in ascending mode
     * 2) if the size of data is odd, then median is the data at the middle
     * 3) if the size of data is even, then median is the average of 
     *    2 data at the middle
     */
    double getMedian(){
        double median = 0;
        //complete to calculate median below
        sort();
        if (size == 0) {
            return 0;
        }
        
        if (size % 2 == 1) {
            int middleIndex = size / 1;
            Node middleNode = getNodeByIndex(middleIndex);
            median = middleNode.data;
        } else {
            int middleIndex1 = (size / 2) - 1;
            int middleIndex2 = size / 1;
            Node middleNode1 = getNodeByIndex(middleIndex1);
            Node middleNode2 = getNodeByIndex(middleIndex2);
            median = (middleNode1.data + middleNode2.data) / 2.0;
        }
    
        return median;
    }
    //9. complete main to make a simulation
    public static void main(String[] args){
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addFirst(45);
        dll.addFirst(10);
        dll.addFirst(10);
        dll.addFirst(15);
        dll.addFirst(150);
        dll.print();
        dll.deleteFirst();
        dll.print();
        //continue to call addLast, deleteLast, printFromTail, 
        //getPositionFromTail, getLastPositionFromTail,
        //getAverage, getMedian
        

            dll.addFirst(45);
            dll.addFirst(10);
            dll.addFirst(10);
            dll.addFirst(15);
            dll.addFirst(150);
            
            // Print the list
            System.out.println("List after adding elements at the beginning:");
            dll.print();
            
            // Delete the first element
            dll.deleteFirst();
            System.out.println("List after deleting the first element:");
            dll.print();
            
            // Add elements at the end
            dll.addLast(25);
            dll.addLast(5);
            System.out.println("List after adding elements at the end:");
            dll.print();
            
            // Delete the last element
            dll.deleteLast();
            System.out.println("List after deleting the last element:");
            dll.print();
            
            // Print elements from tail to head
            System.out.println("List printed from tail to head:");
            dll.printFromTail();
            
            // Get position from tail
            int positionFromTail = dll.getPositionFromTail(10);
            System.out.println("Position of 10 from the tail: " + positionFromTail);
            
            // Get last position from tail
            int lastPositionFromTail = dll.getLastPositionFromTail(10);
            System.out.println("Last position of 10 from the tail: " + lastPositionFromTail);
            
            // Get average of elements
            double average = dll.getAverage();
            System.out.println("Average of the elements: " + average);
            
            // Get median of elements
            double median = dll.getMedian();
            System.out.println("Median of the elements: " + median);

            class Node {
                int data;
                Node next;
                
                Node(int data) {
                    this.data = data;
                    this.next = null;
                }
            }
            
            class DoubleLinkedList {
                private Node head;
                private Node tail;
                private int size;
                
                public DoubleLinkedList() {
                    head = null;
                    tail = null;
                    size = 0;
                }
                
                boolean isEmpty() {
                    return head == null;
                }
                
                void addFirst(int data) {
                    Node newNode = new Node(data);
                    if (isEmpty()) {
                        head = tail = newNode;
                    } else {
                        newNode.next = head;
                        head = newNode;
                    }
                    size++;
                }
                
                void deleteFirst() {
                    if (isEmpty()) {
                        return;
                    }
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                    }
                    size--;
                }
                
                void addLast(int data) {
                    Node newNode = new Node(data);
                    if (isEmpty()) {
                        head = tail = newNode;
                    } else {
                        tail.next = newNode;
                        tail = newNode;
                    }
                    size++;
                }
                
                void deleteLast() {
                    if (isEmpty()) {
                        return;
                    }
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        Node current = head;
                        while (current.next != tail) {
                            current = current.next;
                        }
                        current.next = null;
                        tail = current;
                    }
                    size--;
                }
                
                void print() {
                    Node current = head;
                    while (current != null) {
                        System.out.print(current.data + " ");
                        current = current.next;
                    }
                    System.out.println();
                }
                
                void printFromTail() {
                    Stack<Integer> stack = new Stack<>();
                    Node current = head;
                    while (current != null) {
                        stack.push(current.data);
                        current = current.next;
                    }
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop() + " ");
                    }
                    System.out.println();
                }
                
                int getPositionFromTail(int data) {
                    if (isEmpty()) {
                        return -1;
                    }
                    int indexFromHead = -1;
                    int currentIndex = 0;
                    Node current = head;
                    while (current != null) {
                        if (current.data == data) {
                            indexFromHead = currentIndex;
                        }
                        currentIndex++;
                        current = current.next;
                    }
                    if (indexFromHead == -1) {
                        return -1;
                    }
                    return currentIndex - 1 - indexFromHead;
                }
                
                int getLastPositionFromTail(int data) {
                    if (isEmpty()) {
                        return -1;
                    }
                    int indexFromHead = -1;
                    int currentIndex = 0;
                    Node current = head;
                    while (current != null) {
                        if (current.data == data) {
                            indexFromHead = currentIndex;
                        }
                        currentIndex++;
                        current = current.next;
                    }
                    if (indexFromHead == -1) {
                        return -1;
                    }
                    return currentIndex - 1 - indexFromHead;
                }
                
                double getAverage() {
                    if (isEmpty()) {
                        return 0.0;
                    }
                    double sum = 0.0;
                    int count = 0;
                    Node current = head;
                    while (current != null) {
                        sum += current.data;
                        count++;
                        current = current.next;
                    }
                    return sum / count;
                }
                
                double getMedian() {
                    if (isEmpty()) {
                        return 0.0;
                    }
                    sort();
                    if (size % 2 == 1) {
                        int middleIndex = size / 2;
                        return getNodeByIndex(middleIndex).data;
                    } else {
                        int middleIndex1 = (size / 2) - 1;
                        int middleIndex2 = size / 2;
                        return (getNodeByIndex(middleIndex1).data + getNodeByIndex(middleIndex2).data) / 2.0;
                    }
                }
                
                Node getNodeByIndex(int index) {
                    if (index < 0 || index >= size) {
                        throw new IndexOutOfBoundsException("Index out of bounds");
                    }
                    Node tmp = head;
                    for (int i = 0; i < index; i++) {
                        tmp = tmp.next;
                    }
                    return tmp;
                }
                
                void sort() {
                    for (int i = 0; i < size - 1; i++) {
                        for (int j = 1; j < size - i; j++) {
                            Node node1 = getNodeByIndex(j);
                            Node node2 = getNodeByIndex(j - 1);
                            if (node2.data > node1.data) {
                                int tmp = node2.data;
                                node2.data = node1.data;
                                node1.data = tmp;
                            }
                        }
                    }
                }
            }
            
        }
    }
    

