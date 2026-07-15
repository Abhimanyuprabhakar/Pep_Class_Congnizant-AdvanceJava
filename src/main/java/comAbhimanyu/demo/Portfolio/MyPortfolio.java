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
}
