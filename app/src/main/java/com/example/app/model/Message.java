package com.example.app.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Message {
    private String status;
    private String message;
}
