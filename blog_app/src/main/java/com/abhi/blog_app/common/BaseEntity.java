package com.abhi.blog_app.common;

import jakarta.persistence.*;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.annotation.processing.Generated;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private long id;

    @Setter @UpdateTimestamp
    Date CreatedAt;

    @Setter @UpdateTimestamp
    Date UpdatedAt;

}
