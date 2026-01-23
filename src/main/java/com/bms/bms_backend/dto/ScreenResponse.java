package com.bms.bms_backend.dto;

import com.bms.bms_backend.model.Theatre;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScreenResponse {
    private  Long id;
    private String name;
    private long theatreId;
    private String theatreName;
}
