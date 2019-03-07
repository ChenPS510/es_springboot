package com.cps.www.es;

import com.cps.www.entity.Poet;
import com.cps.www.entity.Poetry;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CustomPoetryResposityImpl implements CustomPoetryResposity {
    // 自定义Repository接口：使用 elasticsearchTemplate 实现复杂查询
    @Autowired
    private ElasticsearchTemplate template;

    @Override
    public List<Poetry> finfPetryByTitleOrContent(String keyWord) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.boolQuery().should(
                        QueryBuilders.matchQuery("title", keyWord)
                ).should(
                        QueryBuilders.matchQuery("content", keyWord)
                ))
                .withHighlightFields(new HighlightBuilder.Field("title"), new HighlightBuilder.Field("content"))
                .build();
        AggregatedPage<Poetry> result = template.queryForPage(searchQuery, Poetry.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                SearchHits searchHits = searchResponse.getHits();
                if (searchHits == null && searchHits.getHits().length == 0) {
                    return null;
                }
                ArrayList<Poetry> poetries = new ArrayList<>();
                for (SearchHit searchHit : searchHits) {
                    String id = searchHit.getId();
                    Map<String, Object> map = searchHit.getSourceAsMap();
                    Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
                    String title = null;
                    String content = null;
                    if (highlightFields.get("title") != null) {
                        title = highlightFields.get("title").getFragments()[0].toString();
                    } else {
                        title = map.get("title").toString();
                    }

                    if (highlightFields.get("content") != null) {
                        content = highlightFields.get("content").getFragments()[0].toString();
                    } else {
                        content = map.get("content").toString();
                    }

                    Map<String, Object> poetMap = (Map<String, Object>) map.get("poet");
                    String poetId = (String) poetMap.get("id");
                    String poetName = (String) poetMap.get("name");

                    Poetry poetry = new Poetry(id, content, title, new Poet(poetId, poetName));
                    poetries.add(poetry);
                }
                return new AggregatedPageImpl<T>((List<T>) poetries);
            }
        });

        return result.getContent();
    }
}
