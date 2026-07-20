package comAbhimanyu.demo.StudentServer.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import comAbhimanyu.demo.StudentServer.Dto.CreateStudentRequestDTO;
import comAbhimanyu.demo.StudentServer.Dto.StudentResponseDTO;
import comAbhimanyu.demo.StudentServer.Dto.UpdateStudentRequestDTO;
import comAbhimanyu.demo.StudentServer.Entity.Student;
import comAbhimanyu.demo.StudentServer.Repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository studentRepository; // Create ref for StudentRepository class to save into DB

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // private boolean isStudentValid(Student student){
    // int id = student.getId();
    // String name = student.getName();
    // String department = student.getDepartment();
    // int age = student.getAge();

    // if(id < 0 || name == null || age <0 || department == null){
    // return false;
    // }
    // return true;
    // }

    /*
     * studentSave method.
     * Student Class conversion to CreateStudentRequestDTO
     */
    // public Student studentSave(Student student) {
    // if(!isStudentValid(student)){
    // return null;
    // }
    // if(studentRepository.existsById(student.getId())){
    // return null;
    // }
    // /*We are using the annotation @CreationTimestamp */
    // // student.setCreatedAt(LocalDateTime.now());
    // // student.setUpdatedAt(LocalDateTime.now());
    // return studentRepository.save(student);
    // }

    /* CreateStudentRequestDTO code */
    public StudentResponseDTO studentSave(CreateStudentRequestDTO studentRequestDTO) {
        Student student = mapToStudent(studentRequestDTO);

        Student savedStudent = studentRepository.save(student);
        return mapToResponseDTO(savedStudent);
    }

    private Student mapToStudent(CreateStudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setDepartment(studentRequestDTO.getDepartment());
        return student;
    }

    private StudentResponseDTO mapToResponseDTO(Student student) {
        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setDepartment(student.getDepartment());
        return responseDTO;
    }

    /* Conversion from normal to DTO response for getStudentById */
    public Student getStudentById(int id) {
    return studentRepository.findById(id).orElse(null);
    }

    public StudentResponseDTO getStudentDTOById(int id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        return mapToResponseDTO(student);
    }

    /* Updatesave conversion below using DTO */
    // public Student studentUpdateSave(Student student){
    // // if(!isStudentValid(student)){
    // // return null;
    // // }
    // /*We are using the annotation @UpdateTimestamp */
    // // student.setUpdatedAt(LocalDateTime.now());
    // return studentRepository.save(student);
    // }

    public StudentResponseDTO updateStudent(int id, UpdateStudentRequestDTO updateStudentRequestDTO) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return null;
        }
        student.setName(updateStudentRequestDTO.getName());
        student.setAge(updateStudentRequestDTO.getAge());

        Student updatedStudent = studentRepository.save(student);
        return mapToResponseDTO(updatedStudent);
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
