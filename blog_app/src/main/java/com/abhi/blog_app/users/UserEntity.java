package com.abhi.blog_app.users;

import com.abhi.blog_app.articles.ArticleEntity;
import com.abhi.blog_app.common.BaseEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    String username;
    @Column(nullable = false) @Setter
    String password;
    @Column(nullable = false,unique = true)
    String email;
    @Nullable @Setter
    String bio;
    @Nullable @Setter
    String image;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<ArticleEntity> likedArticles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "followers",
            joinColumns = @JoinColumn(name = "following_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    Set<UserEntity> followers;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "followers")
    Set<UserEntity> following;
}

