package app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/form")
public class FormController {

  @GetMapping
  public String form() {
    return "form1";
  }

  @ResponseBody
  @PostMapping
  public String handle(AbcForm form, BcdForm form2) {
    return String.format("x=%s, y=%s, a=%s, b=%s",
      form.x, form.y, form2.a, form2.b
    );
  }


}
