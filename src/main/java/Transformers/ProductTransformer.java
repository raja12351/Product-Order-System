package Transformers;

import DTOs.RequestDto.ProductRequestDto;
import DTOs.ResponseDto.ProductResponseDto;
import Models.Product;

public class ProductTransformer {

    public static Product convertDtoToEntity(ProductRequestDto productRequestDto){

        Product product = Product.builder().name(productRequestDto.getName())
                .category(productRequestDto.getCategory()).price(productRequestDto.getPrice())
                .build();

        return product;
    }

    public static ProductResponseDto convertEntityToDto(Product product){
        ProductResponseDto pr = ProductResponseDto.builder().productName(product.getName())
                .price(product.getPrice()).build();

        return pr;
    }
}
