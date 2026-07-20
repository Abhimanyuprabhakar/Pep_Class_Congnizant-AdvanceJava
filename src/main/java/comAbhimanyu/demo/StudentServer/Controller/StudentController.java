package comAbhimanyu.demo.StudentServer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import comAbhimanyu.demo.StudentServer.Dto.CreateStudentRequestDTO;
import comAbhimanyu.demo.StudentServer.Dto.StudentResponseDTO;
import comAbhimanyu.demo.StudentServer.Dto.UpdateStudentRequestDTO;
import comAbhimanyu.demo.StudentServer.Entity.Student;
import comAbhimanyu.demo.StudentServer.Service.StudentService;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /*
     * Rather than directly using student object to pass data, we will use
     * CreateStudentRequestDTO.
     * Which also makes the code loosely coupled
     */

    // @PostMapping("/create")
    // public ResponseEntity<?> storeStudent(@RequestBody Student student){
    // // return student.toString();
    // Student result = studentService.studentSave(student); //Using service to
    // validate and save the student

    // if(result == null){
    // return ResponseEntity.status(400).body("Student information is invalid");
    // }

    // return ResponseEntity.status(201).body(result);
    // }

    @PostMapping("/create")
    public ResponseEntity<?> storeStudent(@RequestBody CreateStudentRequestDTO studentRequestDTO) {

        // return student.toString();
        StudentResponseDTO result = studentService.studentSave(studentRequestDTO); // Using service to validate
                                                                                         // and save the student
        if (result == null) {
            return ResponseEntity.status(400).body("Student information is invalid");
        }
        return ResponseEntity.status(201).body(result);
    }

    /* Convertion into DTO from Student Object */
    // @GetMapping("/getStudent/{id}")
    // public ResponseEntity<?> getStudent(@PathVariable int id){
    // Student student = studentService.getStudentById(id);
    // if(student == null){
    // return ResponseEntity.status(404).body("Student not found with id: " + id);
    // }
    // return ResponseEntity.status(200).body(student);
    // }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id) {

        StudentResponseDTO response = studentService.getStudentDTOById(id);

        if (response == null) {
            return ResponseEntity.status(404)
                    .body("Student not found with id : " + id);
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            return ResponseEntity.status(404).body("No students found");
        }
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    /*
     * Update student
     * conversion to DTO below this
     */
    // @PutMapping("/updateStudent/{id}")
    // public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody
    // Student student){
    // //1. find student
    // Student prevStudent = studentService.getStudentById(id);

    // if(prevStudent == null){
    // return ResponseEntity.status(404).body("Student not found with id: " + id);
    // }

    // // update
    // prevStudent.setName(student.getName());
    // prevStudent.setDepartment(student.getDepartment());
    // prevStudent.setAge(student.getAge());

    // studentService.studentUpdateSave(prevStudent);
    // return ResponseEntity.status(200).body(prevStudent);
    // }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id,
            @RequestBody UpdateStudentRequestDTO studentRequestDTO) {

        StudentResponseDTO response = studentService.updateStudent(id, studentRequestDTO);

        if (response == null) {
            return ResponseEntity.status(404).body("Student not found with id: " + id);
        }

        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.status(404).body("Student not found with id: " + id);
        }
        studentService.deleteStudentById(id);
        return ResponseEntity.status(200).body("Student deleted successfully");
    }
}
