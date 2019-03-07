package com.cps.www.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "tangshi", type = "shi")
public class Poetry {
    @Id
    private String id;
    @Field(searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String content;
    @Field(searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String title;
    private Poet poet;

    @Override
    public String toString() {
        return "Poetry{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", poet=" + poet +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Poet getPoet() {
        return poet;
    }

    public void setPoet(Poet poet) {
        this.poet = poet;
    }

    public Poetry(String id, String content, String title, Poet poet) {

        this.id = id;
        this.content = content;
        this.title = title;
        this.poet = poet;
    }

    public Poetry() {

    }
}
