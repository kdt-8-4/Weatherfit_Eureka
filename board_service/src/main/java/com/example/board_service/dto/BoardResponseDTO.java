package com.example.board_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardResponseDTO {
    private long id;

    private String title;

    private String content;

    private String userId;
}
