
package com.karan.aisoftwareagent.dto;

import jakarta.validation.constraints.NotBlank;

public record AskRequest(
        @NotBlank(message = "Prompt cannot be empty")
        String prompt
) {
}
