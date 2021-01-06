package com.codespring.newscms.domain.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "news")
public class News {
    @Id
    String id;
    String title;
    String content;
    User author;
    Set<User> mandatoryReviewers;
    Set<Review> reviewers;
    Set<Category> categories;
    Set<Tag> tags;

    public Review review(String userId, String status) {
        final Review review = new Review(userId, status);
        this.reviewers.add(review);
        return review;
    }

    public Boolean revised() {
        return this.mandatoryReviewers.stream().allMatch(reviewer -> {
            return reviewers.stream().anyMatch(review -> {
                return reviewer.id.equals(review.userId) && "approved".equals(review.status);
            });
        });
    }
}
