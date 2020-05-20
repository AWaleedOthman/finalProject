package Classes;

import Interfaces.IDictionary;


public class HashTableDictionary<K, V> implements IDictionary<K, V> {
    final private int[] primes = {12, 283, 557, 1019, 2053, 4051, 8087, 16087};
    private int N;
    private int size;
    private SinglyLinkedList.Node temp; //used in multiple parts of the below code to avoid code repetition
    private SinglyLinkedList[] values;

    public HashTableDictionary() {
        N = primes[0];
        size = 0;
        values = new SinglyLinkedList[N];
    }

    private class Pair {
        K key;
        V value;

        public Pair(Object key, Object value) {
            this.key = (K) key;
            this.value = (V) value;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) throw new NullPointerException("key is null");

        int index = key.hashCode() % N;
        SinglyLinkedList list = values[index];
        if (list == null) {
            temp = null;
            return null;
        }
        list.resetNext();
        //search the return it if found
        while (list.hasNext()) {
            if (((Pair) list.peekNext().getContent()).key.equals(key)) {
                temp = list.getCurrent();
                return ((Pair) list.getNext().getContent()).value;
            }
            list.getNext();
        }
        //not found
        temp = null;
        return null;
    }

    @Override
    public V set(K key, V value) {
        //a
        if (key == null || value == null) throw new NullPointerException();
        V v = get(key);
        if (v != null) {
            temp.getNext().setContent(new Pair(key, value));
            return v;
        }

        int index = key.hashCode() % N;
        if (values[index] == null) values[index] = new SinglyLinkedList();
        SinglyLinkedList list = values[index];
        list.add(new Pair(key, value));
        double alpha = 0.9;
        if (++size / (float) N > alpha) {
            rehash();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        //added throw ... & size --
        if (size == 0) throw new RuntimeException();
        V value = get(key);
        if (value == null) throw new RuntimeException();
        temp.removeNext();
        return value;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private void rehash() {
        //changing N
        if (N == primes[primes.length - 1]) return;
        for (int i = 0; i < primes.length - 1; i++) {
            if (N == primes[i]) {
                N = primes[i + 1];
                break;
            }
        }
        //changing array
        SinglyLinkedList[] oldArray = values;
        values = new SinglyLinkedList[N];
        //putting elements of old array into new one
        for (SinglyLinkedList sll : oldArray) {
            if (sll == null) continue;
            sll.resetNext();
            while (sll.hasNext()) {
                Pair pair = (Pair) sll.getNext().getContent();
                this.set(pair.key, pair.value);
            }
        }
    }
}
