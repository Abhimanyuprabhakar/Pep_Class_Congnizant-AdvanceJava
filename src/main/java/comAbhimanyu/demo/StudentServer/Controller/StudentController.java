package comAbhimanyu.demo.StudentServer.Controller;

import comAbhimanyu.demo.StudentServer.Entity.Student;
import comAbhimanyu.demo.StudentServer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> storeStudent(@RequestBody Student student) {
        Student result = studentService.studentValidate(student);

        if(result == null)
        {
           return ResponseEntity.status(400).body(result);
        }
        return  ResponseEntity.status(201).body(result);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        Student student = studentService.getStudentByID(id);
        return ResponseEntity.status(200).body(student);
    }
}
