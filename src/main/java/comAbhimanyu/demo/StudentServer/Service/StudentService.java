package comAbhimanyu.demo.StudentServer.Service;

import comAbhimanyu.demo.StudentServer.Entity.Student;
import comAbhimanyu.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create Student
    public Student studentValidate(Student student) {

        int id = student.getId();
        String name = student.getName();
        int age = student.getAge();
        String department = student.getDepartment();

        if (id < 0 || name == null || name.isBlank()
                || age < 0 || department == null || department.isBlank()) {
            return null;
        }

        return studentRepository.save(student);
    }

    // Get Student by ID
    public Student getStudentByID(Integer id) {

        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            return student.get();
        }

        return null;
    }
    public Student updateStudent(Integer id, Student student) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setDepartment(student.getDepartment());

        return studentRepository.save(existingStudent);
    }
    public boolean deleteStudent(Integer id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return false;
        }

        studentRepository.delete(student);

        return true;
    }
}