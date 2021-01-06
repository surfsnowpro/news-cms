package com.codespring.newscms.domain.service;

import com.codespring.newscms.domain.exceptions.UserNotFoundException;
import com.codespring.newscms.domain.models.User;
import com.codespring.newscms.domain.repositories.UserRepository;
import com.codespring.newscms.domain.vo.UserRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Transactional
//    public User update(String id, UserRequest userRequest){
//        final Optional<User> userOptional = this.userRepository.findById(id);
//        if (userOptional.isPresent()) {
//            final User user = userOptional.get();
//            user.setIdentity(userRequest.getIdentity());
//            user.setName(userRequest.getName());
//            user.setRole(userRequest.getRole());
//            return userRepository.save(user);
//        } else {
//            throw new UserNotFoundException(id);
//        }
//    }

//    @Transactional
//    public User create(UserRequest userRequest){
//        User user = new User();
//        user.setIdentity(userRequest.getIdentity());
//        user.setName(userRequest.getName());
//        user.setRole(userRequest.getRole());
//        return this.userRepository.save(user);
//    }
//
//    @Transactional
//    public void delete(String id){
//        final Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()) {
//            this.userRepository.delete(user.get());
//        } else {
//            throw new UserNotFoundException(id);
//        }
//    }
//
//    public User findById(String id) {
//        final Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()) {
//            return user.get();
//        } else {
//            throw new UserNotFoundException(id);
//        }
//    }
//
//    public List<User> findAll(){
//        return userRepository.findAll();
//    }
}
