package linkedlists;

public class test {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addAtLast(5);
        l.display();

        System.out.println();

        l.addAtFirst(6);
        l.display();

        l.addAtLast(7);
        System.out.println();
        l.display();

        System.out.println();
        l.addAtFirst(4);
        l.display();
    }
}
