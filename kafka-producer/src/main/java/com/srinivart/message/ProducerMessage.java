package com.srinivart.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Getter
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class ProducerMessage {
    //private Integer processAtMinutes;
    private String message;

    public ProducerMessage() {
    }

    public ProducerMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

