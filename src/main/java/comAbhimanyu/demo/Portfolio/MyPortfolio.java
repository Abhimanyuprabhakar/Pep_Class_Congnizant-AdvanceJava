package comAbhimanyu.demo.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {

    @GetMapping("/mySelf")
    public String Myself() {
    return """
            <h1>Myself</h1>
            <p> simple line about yourself </p>
            <ul>
            <li>gitHub Link : link</li>
            <li>Leetcode Link : link link</li>
            </ul>
            """;
    }

    @GetMapping("/education")
    public String getEducation() {
        return """
                <h2>Education</h2>
                <ul>
                    <li><b>Master of Computer Applications (MCA)</b></li>
                    <li>Semester: 4th</li>
                    <li>Background: Non-Technical (Successfully transitioned into Software Development)</li>
                </ul>
                """;
    }

    @GetMapping("/skills")
    public String getSkills() {
        return """
                <h2>Technical Skills</h2>
                <ul>
                    <li>Java</li>
                    <li>Spring Core</li>
                    <li>Spring Boot</li>
                    <li>Spring MVC</li>
                    <li>Spring Data JPA</li>
                    <li>Hibernate</li>
                    <li>REST API Development</li>
                    <li>MySQL</li>
                    <li>H2 Database</li>
                    <li>Maven</li>
                    <li>Git & GitHub</li>
                    <li>HTML</li>
                    <li>CSS</li>
                    <li>JavaScript</li>
                    <li>React</li>
                </ul>
                """;
    }

    @GetMapping("/projectname")
    public String getProjects() {
        return """
                <h2>Projects</h2>
                <ol>
                    <li><b>Travel Booking Platform</b> - Built using Java, Spring Boot, RBAC, and REST APIs.</li>
                    <li><b>URL Shortener</b> - Node.js, Express.js, MongoDB, and EJS.</li>
                    <li><b>Student Management System</b> - Spring Boot + Spring Data JPA + H2/MySQL.</li>
                </ol>
                """;
    }

    @GetMapping("/contact")
    public String getContact() {
        return """
                <h2>Contact</h2>
                <ul>
                    <li>Name: Mohit</li>
                    <li>Role: Software Engineer</li>
                    <li>GitHub: github.com/your-github</li>
                    <li>LinkedIn: linkedin.com/in/your-linkedin</li>
                    <li>Email: your-email@example.com</li>
                </ul>
                """;
    }

}
