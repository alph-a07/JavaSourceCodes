package hashmaps;

import generics.GenericLinkedList;

import java.util.Objects;

public class HashTable<K, V> {
    private class HTPair {
        K key;
        V value;

        HTPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            // cast object to HTPair type
            HTPair other = (HTPair) o;
            return this.key.equals(other.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return "{" + key + " => " + value + '}';
        }
    }

    public static final int DEFAULT_CAPACITY = 10;

    HashTable() {
        this(DEFAULT_CAPACITY);
    }

    HashTable(int capacity) {
        this.bucketArray = (GenericLinkedList<HTPair>[]) new GenericLinkedList[capacity];
    }

    // Array of (LinkedLists of type HTPair)
    private GenericLinkedList<HTPair>[] bucketArray;
    private int size;

    // O(1)
    public void put(K key, V value) throws Exception {
        int index = this.hashFunction(key);
        HTPair currentPair = new HTPair(key, value);
        // make a linked list at the index given by hash function for current key
        GenericLinkedList<HTPair> bucket = this.bucketArray[index];

        // If there is no linked list initially
        if (bucket == null) {
            // create a linked list and add the pair
            bucket = new GenericLinkedList<>();
            bucket.addAtLast(currentPair);                                // O(1)
            // link the linked list to the bucketArray index
            this.bucketArray[index] = bucket;
            this.size++;
        }

        // If already pairs were added to bucket at the index
        // There might be a chance that key already exists
        else {
            // If key does not already exist
            if (bucket.getIndex(currentPair) == -1) {                       // O(N)
                bucket.addAtLast(currentPair);                           // O(1)
                this.size++;
            }
            // Key already exists
            // Just update the value in the pair
            else {
                HTPair temp = bucket.getAt(bucket.getIndex(currentPair));                       // O(1)
                temp.value = value;
            }
        }

        // LOADING FACTOR
        // It decided the number of pairs in each bucket in an average case
        // Keeping lambda 0.75, there will be only 1 pair in each bucket in an AVERAGE CASE
        // The WORST CASE time complexity still can be O(N) - where all pairs are added in a single bucket
        // Generally it does not happen because hashCode() works in that way only
        // Hence getIndex will become O(1)
        double lambda = (this.size * 1.0) / bucketArray.length;
        if (lambda > 0.75)
            this.rehash();
    }

    // Double the size of bucket array and put all pairs again
    // O(1)
    private void rehash() throws Exception {
        GenericLinkedList<HTPair>[] oldBucketArray = this.bucketArray;
        this.bucketArray = (GenericLinkedList<HTPair>[]) new GenericLinkedList[2 * oldBucketArray.length];

        for (GenericLinkedList<HTPair> bucket : oldBucketArray) {
            while (bucket != null && !(bucket.getSize() == 0)) {
                HTPair temp = bucket.removeFirst();
                this.put(temp.key, temp.value);
            }
        }
    }

    // O(N)
    public V get(K key) throws Exception {
        // Go to the bucket where the key can exist
        int index = this.hashFunction(key);
        GenericLinkedList<HTPair> bucket = this.bucketArray[index];
        HTPair currentPair = new HTPair(key, null);

        // If bucket not found return null
        if (bucket == null)
            return null;
        else {
            // If key does not exist
            if (bucket.getIndex(currentPair) == -1) {                       // O(N)
                return null;
            }
            // Key exists
            else {
                HTPair temp = bucket.getAt(bucket.getIndex(currentPair));                       // O(1)
                return temp.value;
            }
        }
    }

    // O(N)
    public V remove(K key) throws Exception {
        // Go to the bucket where the key can exist
        int index = this.hashFunction(key);
        GenericLinkedList<HTPair> bucket = this.bucketArray[index];
        HTPair currentPair = new HTPair(key, null);

        // If bucket not found return null
        if (bucket == null)
            return null;
        else {
            // If key does not exist
            if (bucket.getIndex(currentPair) == -1) {                       // O(N)
                return null;
            }
            // Key exists
            else {
                HTPair temp = bucket.removeAt(bucket.getIndex(currentPair));                       // O(1)
                return temp.value;
            }
        }
    }

    public void display() {
        System.out.println("________________________________");
        for (GenericLinkedList<HTPair> bucket : bucketArray) {
            if (bucket != null && !(bucket.getSize() == 0)) {
                bucket.display();
                System.out.println();
            } else {
                System.out.println("null");
            }
            System.out.println("________________________________");
        }
    }

    // converts hashCode to one of the indices of bucketArray
    // decides in which of the linked lists the HTPair will be added
    // O(1)
    private int hashFunction(K key) {
        // Any integer from negative to positive infinity
        // hashCode() => O(1)
        int hashCode = key.hashCode();
        int index = (Math.abs(hashCode)) % bucketArray.length;

        return index;
    }
}

class test {
    public static void main(String[] args) throws Exception {
        HashTable<String, Integer> ht = new HashTable<>(5);

        ht.put("India", 300);
        ht.put("USA", 200);
        ht.put("China", 400);

        ht.display();
        System.out.println("---------------------****---------------------");

        ht.put("UK", 250);
        ht.display();
        System.out.println("---------------------****---------------------");

        ht.put("India", 350);
        ht.display();
        System.out.println("---------------------****---------------------");

        System.out.println(ht.get("India"));
        System.out.println(ht.get("SA"));
        System.out.println(ht.remove("China"));
        System.out.println(ht.remove("SA"));
        ht.display();
        System.out.println("---------------------****---------------------");
    }
}