package Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeDictionaryTest {

    private static class Person {
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
        TreeDictionary<String, Person> treeDictionary = new TreeDictionary<>();
        assertTrue(treeDictionary.isEmpty());
        Person p1 = new Person("Ahmad", "7amada", 124536);
        treeDictionary.set("Ahmad", p1);
        assertFalse(treeDictionary.isEmpty());
        assertEquals(p1, treeDictionary.get("Ahmad"));
        assertEquals(p1, treeDictionary.remove("Ahmad"));
        assertTrue(treeDictionary.isEmpty());
        treeDictionary.set("6", p1);
        Person p2 = new Person("Ahmad", "mido", 124536);
        treeDictionary.set("4", p2);
        assertEquals(p1, treeDictionary.get("6"));
        Person p3 = new Person("Ahmad", "none", 124536);
        treeDictionary.set("8", p3);
        Person p4 = new Person("Ahmad", "none", 124536);
        treeDictionary.set("5", p4);
        Person p5 = new Person("Ahmad", "none", 124536);
        treeDictionary.set("11", p5);
        Person p6 = new Person("Ahmad", "none", 124536);
        treeDictionary.set("10", p6);
        Person p7 = new Person("Ahmad", "none", 124536);
        treeDictionary.set("12", p7);
        Person p8 = new Person("Ahmad", "none", 124536);
        treeDictionary.set("27", p8);
        Person p9 = new Person("Ahmad", "none", 124536);
        treeDictionary.set("0", p9);
        Person p10 = new Person("Ahmad", "none", 124536);
        treeDictionary.set("Ahmad10", p10);
        Person p11 = new Person("Ahmad", "none", 124536);
        treeDictionary.set("Ahmad11", p11);
        assertEquals(p11, treeDictionary.get("Ahmad11"));
        Person p12 = new Person("Ahmad", "none", 124536);
        treeDictionary.set("Ahmad12", p12);
        treeDictionary.set("Ahmad12", p11);
        assertEquals(p2, treeDictionary.get("4"));
        assertEquals(p1, treeDictionary.get("6"));
        assertEquals(p2, treeDictionary.get("4"));
        assertEquals(p3, treeDictionary.get("8"));
        assertEquals(p11, treeDictionary.get("Ahmad12"));
        assertEquals(p7, treeDictionary.get("12"));
        assertFalse(treeDictionary.isEmpty());
        assertNull(treeDictionary.remove("M"));
        assertEquals(p5, treeDictionary.remove("11"));
        assertNull(treeDictionary.get("11"));
        assertEquals(p11, treeDictionary.get("Ahmad11"));
        assertEquals(p1, treeDictionary.remove("6"));
        assertEquals(p11, treeDictionary.get("Ahmad11"));
        assertEquals(p2, treeDictionary.get("4"));
        assertEquals(p3, treeDictionary.get("8"));
        assertEquals(p11, treeDictionary.get("Ahmad11"));
        assertEquals(p11, treeDictionary.remove("Ahmad11"));
        assertNull(treeDictionary.get("Ahmad11"));
        assertEquals(p11, treeDictionary.get("Ahmad12"));
        assertEquals(p9, treeDictionary.remove("0"));
        assertEquals(p3, treeDictionary.remove("8"));
        assertEquals(p6, treeDictionary.remove("10"));
        assertEquals(p2, treeDictionary.remove("4"));
        assertEquals(p11, treeDictionary.remove("Ahmad12"));
        TreeDictionary<String, Integer> treeDictionary2 = new TreeDictionary<>();
        treeDictionary2.set("5", 5);
        treeDictionary2.set("10", 10);
        treeDictionary2.set("9", 9);
        treeDictionary2.set("8", 8);
        treeDictionary2.set("7", 7);
        assertEquals(5, treeDictionary2.remove("5"));
        assertEquals(10, treeDictionary2.get("10"));
        assertEquals(9, treeDictionary2.get("9"));
        assertEquals(8, treeDictionary2.get("8"));
        assertEquals(7, treeDictionary2.get("7"));
    }

}
