package Controllers;

import DTOs.RequestDto.ProductRequestDto;
import DTOs.ResponseDto.ProductResponseDto;
import Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequestDto productRequestDto){
        String mess = productService.addProduct(productRequestDto);

        return new ResponseEntity<>(mess, HttpStatus.OK);
    }

    @GetMapping("/max-prices-product")
    public ResponseEntity<ProductResponseDto> getProduct(@RequestParam String category){
        ProductResponseDto prd = productService.getProduct(category);

        return new ResponseEntity<>(prd, HttpStatus.OK);
    }
}
