package comAbhimanyu.demo.StudentServer.Dto;

import java.time.LocalDateTime;


public class CreateStudentRequestDTO {

    private String name;
    private String department;
    private int age;

    public CreateStudentRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}