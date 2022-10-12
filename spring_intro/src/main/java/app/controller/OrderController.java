package app.controller;

import app.dto.Order;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

  /**
   * http://localhost:8080/order
   */
  @GetMapping
  public List<Order> all() {
    return Arrays.asList(
      new Order(1, 123.45, "test1"),
      new Order(2, 1123.45, "test2")
    );
  }

  /**
   * http://localhost:8080/order/1
   * http://localhost:8080/order/2
   * http://localhost:8080/order/3
   */
  @GetMapping("{id}")
  public String handle1(@PathVariable("id") Integer id) {
    return String.format("id = %d", id);
  }

  @PostMapping
  public Order handle2(@RequestBody Order o) {
    System.out.println(o.toString());
//    o.setId(o.getId() + 100);
//    o.setComment(o.getComment().toUpperCase());
    return o;
  }
}
