package com.xyz.codearena.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Job {
    Integer runid;
    Integer id;
    String state;
    String language;
    Integer size;
    String time;
}
