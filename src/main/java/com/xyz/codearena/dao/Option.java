package com.xyz.codearena.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public class Option {
    private String label;
    private String value;
    private List<Option> children;
}
