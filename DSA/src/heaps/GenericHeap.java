package heaps;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericHeap<T extends Comparable<T>> {
    ArrayList<T> list = new ArrayList<>();
    HashMap<T, Integer> trackIndex = new HashMap<>();

    // Added wrt priority and CBT property
    // O(log(N))
    public void add(T data) {

        // add element
        list.add(data);
        // data will be added to the last of arraylist
        trackIndex.put(data, this.list.size() - 1);

        // check if it violates priority property
        upHeapify(list.size() - 1);
    }

    // ALWAYS highest priority element will be removed(ROOT)
    // O(log(N))
    public T remove() {

        // We can't directly remove root, it will break our tree
        // We can easily remove a leaf without any index shifting

        swap(0, list.size() - 1);
        T temp = list.remove(list.size() - 1);
        downHeapify(0);
        trackIndex.remove(temp);

        return temp;
    }

    // Returns top priority element
    // O(1)
    public T get() {
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

        if (leftChildIndex < list.size() && isLarger(list.get(leftChildIndex), list.get(minIndex)) > 0)
            minIndex = leftChildIndex;

        if (rightChildIndex < list.size() && isLarger(list.get(rightChildIndex), list.get(minIndex)) > 0)
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

        if (isLarger(list.get(childIndex), list.get(parentIndex)) > 0) {
            swap(parentIndex, childIndex);
            upHeapify(parentIndex);
        }
    }

    private void swap(int i, int j) {
        T ith = list.get(i);
        T jth = list.get(j);

        list.set(i, jth);
        list.set(j, ith);

        trackIndex.put(ith,j);
        trackIndex.put(jth,i);
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

    // returns positive if t has higher priority
    // returns negative if t has lower priority
    private int isLarger(T t, T o) {
        return t.compareTo(o);
    }

    public void updatePriority(T pair){
        int index = trackIndex.get(pair);
        this.upHeapify(index);
    }
}

class grades implements Comparable<grades> {
    String name;
    int marks;
    int rank;

    public grades(String name, int marks, int rank) {
        this.name = name;
        this.marks = marks;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "grades{" + "name=" + name + ", marks=" + marks + ", rank=" + rank + '}';
    }

    @Override
    public int compareTo(grades o) {
        // Only one comparison can be done at a time
        //return o.marks - this.marks;
        return this.rank - o.rank;
        //return this.name.compareTo(o.name);
    }
}

class test1 {
    public static void main(String[] args) {
        grades g1 = new grades("A", 70, 3);
        grades g2 = new grades("B", 80, 2);
        grades g3 = new grades("C", 90, 1);

        GenericHeap<grades> h = new GenericHeap<>();
        h.add(g1);
        h.add(g2);
        h.add(g3);
        h.display();
    }
}
