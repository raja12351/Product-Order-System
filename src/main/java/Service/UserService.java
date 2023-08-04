package Service;

import DTOs.RequestDto.UserRequestDto;
import Models.User;
import Repository.UserRepository;
import Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserRepository userRepository;
    public String addUser(UserRequestDto userRequestDto) {

        User user = UserTransformer.convertDtoToEntity(userRequestDto);

        userRepository.save(user);
        return "User is added in the database successfully.";
    }
}
