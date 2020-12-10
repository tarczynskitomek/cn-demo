package it.tarczynski.cndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CnDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CnDemoApplication.class, args);
  }

}


@RestController
@RequestMapping("/strings")
class NegotiatingController {


  @GetMapping(produces = {"text/string.v1+plain"})
  String getStringV1() {
    return "I'm the V1 version";
  }


  @GetMapping(produces = {"text/string.v2+plain"})
  String getStringV2() {
    return "I'm the V2 version";
  }
}
