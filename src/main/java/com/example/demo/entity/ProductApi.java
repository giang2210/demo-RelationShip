package com.example.demo.entity;

import com.example.demo.many2many.usecompositekey.Grade;
import com.example.demo.many2many.usecompositekey.GradeService;
import com.example.demo.many2many.usecompositekey.Student;
import com.example.demo.many2many.usecompositekey.StudentService;
import com.example.demo.order.Order;
import com.example.demo.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductApi {
    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;
    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product){
        System.out.println(product.getId());
        return productService.save(product);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll(){
        return productService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "add_order")
    public ResponseEntity<?> addProductToOrder(
            @RequestParam int productId,
            @RequestParam int orderId){
        // check sự tồn tại của student
        Optional<Product> optionalProduct = productService.findById(productId);
        // check sự tồn tại của grade
        Optional<Order>  optionalOrder= orderService.findById(orderId);
        // trả về not found nếu một trong hai trường hợp không tìm thấy
        if (!optionalProduct.isPresent() || !optionalOrder.isPresent()){
            return  new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
        boolean result = productService.addProductToClass(optionalProduct.get(), optionalOrder.get());
        if (!result){
            return  new ResponseEntity<>("Add student error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>("Add student success!", HttpStatus.OK);
    }
}
