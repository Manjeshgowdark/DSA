package LinkedList1;

public class Main {
    public static void main(String[] args) {
//        LL list = new LL();
//        list.insertFirst(2);
//        list.insertFirst(4);
//        list.insertFirst(7);
//        list.insertFirst(9);
//        list.insertLast(3);
//        list.insert(100,3);
//        list.display();
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.delete(2));
//        list.display();
//        DLL list = new DLL();
//        list.insertFirst(2);
//        list.insertFirst(4);
//        list.insertFirst(7);
//        list.insertFirst(9);
//        list.insertLast(99);
//        list.insert(4,65);
//        list.display();
          LL list = new LL();
          list.insertFirst(23);
          list.insertFirst(3);
          list.insertFirst(19);
          list.insertFirst(75);

          list.display();
          list.insertRec(88,2);
          list.display();
    }
}
