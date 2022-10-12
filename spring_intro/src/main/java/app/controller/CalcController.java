package app.controller;

import app.service.CalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calc")
@RequiredArgsConstructor
public class CalcController {

  final private CalcService calcService;

  /** http://localhost:8080/calc/add?a=1&b=2 */
  @GetMapping("add")
  public String doAdd(
    @RequestParam("a") Integer a,
    @RequestParam("b") Integer b
  )
  {
    int c = calcService.add(a, b);
    return String.format("%d + %d = %d", a, b, c);
  }

  /**
   * http://localhost:8081/calc/read
   */
  @GetMapping("read")
  public String aaa() {
    return calcService.readProp();
  }
}
