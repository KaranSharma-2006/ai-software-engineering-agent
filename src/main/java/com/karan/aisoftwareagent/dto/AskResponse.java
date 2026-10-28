package com.karan.aisoftwareagent.dto;

public record AskResponse(
        boolean success,
        String answer,
        String error
) {
}