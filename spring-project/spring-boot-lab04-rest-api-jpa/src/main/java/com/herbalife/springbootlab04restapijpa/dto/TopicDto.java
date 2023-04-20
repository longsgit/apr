package com.herbalife.springbootlab04restapijpa.dto;

import lombok.Data;


public record TopicDto(String title, int duration) {
}

//@Data
//public class TopicDto {
//    private String title;
//    private int duration;
//}
