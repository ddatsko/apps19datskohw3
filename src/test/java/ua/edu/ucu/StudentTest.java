package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() {
        student = new Student("Denys", "Datsko", 5.0, 2);
    }

    @Test
    public void testStudentCreation() {
        assertEquals(student.getSurname(), "Datsko");
        assertEquals(student.getName(), "Denys");
        assertEquals(student.getGPA(), 5.0, 0.00001);
        assertEquals(student.getYear(), 2);
    }

    @Test
    public void testStudentEqualsTrue() {
        Student newStudent = new Student("Denys", "Datsko", 5.0, 2);
        assertEquals(newStudent, student);
    }

    @Test
    public void testStudentEqualsFalse() {
        Student newStudent = new Student("Andrii", "Uhera", 5.0, 3);
        assertNotEquals(student, newStudent);
    }

    @Test
    public void testStudentEqualsWithInt() {
        assertNotEquals(student, 1);
    }

    @Test
    public void testStudentEqualsSameHashCode() {
        Student newStudent = new Student("Denys", "Datsko", 5.2, 2);
        assertNotEquals(student, newStudent);
    }

    @Test
    public void testStudentToString() {
        String expected = "Student{name=Denys, surname=Datsko, "
                + "GPA=5.0, year=2}";
        assertEquals(expected, student.toString());
    }
}
