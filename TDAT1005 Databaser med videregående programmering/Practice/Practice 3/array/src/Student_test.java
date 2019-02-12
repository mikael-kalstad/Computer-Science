import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Student_test {
    static Student instance = null;

    @BeforeAll
    public static void setUp() {
        instance = new Student("John Deer", 3);
    }

    @AfterAll
    public static void tearDown() {
        System.out.println(instance.toString());
        instance = null;
    }

    @Test
    public void getName() {
        String expected = "John Deer";
        String result = instance.getName();
        assertEquals(expected, result);
    }

    @Test
    public void getNumOfTasks() {
        Student per = new Student("Per Hansen", 3);
        int expected = 3;
        int result = per.getNumOfTasks();
        assertEquals(expected, result);
    }

    @Test
    public void increaseNumOfTasks() {
        instance.increaseNumOfTasks(4);
        int expected = 7;
        int result = instance.getNumOfTasks();
        assertEquals(expected, result);
    }
    @Test
    public void increaseNumOfTasks2() {
        instance.increaseNumOfTasks(4);
        int expected = 7;
        int result = instance.getNumOfTasks();
        assertEquals(expected, result);
    }

}
