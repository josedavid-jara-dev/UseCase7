import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import converters.StudentConverter;
import entities.Student;

class StudentConverterTest {

    final StudentConverter studentConverter;

    StudentConverterTest() {
        this.studentConverter = new StudentConverter();
    }

    @Test
    void testHighAchiever() {
        // Set up test data
        Student studentToTestOne = new Student();
        studentToTestOne.setName("StudentOne");
        studentToTestOne.setAge(21);
        studentToTestOne.setGrade(95);
        Student studentToTestTwo = new Student();
        studentToTestTwo.setName("StudentTwo");
        studentToTestTwo.setAge(18);
        studentToTestTwo.setGrade(91);
        Student studentToTestThree = new Student();
        studentToTestThree.setName("StudentThree");
        studentToTestThree.setAge(22);
        studentToTestThree.setGrade(42);
        List<Student> studentsToTest = List.of(studentToTestOne, studentToTestTwo, studentToTestThree);
        // Invoke tested method
        List<Student> result = this.studentConverter.convertStudents(studentsToTest);
        Optional<Student> firstStudentResult = result
                .stream()
                .filter(s -> s.getName().equals(studentToTestOne.getName()))
                .findFirst();
        Optional<Student> secondStudentResult = result
                .stream()
                .filter(s -> s.getName().equals(studentToTestTwo.getName()))
                .findFirst();
        Optional<Student> thirdStudentResult = result
                .stream()
                .filter(s -> s.getName().equals(studentToTestThree.getName()))
                .findFirst();
        // Verify expected results
        firstStudentResult.ifPresent(student -> assertTrue(student.isHonorRoll()));
        secondStudentResult.ifPresent(student -> assertFalse(student.isHonorRoll()));
        thirdStudentResult.ifPresent(student -> assertFalse(student.isHonorRoll()));
    }

    @Test
    void testYoungHighAchiever() {
        // Set up test data
        Student studentToTestOne = new Student();
        studentToTestOne.setName("StudentOne");
        studentToTestOne.setAge(18);
        studentToTestOne.setGrade(95);
        Student studentToTestTwo = new Student();
        studentToTestTwo.setName("StudentTwo");
        studentToTestTwo.setAge(18);
        studentToTestTwo.setGrade(55);
        Student studentToTestThree = new Student();
        studentToTestThree.setName("StudentThree");
        studentToTestThree.setAge(22);
        studentToTestThree.setGrade(96);
        List<Student> studentsToTest = List.of(studentToTestOne, studentToTestTwo, studentToTestThree);
        // Invoke tested method
        List<Student> result = this.studentConverter.convertStudents(studentsToTest);
        Optional<Student> firstStudentResult = result
                .stream()
                .filter(s -> s.getName().equals(studentToTestOne.getName()))
                .findFirst();
        Optional<Student> secondStudentResult = result
                .stream()
                .filter(s -> s.getName().equals(studentToTestTwo.getName()))
                .findFirst();
        Optional<Student> thirdStudentResult = result
                .stream()
                .filter(s -> s.getName().equals(studentToTestThree.getName()))
                .findFirst();
        // Verify expected results
        firstStudentResult.ifPresent(student -> assertTrue(student.isExceptional()));
        secondStudentResult.ifPresent(student -> assertFalse(student.isExceptional()));
        thirdStudentResult.ifPresent(student -> assertFalse(student.isExceptional()));
    }

    @Test
    void testPassedStudents() {
        // Set up test data
        Student studentToTestOne = new Student();
        studentToTestOne.setName("StudentOne");
        studentToTestOne.setGrade(90);
        Student studentToTestTwo = new Student();
        studentToTestTwo.setName("StudentTwo");
        studentToTestTwo.setGrade(71);
        List<Student> studentsToTest = List.of(studentToTestOne, studentToTestTwo);
        // Invoke tested method
        List<Student> result = this.studentConverter.convertStudents(studentsToTest);
        Optional<Student> firstStudentResult = result
                .stream()
                .filter(s -> s.getName().equals(studentToTestOne.getName()))
                .findFirst();
        Optional<Student> secondStudentResult = result
                .stream()
                .filter(s -> s.getName().equals(studentToTestTwo.getName()))
                .findFirst();
        // Verify expected results
        firstStudentResult.ifPresent(student -> assertTrue(student.isPassed()));
        secondStudentResult.ifPresent(student -> assertTrue(student.isPassed()));
    }

    @Test
    void testFailedStudents() {
        // Set up test data
        Student studentToTestOne = new Student();
        studentToTestOne.setName("StudentOne");
        studentToTestOne.setGrade(70);
        List<Student> studentsToTest = List.of(studentToTestOne);
        // Invoke tested method
        List<Student> result = this.studentConverter.convertStudents(studentsToTest);
        Optional<Student> firstStudentResult = result
                .stream()
                .filter(s -> s.getName().equals(studentToTestOne.getName()))
                .findFirst();
        // Verify expected results
        firstStudentResult.ifPresent(student -> assertFalse(student.isPassed()));
    }

    @Test
    void testEmptyStudentList() {
        // Set up test data
        List<Student> studentsToTest = new ArrayList<>();
        // Invoke tested method
        List<Student> result = this.studentConverter.convertStudents(studentsToTest);
        // Verify expected results
        assertTrue(result.isEmpty());
    }

    @Test
    void testNullStudentList() {
        // Set up test data
        List<Student> studentsToTest = null;
        // Verify expected results
        Assertions.assertThrows(NullPointerException.class, () -> {
            // Invoke tested method
            this.studentConverter.convertStudents(studentsToTest);
        });
    }
}
