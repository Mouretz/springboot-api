package med.api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello") //Dizer qual e o mapeamento ou qual URL este controlador vai responder
public class HelloController {
    @GetMapping
    public String olaMundo() {
        return "Hello World Dev";
    }
}
