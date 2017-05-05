package HashTable;

/**
 * Created by ZweNaing on 5/1/17.
 */
public class HashEntry {
    private int key;
    private int value;

    public HashEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
