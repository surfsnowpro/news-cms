package com.codespring.newscms.domain.vo;

import com.codespring.newscms.domain.models.Category;
import com.codespring.newscms.domain.models.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class NewsRequest {
    String title;
    String content;
    Set<Category> categories;
    Set<Tag> tags;

    public NewsRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }
}
