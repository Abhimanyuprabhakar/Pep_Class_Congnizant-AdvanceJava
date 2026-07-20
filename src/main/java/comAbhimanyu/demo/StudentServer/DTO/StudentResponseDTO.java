package comAbhimanyu.demo.StudentServer.Dto;

public class StudentResponseDTO {
    private int id;
    private String name;
    private int age;
    private String department;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    /*Not need */
    // private LocalDateTime createdAt;
    // private LocalDateTime updatedAt;
}
