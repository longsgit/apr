package com.herbalife.springbootlab02jdbc.constants;

public interface Queries {

    String SELECT_TOPIC_COUNT = "select count(*) from topics where title = ?";
    String INSERT_TOPIC = "insert into topics(title, duration) values(?, ?)";

    String SELECT_ALL_TOPICS = "select * from topics";
    String DELETE_TOPIC = "delete from topics where title = ?";
}
