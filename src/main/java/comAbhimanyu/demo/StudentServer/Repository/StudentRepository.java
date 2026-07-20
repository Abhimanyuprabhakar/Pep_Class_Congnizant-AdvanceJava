package comAbhimanyu.demo.StudentServer.Repository;

import comAbhimanyu.demo.StudentServer.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}
