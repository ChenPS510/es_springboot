package com.cps.www.service.impl;


import com.cps.www.entity.Poetry;
import com.cps.www.es.CustomPoetryResposity;
import com.cps.www.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoetryServiceImpl implements PoetryService {
    @Autowired
    private CustomPoetryResposity customPoetryResposity;


    @Override
    public List<Poetry> finfPetryByTitleOrContent(String keyWord) {
        List<Poetry> list = customPoetryResposity.finfPetryByTitleOrContent(keyWord);
        return list;
    }
}
