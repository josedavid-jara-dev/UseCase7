package converters;

import java.util.List;
import java.util.stream.Collectors;
import entities.Student;

public class StudentConverter {
    public List<Student> convertStudents(List<Student> students) {

        return students.stream().map(student ->
        {
            Student result = new Student();

            result.setName(student.getName());
            result.setAge(student.getAge());
            result.setGrade(student.getGrade());

            if (student.getGrade() > 90) {
                if (student.getAge() < 21) {
                    result.setExceptional(true);
                } else {
                    result.setHonorRoll(true);
                }
            } else {
                result.setPassed(student.getGrade() > 70);
            }

            return result;
        }).collect(Collectors.toList());
    }
}
