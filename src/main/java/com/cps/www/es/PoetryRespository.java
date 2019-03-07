package com.cps.www.es;

import com.cps.www.entity.Poetry;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 基础操作的es repository接口（定义的有通用的增删改查方法）
 */

public interface PoetryRespository extends ElasticsearchRepository<Poetry, String> {// 泛型1：实体泛型 2：主键

}
