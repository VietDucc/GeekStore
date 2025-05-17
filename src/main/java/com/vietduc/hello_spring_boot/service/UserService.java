package com.vietduc.hello_spring_boot.service;

import com.vietduc.hello_spring_boot.dto.request.AddressRequest;
import com.vietduc.hello_spring_boot.dto.request.UserRequest;
import com.vietduc.hello_spring_boot.entity.Address;
import com.vietduc.hello_spring_boot.entity.User;
import com.vietduc.hello_spring_boot.repository.AddressRepository;
import com.vietduc.hello_spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    public User createUser(UserRequest request) {
        Address address = addressService.saveOrGetAddress(request.getAddress());
        User user = new User(request.getName(), request.getEmail(), request.getPhone(), request.getHousingType());
        user.setAddress(address);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, UserRequest request) {
        return userRepository.findById(id).map(user -> {
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
            user.setHousingType(request.getHousingType());
            Address address = addressService.saveOrGetAddress(request.getAddress());
            user.setAddress(address);
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
