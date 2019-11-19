package y.cl;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloController {

//    @Autowired
//    @Value("${info.foo}")
//    private String foo;

    private final InfoProperties infoProperties;

    @RequestMapping("/")
    public String home() {
        return "Hello World! " + infoProperties.getFoo();
    }

}
