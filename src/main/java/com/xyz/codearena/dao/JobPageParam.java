package com.xyz.codearena.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public class JobPageParam {
    private String username;
    private Integer id;
    private List<String> states;    //JSON中没有则为空数组
    private Integer pageSize;
    private Integer currentPage;
    private Integer offset;

}
