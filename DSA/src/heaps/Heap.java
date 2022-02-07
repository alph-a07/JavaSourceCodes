package heaps;

import java.util.ArrayList;

// min Heap
public class Heap {
    private ArrayList<Integer> list = new ArrayList<>();

    // Added wrt priority and CBT property
    // O(log(N))
    public void add(int data) {

        // add element
        list.add(data);

        // check if it violates priority property
        upHeapify(list.size() - 1);
    }

    // ALWAYS highest priority element will be removed(ROOT)
    // O(log(N))
    public int remove() {

        // We can't directly remove root, it will break our tree
        // We can easily remove a leaf without any index shifting

        swap(0, list.size() - 1);
        int temp = list.remove(list.size() - 1);
        downHeapify(0);

        return temp;
    }

    // Returns top priority element
    // O(1)
    public int get(){
        return this.list.get(0);
    }

    // DOWNHEAPIFY
    // Controls the parent priority property
    // Sets minimum value of parent and children to parent
    // O(log(N))
    private void downHeapify(int parentIndex) {

        // No base case required
        // As when reached bottom the leftChildIndex and rightChildIndex will be out of index
        // Hence minIndex = parentIndex
        // That means recursion will stop

        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        int minIndex = parentIndex;

        if (leftChildIndex < list.size() && list.get(leftChildIndex) < list.get(minIndex))
            minIndex = leftChildIndex;

        if (rightChildIndex < list.size() && list.get(rightChildIndex) < list.get(minIndex))
            minIndex = rightChildIndex;

        // minIndex has the value of min(parent,leftChild,rightChild)

        // Do operations only if priority property is violated
        if (minIndex != parentIndex) {
            swap(minIndex, parentIndex);
            // No need to downHeapify the other child as values are not modified on that side
            downHeapify(minIndex);
        }

    }

    // UPHEAPIFY
    // Controls the parent priority property
    // Swaps the values if violation is found
    // O(log(N))
    private void upHeapify(int childIndex) {

        // No base case required
        // As when childIndex = 0 => parentIndex = 0     (coz parentIndex = (childIndex - 1)/2)
        // Hence list[childIndex] = list[parentIndex]
        // If block won't be evaluated and recursion will stop

        int parentIndex = (childIndex - 1) / 2;

        if (list.get(childIndex) < list.get(parentIndex)) {
            swap(childIndex, parentIndex);
            upHeapify(parentIndex);
        }
    }

    private void swap(int i, int j) {
        int ith = list.get(i);
        int jth = list.get(j);

        list.set(i, jth);
        list.set(j, ith);
    }

    public void display() {
        System.out.println(list);
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}

class test {
    public static void main(String[] args) {
        Heap h = new Heap();

        h.add(10);
        h.display();
        h.add(20);
        h.display();
        h.add(30);
        h.display();
        h.add(40);
        h.display();
        h.add(7);
        h.display();
        h.add(5);
        h.display();
        System.out.println(h.remove());
        h.display();
        System.out.println(h.remove());
        h.display();
    }
}
