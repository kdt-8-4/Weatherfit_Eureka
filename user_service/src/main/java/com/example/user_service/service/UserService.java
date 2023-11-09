package com.example.user_service.service;

import com.example.user_service.dto.KafkaMessageDTO;
import com.example.user_service.dto.UserRequestDTO;
import com.example.user_service.dto.UserResponseDTO;
//import com.example.user_service.entity.User;
//import com.example.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

//    private final UserRepository userRepository;
//
//    public UserResponseDTO register(UserRequestDTO userRequestDTO) {
//        User user = User.builder()
//                .userId(userRequestDTO.getUserId())
//                .password(userRequestDTO.getPassword())
//                .build();
//
//        User result = userRepository.save(user);
//
//        return UserResponseDTO.builder()
//                .id(result.getId())
//                .userId(result.getUserId())
//                .password(result.getPassword())
//                .build();
//    }

    @KafkaListener(topics = "userId", groupId = "foo")
    public void consumeUserId(KafkaMessageDTO kafkaMessageDTO) {
        System.out.println("consume message : " + kafkaMessageDTO.toString());
    }
}
