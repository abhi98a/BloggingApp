package com.abhi.blog_app.comments;

import com.abhi.blog_app.common.BaseEntity;
import com.abhi.blog_app.users.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "comments")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentsEntity extends BaseEntity {

    @Column(nullable = false,length = 100)
    String title;

    @Column(columnDefinition = "TEXT")
    String body;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    UserEntity author;
}
