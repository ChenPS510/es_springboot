package com.cps.www.controller;

import com.cps.www.entity.Poetry;
import com.cps.www.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/poetry")
public class PoetryController {
    @Autowired
    private PoetryService poetryService;

    @RequestMapping("/search")
    public ModelAndView search(String keyWord, ModelAndView modelAndView) {
        List<Poetry> list = poetryService.finfPetryByTitleOrContent(keyWord);

        modelAndView.setViewName("poetries");
        modelAndView.addObject("poetries", list);

        return modelAndView;
    }
}
