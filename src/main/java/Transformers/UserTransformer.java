package Transformers;

import DTOs.RequestDto.UserRequestDto;
import Models.User;

public class UserTransformer {

    public static User convertDtoToEntity(UserRequestDto userRequestDto){
        User user = User.builder().username(userRequestDto.getName()).email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword()).build();

        return user;
    }
}
