package Controllers;

import Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/add-order")
    public ResponseEntity<String> addOrder(@RequestParam Character s){
        String mess = orderService.addOrder(s);

        return new ResponseEntity<>(mess, HttpStatus.OK);
    }

    @PostMapping("/add-order-lowest-price")
    public ResponseEntity<String> addOrderLow(){
        String mess = orderService.addLowOrder();
        return new ResponseEntity<>("hello",HttpStatus.OK);
    }
}
