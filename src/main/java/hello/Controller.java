package hello;

import hello.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

  @Autowired
  private GreetingService _greetingService;

  @GetMapping("/")
  public String greet(){
    return _greetingService.greet();
  }
}
