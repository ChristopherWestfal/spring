package org.example.spring.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    String name;
    String message;
    String id;
}
