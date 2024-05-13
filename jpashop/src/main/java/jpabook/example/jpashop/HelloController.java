package jpabook.example.jpashop;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello"); //data에 hello 넣어라!
        return "hello"; //"hello.html"을 찾아 화면에 출력
    }
}
