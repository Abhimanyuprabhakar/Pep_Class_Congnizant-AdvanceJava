package comAbhimanyu.demo.StudentServer.DTO;

public class CreateStudentRequestDTO {
    private String name;
    private int age;
    private String department;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
