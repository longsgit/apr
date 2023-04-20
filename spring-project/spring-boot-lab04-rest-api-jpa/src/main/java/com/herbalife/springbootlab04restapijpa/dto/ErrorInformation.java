package com.herbalife.springbootlab04restapijpa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public record ErrorInformation(String error, String timestamp, String path) {

}

//@Data
//public class ErrorInformation {
//    private String error;
//    private String timestamp;
//    private String path;
//}
