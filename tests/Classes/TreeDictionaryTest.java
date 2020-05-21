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
        TreeDictionary<String, Person> TreeDictionary = new TreeDictionary<>();
        assertTrue(TreeDictionary.isEmpty());
        Person p1 = new Person("Ahmad", "7amada", 124536);
        TreeDictionary.set("Ahmad", p1);
        assertFalse(TreeDictionary.isEmpty());
        assertEquals(p1, TreeDictionary.get("Ahmad"));
        assertEquals(p1, TreeDictionary.remove("Ahmad"));
        assertTrue(TreeDictionary.isEmpty());
        TreeDictionary.set("Ahmad", p1);
        Person p2 = new Person("Ahmad", "mido", 124536);
        TreeDictionary.set("Ahmad2", p2);
        assertEquals(p1, TreeDictionary.get("Ahmad"));
        Person p3 = new Person("Ahmad", "none", 124536);
        TreeDictionary.set("Ahmad3", p3);
        Person p4 = new Person("Ahmad", "none", 124536);
        TreeDictionary.set("Ahmad4", p4);
        Person p5 = new Person("Ahmad", "none", 124536);
        TreeDictionary.set("Ahmad5", p5);
        Person p6 = new Person("Ahmad", "none", 124536);
        TreeDictionary.set("Ahmad6", p6);
        Person p7 = new Person("Ahmad", "none", 124536);
        TreeDictionary.set("Ahmad7", p7);
        Person p8 = new Person("Ahmad", "none", 124536);
        TreeDictionary.set("Ahmad8", p8);
        Person p9 = new Person("Ahmad", "none", 124536);
        TreeDictionary.set("Ahmad9", p9);
        Person p10 = new Person("Ahmad", "none", 124536);
        TreeDictionary.set("Ahmad10", p10);
        Person p11 = new Person("Ahmad", "none", 124536);
        TreeDictionary.set("Ahmad11", p11);
        Person p12 = new Person("Ahmad", "none", 124536);
        TreeDictionary.set("Ahmad12", p12);
        TreeDictionary.set("Ahmad12", p11);
        assertEquals(p2, TreeDictionary.get("Ahmad2"));
        assertEquals(p1, TreeDictionary.get("Ahmad"));
        assertEquals(p2, TreeDictionary.get("Ahmad2"));
        assertEquals(p3, TreeDictionary.get("Ahmad3"));
        assertEquals(p11, TreeDictionary.get("Ahmad12"));
        assertEquals(p7, TreeDictionary.get("Ahmad7"));
        assertFalse(TreeDictionary.isEmpty());
        assertNull(TreeDictionary.remove("M"));
        assertEquals(p7, TreeDictionary.remove("Ahmad7"));
        assertNull(TreeDictionary.get("Ahmad7"));
    }

}
