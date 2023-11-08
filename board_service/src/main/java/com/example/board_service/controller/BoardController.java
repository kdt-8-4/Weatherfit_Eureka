package com.example.board_service.controller;

import com.example.board_service.dto.BoardRequestDTO;
import com.example.board_service.dto.BoardResponseDTO;
import com.example.board_service.dto.KafkaMessageDTO;
import com.example.board_service.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final KafkaTemplate<String, KafkaMessageDTO> kafkaTemplate;

    @GetMapping("/test")
    public String test() {
        return "board-service test";
    }
//    @PostMapping("/writeboard")
//    public ResponseEntity<BoardResponseDTO> writeBoard(@RequestBody BoardRequestDTO boardRequestDTO) {
//        BoardResponseDTO boardResponseDTO = boardService.writeBoard(boardRequestDTO);
//        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDTO);
//    }
//
//    @PostMapping("/kafkaproducer")
//    public String kafkaProducer(@RequestBody BoardRequestDTO boardRequestDTO) {
//        KafkaMessageDTO kafkaMessageDTO = new KafkaMessageDTO(boardRequestDTO.getTitle());
//
//        ListenableFuture<SendResult<String, KafkaMessageDTO>> future = kafkaTemplate.send("userId", kafkaMessageDTO);
//        future.addCallback(new ListenableFutureCallback<SendResult<String, KafkaMessageDTO>>() {
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("failure");
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, KafkaMessageDTO> result) {
//                System.out.println("success");
//            }
//        });
//        return "done";
//    }
}
