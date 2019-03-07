package com.cps.www.es;

import com.cps.www.entity.Poetry;

import java.util.List;

public interface CustomPoetryResposity {
    /**
     * 通过关键字匹配内容或标题或作者 关键字高亮
     */
    List<Poetry> finfPetryByTitleOrContent(String keyWord);
}
