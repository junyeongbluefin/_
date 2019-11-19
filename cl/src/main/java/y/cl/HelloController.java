package y.cl;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloController {

    private final InfoProperties infoProperties;

    @RequestMapping("/")
    public String home() {
        return "Hello World! " + infoProperties.getFoo();
    }

}
