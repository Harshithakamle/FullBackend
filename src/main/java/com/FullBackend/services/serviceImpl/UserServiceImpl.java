package com.FullBackend.services.serviceImpl;

import com.FullBackend.entities.User;
import com.FullBackend.exceptions.ResourceNotFoundException;
import com.FullBackend.payloads.UserDto;
import com.FullBackend.repositories.UserRepository;
import com.FullBackend.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    private ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepo, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = DtoToEntity(userDto);
        User user1 = userRepo.save(user);
        UserDto userDto1 = entityToDto(user1);
        return userDto1;
    }

    @Override
    public UserDto updateUser(UserDto user, long id) {
        User user1 = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
           user1.setName(user.getName());
           user1.setEmail(user.getEmail());
           user1.setPassword(user.getPassword());
           user1.setAbout(user.getAbout());
        User savedUser = userRepo.save(user1);
        UserDto userDto = entityToDto(savedUser);
        return userDto;
    }

    @Override
    public UserDto getUserById(long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
        UserDto userDto = entityToDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDto = users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
        return userDto;
    }

    @Override
    public void deleteUser(long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
          userRepo.delete(user);
    }

    private UserDto entityToDto(User user){
        UserDto userDto = mapper.map(user, UserDto.class);
        return userDto;
    }
    private User DtoToEntity(UserDto userDto){
        User user = mapper.map(userDto,User.class);
        return user;
    }
}
