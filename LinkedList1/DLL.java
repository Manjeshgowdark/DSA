package LinkedList1;

public class DLL {
    private Node head;
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }
    public void insertLast(int val){
        Node node = new Node(val);
        node.next = null;
        if(head == null){
            head = node;
            node.prev = null;
            return;
        }
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;

    }
    public Node getIndex(int value){
        Node temp = head;
        while(temp != null){
            if(temp.val == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void insert(int after, int val){
        Node p = getIndex(after);
        if(p==null){
            System.out.println("Node doesnot exist ");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        node.prev = p;
        p.next = node;
        if(node.next != null){
            node.next.prev = node;
        }
    }
    public void display(){
        Node node = head;
        Node last = null;
        while(node != null){
            System.out.print(node.val +" -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");
        System.out.println("Printing in reverse order");
        while(last !=  null){
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");

    }
    private class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
