package DTOs.RequestDto;

import lombok.Data;

@Data
public class ProductRequestDto {

    private String name;

    private String category;

    private int price;
}
