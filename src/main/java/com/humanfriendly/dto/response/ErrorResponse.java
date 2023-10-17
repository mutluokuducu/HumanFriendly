package com.humanfriendly.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
    private String description;
}
