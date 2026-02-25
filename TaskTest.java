package Task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskTest {

    private Task makeValid() {
        return new Task("2345", "Cleaning", "Clean the office");
    }

    private String id10() {
        return "1234567890"; // 10 chars
    }

    private String name20() {
        return "ABCDEFGHIJKLMNOPQRST"; // 20 chars
    }

    private String desc50() {
        return "12345678901234567890123456789012345678901234567890"; // 50 chars
    }

    private String name21() {
        return "ABCDEFGHIJKLMNOPQRSTU"; // 21 chars
    }

    private String desc51() {
        return "123456789012345678901234567890123456789012345678901"; // 51 chars
    }

    // valid / boundary
    @Test
    void testValidTask() {
        Task t = new Task("4325", "Organizing", "Organize files");
        assertEquals("4325", t.getTaskID());
        assertEquals("Organizing", t.getTaskName());
        assertEquals("Organize files", t.getDescription());
    }

    @Test
    void testBoundaryValuesAreValid() {
        assertDoesNotThrow(() -> new Task(id10(), name20(), desc50()));
    }

    // null tests (Objects.requireNonNull -> NullPointerException)
    @Test
    void taskIdNull_throws() {
        assertThrows(NullPointerException.class, () -> new Task(null, "Name", "Desc"));
    }

    @Test
    void taskNameNull_throws() {
        assertThrows(NullPointerException.class, () -> new Task("1234", null, "Desc"));
    }

    @Test
    void taskDescriptionNull_throws() {
        assertThrows(NullPointerException.class, () -> new Task("1234", "Name", null));
    }

    // too long tests
    @Test
    void taskIdTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Name", "Desc")); // 11 chars
    }

    @Test
    void taskNameTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1234", name21(), "Desc"));
    }

    @Test
    void taskDescriptionTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1234", "Name", desc51()));
    }

    // blank tests (isBlank -> IllegalArgumentException)
    @Test
    void taskIdBlank_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Task("   ", "Name", "Desc"));
    }

    @Test
    void taskNameBlank_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1234", "   ", "Desc"));
    }

    @Test
    void taskDescriptionBlank_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1234", "Name", "   "));
    }

    // valid setters
    @Test
    void setTaskNameValid() {
        Task t = makeValid();
        t.setTaskName("Washing");
        assertEquals("Washing", t.getTaskName());
    }

    @Test
    void setTaskDescriptionValid() {
        Task t = makeValid();
        t.setDescription("Going to the market");
        assertEquals("Going to the market", t.getDescription());
    }

    // boundary setters
    @Test
    void setTaskNameBoundary20Valid() {
        Task t = makeValid();
        String n20 = name20();
        assertEquals(20, n20.length());
        t.setTaskName(n20);
        assertEquals(n20, t.getTaskName());
    }

    @Test
    void setTaskDescriptionBoundary50Valid() {
        Task t = makeValid();
        String d50 = desc50();
        assertEquals(50, d50.length());
        t.setDescription(d50);
        assertEquals(d50, t.getDescription());
    }

    // invalid setters
    @Test
    void setTaskNameNull_throws() {
        Task t = makeValid();
        assertThrows(NullPointerException.class, () -> t.setTaskName(null));
    }

    @Test
    void setTaskNameBlank_throws() {
        Task t = makeValid();
        assertThrows(IllegalArgumentException.class, () -> t.setTaskName("   "));
    }

    @Test
    void setTaskNameTooLong_throws() {
        Task t = makeValid();
        assertThrows(IllegalArgumentException.class, () -> t.setTaskName(name21()));
    }

    @Test
    void setDescriptionNull_throws() {
        Task t = makeValid();
        assertThrows(NullPointerException.class, () -> t.setDescription(null));
    }

    @Test
    void setDescriptionBlank_throws() {
        Task t = makeValid();
        assertThrows(IllegalArgumentException.class, () -> t.setDescription("   "));
    }

    @Test
    void setDescriptionTooLong_throws() {
        Task t = makeValid();
        assertThrows(IllegalArgumentException.class, () -> t.setDescription(desc51()));
    }

    @Test
    void constructorStoresValues_valid() {
        Task t = new Task("9999", "ValidName", "Valid description");
        assertEquals("9999", t.getTaskID());
        assertEquals("ValidName", t.getTaskName());
        assertEquals("Valid description", t.getDescription());
    }
}






