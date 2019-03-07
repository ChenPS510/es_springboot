package com.cps.www.service;

import com.cps.www.entity.Poetry;

import java.util.List;

public interface PoetryService {
    List<Poetry> finfPetryByTitleOrContent(String keyWord);
}
