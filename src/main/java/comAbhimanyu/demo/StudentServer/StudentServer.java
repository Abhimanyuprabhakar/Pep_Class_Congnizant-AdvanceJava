package comAbhimanyu.demo.StudentServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {

//    1. Store the student
    @PostMapping("/create")
    public String storeStudent() {
        return """
                id : 1
                name : Mohit
                Department : CSE
                age : 25
                """;
    }

//    2. Read the Student with id
    

//    3. update the student information

//    4.delete the student information

}
