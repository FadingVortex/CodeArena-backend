package com.xyz.codearena.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Page {
    private Integer currentPage;
    private Integer pageSize;
    private String LMC;
}
