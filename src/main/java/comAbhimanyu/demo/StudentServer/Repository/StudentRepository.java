package comAbhimanyu.demo.StudentServer.Repository;

import comAbhimanyu.demo.StudentServer.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    /*basic check method */
    // public String save(Student student){
    //     System.out.println("Student saved: " + student.toString());
    //     return "Student saved successfully";
    // }
}
