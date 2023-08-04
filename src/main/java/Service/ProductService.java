package Service;

import DTOs.RequestDto.ProductRequestDto;
import DTOs.ResponseDto.ProductResponseDto;
import Models.Product;
import Repository.ProductRepository;
import Transformers.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public String addProduct(ProductRequestDto productRequestDto) {

        Product product = ProductTransformer.convertDtoToEntity(productRequestDto);

        productRepository.save(product);

        return "Product is added in the database";
    }

    public ProductResponseDto getProduct(String category) {

        List<Product> productList = productRepository.findAll();

        int maxPrice = 0;
        Product productRet = null;

        for(Product product : productList){
            if(product.getCategory().equals(category) && product.getPrice()>maxPrice){
                maxPrice = product.getPrice();
                productRet = product;
            }
        }

        assert productRet != null;
        ProductResponseDto prd = ProductTransformer.convertEntityToDto(productRet);

        return prd;
    }
}
