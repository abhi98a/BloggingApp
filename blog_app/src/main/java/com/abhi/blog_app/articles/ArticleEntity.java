package com.abhi.blog_app.articles;

import com.abhi.blog_app.common.BaseEntity;
import com.abhi.blog_app.users.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "articles")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEntity extends BaseEntity {
    @Column(nullable = false, length = 100)
    String title;
    @Column(nullable = false , unique = true , length = 100)
    String slug;
    @Column(length = 150)
    String subtitle;

    @Column(columnDefinition = "TEXT")
    String body;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    UserEntity author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "likes",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    Set<UserEntity> likers;

}
