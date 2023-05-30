package leetcode;

/**
 * @author tempo
 */
public class MyHashSet {
    private final int[] hashTable;

    public MyHashSet() {
        hashTable = new int[(int) (Math.pow(10, 6) / 32)];
    }

    public void add(int key) {
        hashTable[key / 32] |= 1 << key % 32;
    }

    public void remove(int key) {
        hashTable[key / 32] &= ~(1 << key % 32);
    }

    public boolean contains(int key) {
        return (hashTable[key / 32] & (1 << key % 32)) != 0;
    }
}
