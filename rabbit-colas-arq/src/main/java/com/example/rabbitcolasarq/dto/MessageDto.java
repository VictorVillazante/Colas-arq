package com.example.rabbitcolasarq.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageDto {
    private String id;
    private String message;
    private Date date;
   
}
