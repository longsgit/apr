package com.herbalife.springbootlab02jdbc.repository;

import com.herbalife.springbootlab02jdbc.model.Topic;
import com.herbalife.springbootlab02jdbc.model.TopicRecord;
import com.herbalife.springbootlab02jdbc.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.herbalife.springbootlab02jdbc.constants.Fields.*;
import static com.herbalife.springbootlab02jdbc.constants.Queries.*;

@Repository
public class TopicsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(TopicsDao.class);

    public int getCountOf(String title) {
        return jdbcTemplate.queryForObject(SELECT_TOPIC_COUNT, Integer.class, title);
    }

    public void create(String title, int duration) {
        jdbcTemplate.update(INSERT_TOPIC, title, duration);
    }

    public List<Topic> getAll() {
        return jdbcTemplate.query(SELECT_ALL_TOPICS, (rs, rowNum) ->
                new Topic(rs.getInt(TOPIC_ID), rs.getString(TOPIC_TITLE), rs.getInt(TOPIC_DURATION))
        );
    }

    public List<TopicRecord> getAllTopicRecords() {
        return jdbcTemplate.query(SELECT_ALL_TOPICS, (rs, rowNum) ->
                new TopicRecord(rs.getInt(TOPIC_ID), rs.getString(TOPIC_TITLE), rs.getInt(TOPIC_DURATION))
        );
    }

    public void delete(String title) {
        jdbcTemplate.update(DELETE_TOPIC, title);
    }
}
