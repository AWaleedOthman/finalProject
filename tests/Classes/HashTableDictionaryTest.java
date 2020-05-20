package Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableDictionaryTest {

    private class Person {
        String name;
        String nickName;
        int ID;

        public Person(String name, String nickName, int ID) {
            this.name = name;
            this.nickName = nickName;
            this.ID = ID;
        }
    }

    @Test
    void test() {
        HashTableDictionary<String, Person> hashTableDictionary = new HashTableDictionary<>();
        assertTrue(hashTableDictionary.isEmpty());
        Person p1 = new Person("Ahmad", "7amada", 124536);
        hashTableDictionary.set("Ahmad", p1);
        assertEquals(p1, hashTableDictionary.get("Ahmad"));
        Person p2 = new Person("Ahmad", "mido", 124536);
        hashTableDictionary.set("Ahmad2", p2);
        assertEquals(p1, hashTableDictionary.get("Ahmad"));
        Person p3 = new Person("Ahmad", "none", 124536);
        hashTableDictionary.set("Ahmad3", p3);
        Person p4 = new Person("Ahmad", "none", 124536);
        hashTableDictionary.set("Ahmad4", p4);
        Person p5 = new Person("Ahmad", "none", 124536);
        hashTableDictionary.set("Ahmad5", p5);
        Person p6 = new Person("Ahmad", "none", 124536);
        hashTableDictionary.set("Ahmad6", p6);
        Person p7 = new Person("Ahmad", "none", 124536);
        hashTableDictionary.set("Ahmad7", p7);
        Person p8 = new Person("Ahmad", "none", 124536);
        hashTableDictionary.set("Ahmad8", p8);
        Person p9 = new Person("Ahmad", "none", 124536);
        hashTableDictionary.set("Ahmad9", p9);
        Person p10 = new Person("Ahmad", "none", 124536);
        hashTableDictionary.set("Ahmad10", p10);
        Person p11 = new Person("Ahmad", "none", 124536);
        hashTableDictionary.set("Ahmad11", p11);
        Person p12 = new Person("Ahmad", "none", 124536);
        hashTableDictionary.set("Ahmad12", p12);
        hashTableDictionary.set("Ahmad12", p11);
        assertEquals(p2, hashTableDictionary.get("Ahmad2"));
        assertEquals(p1, hashTableDictionary.get("Ahmad"));
        assertEquals(p2, hashTableDictionary.get("Ahmad2"));
        assertEquals(p3, hashTableDictionary.get("Ahmad3"));
        assertEquals(p11, hashTableDictionary.get("Ahmad12"));
        assertFalse(hashTableDictionary.isEmpty());
    }

}
