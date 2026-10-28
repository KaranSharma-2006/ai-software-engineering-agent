package com.karan.aisoftwareagent.controller;

import com.karan.aisoftwareagent.dto.AskResponse;
import com.karan.aisoftwareagent.dto.AskRequest;
import com.karan.aisoftwareagent.service.GeminiService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final GeminiService geminiService;

    public AiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }


    @PostMapping("/ask")
    public ResponseEntity<AskResponse> ask(
            @Valid @RequestBody AskRequest request) {

        String answer = geminiService.askGemini(request.prompt());

        return ResponseEntity.ok(
                new AskResponse(true, answer, null)
        );
    }

}