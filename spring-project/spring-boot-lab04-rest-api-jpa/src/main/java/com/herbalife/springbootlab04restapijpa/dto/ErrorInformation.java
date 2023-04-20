package com.herbalife.springbootlab04restapijpa.dto;

import lombok.Data;

@Data
public class ErrorInformation {
    private String error;
    private String timestamp;
    private String path;
}
