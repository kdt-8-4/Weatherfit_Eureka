package com.example.board_service.service;

import com.example.board_service.dto.BoardRequestDTO;
import com.example.board_service.dto.BoardResponseDTO;
import com.example.board_service.dto.KafkaMessageDTO;
//import com.example.board_service.entity.Board;
//import com.example.board_service.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

//    private final BoardRepository boardRepository;
//
//    public BoardResponseDTO writeBoard(BoardRequestDTO boardRequestDTO) {
//        /*
//            kafka consumer 부분(userId)
//         */
//        Board board = Board.builder()
//                .title(boardRequestDTO.getTitle())
//                .content(boardRequestDTO.getContent())
//                .userId("papicc45")
//                .build();
//
//        Board result = boardRepository.save(board);
//
//        return BoardResponseDTO.builder()
//                .id(result.getId())
//                .userId(result.getUserId())
//                .title(result.getTitle())
//                .content(result.getContent())
//                .build();
//    }

}
