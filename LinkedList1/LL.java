package LinkedList1;

public class LL {

    private Node head;
    private Node tail;

    private int size;
    public LL(){
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        if(tail  == null){
            insertFirst(val);
        }
        tail.next = node;
        tail = node;

        size+=1;
    }

    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size+=1;
    }
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public Node getIndex(int value){
        Node temp = head;
        while(temp != null){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int delete(int index){
        if(size == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.value;
        prev.next = prev.next.next;
        return val;
    }


    public Node get(int index){
        Node temp = head;
        for(int i =0;i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp =  temp.next;
        }
        System.out.println("END");
    }
    public void insertRec(int val, int index){
          head = insertRec(val,index,head);
    }
    private Node insertRec(int val, int index, Node node){
        if(index ==0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, --index, node.next);
        return node;
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    public void duplicates(){
        Node node = head;
        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }
    public static LL merge(LL first, LL second){
        Node f = first.head;
        Node s = second.head;
        LL ans = new LL();
        while(f != null && s != null){
            if(f.value < s.value){
               ans.insertLast(f.value);
               f = f.next;
            }else{
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while(f != null){
            ans.insertLast(f.value);
            f = f.next;
        }
        while(s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }
    public int lengthCycle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                Node temp =slow;
                int length=0;
                do{
                    temp= temp.next;
                    length++;
                }while(temp != slow);
                return length;
            }
        }
        return 0;
    }
    public Node detectCycle(Node head){
        int length = 0;
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast != slow){
                length = lengthCycle(slow);
                break;
            }
        }
        if(length == 0){
            return null;
        }
        Node first = head;
        Node second = head;
        while(length > 0){
            second = second.next;
            length--;
        }
        while(first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }
    public Node middleNode(Node head){
        Node s = head;
        Node f = head;
        while(f!= null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    public void reverse(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    // In place reversal of linkedlist
    //Reverse Linkedlist from left to right
    public Node reverseBetween(Node head, int left, int right){
        if(left == right){
            return head;
        }
        //skip the first left-1 nodes
        Node current = head;
        Node prev = null;
        for(int i = 0;current != null && i<left -1 ;i++) {
            prev = current;
            current = current.next;
        }
        Node last = prev;
        Node newEnd = current;
        //reverse between left and right
        Node next = current.next;
        for(int i = 0; current != null && i<right-left+1 ; i++){
                current.next = prev;
                prev = current;
                current = next;
                if(next != null){
                    next = next.next;
                }
        }
        if(last != null){
            last.next = prev;
        }else{
            head = prev;
        }
        newEnd.next = current;
        return head;
    }
    public Node reverseList(Node head){
        Node present = head;
        Node prev = null;
        Node next = present.next;
        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return head;
    }
    public boolean Palindrome(Node head){
        Node mid = middleNode(head);
        Node headSecond = reverseList(mid);
        Node rereversehead = headSecond;

        //compare both the halves
        while(head != null && headSecond != null){
            if(head.value != headSecond.value){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }

        reverseList(rereversehead);
        return head == null || headSecond == null;
    }
    public  void reorderList(Node head){
        if(head == null || head.next == null){
            return;
        }
        Node mid = middleNode(head);
        Node hs = reverseList(mid);
        Node hf = head;
        while(hf != null && hs != null){
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if(hf != null){
            hf.next = null;
        }
    }
    public Node rotateRight(Node head, int k){
        if(k <= 0 || head == null || head.next == null){
            return head;
        }
        Node last = head;
        int length = 1;
        while(last.next != null){
            last = last.next;
            length++;
        }
        last.next= head;
        int rotations = k%length;
        int skip = length - rotations;
        Node newLast = head;
        for(int i = 0; i< skip-1; i++){
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;
        return head;
    }
     public Node reverseKGroup(Node head, int k){
        if(k <= 1 || head == null || head.next == null){
            return head;
        }
         //skip the first left-1 nodes
         Node current = head;
         Node prev = null;
         while(true){
             Node last = prev;
             Node newEnd = current;
             //reverse between left and right
             Node next = current.next;
             for(int i = 0; current != null && i<k ; i++){
                 current.next = prev;
                 prev = current;
                 current = next;
                 if(next != null){
                     next = next.next;
                 }
             }
             if(last != null){
                 last.next = prev;
             }else{
                 head = prev;
             }
             newEnd.next = current;
            if(current == null){
                break;
            }
            prev = newEnd;
         }
         return head;
     }
    public Node reverseAlternateKGroup(Node head, int k){
        if(k <= 1 || head == null || head.next == null){
            return head;
        }
        //skip the first left-1 nodes
        Node current = head;
        Node prev = null;
        while(current != null){
            Node last = prev;
            Node newEnd = current;
            //reverse between left and right
            Node next = current.next;
            for(int i = 0; current != null && i<k ; i++){
                current.next = prev;
                prev = current;
                current = next;
                if(next != null){
                    next = next.next;
                }
            }
            if(last != null){
                last.next = prev;
            }else{
                head = prev;
            }
            newEnd.next = current;
            for(int i = 0; current != null && i < k;i++){
                prev = current;
                current = current.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        LL list = new LL();
        LL first = new LL();
        LL second = new LL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.display();
    }
}
