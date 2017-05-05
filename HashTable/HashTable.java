package HashTable;

/**
 * Created by ZweNaing on 5/1/17.
 */
public class HashTable {

  private static final int TABLE_SIZE = 128;

  HashEntry[] table;

  public HashTable() {
    table = new HashEntry[TABLE_SIZE];
    for (int i = 0; i < TABLE_SIZE; i++) {
      table[i] = null;
    }
  }

  /**
   * Set a new key and value pair into the hash table
   *
   * @param key to set
   * @param value to set
   */
  public void put(int key, int value) {
    int hash = (key % TABLE_SIZE);
    while (table[hash] != null && table[hash].getKey() != key) {
      hash = (hash + 1) % TABLE_SIZE;
    }
    table[hash] = new HashEntry(key, value);
  }

  /**
   *
   * Get the value at the given key location
   * @param key
   * @return the value at the given key
   */
  public int get(int key) {
    int hash = (key % TABLE_SIZE);
    while (table[hash] != null && table[hash].getKey() != key) {
      hash = (hash + 1) % TABLE_SIZE;
    }
    if (table[hash] == null) {
      return -1;
    } else {
      return table[hash].getValue();
    }
  }
}
