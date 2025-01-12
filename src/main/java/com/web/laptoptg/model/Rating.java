package com.web.laptoptg.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "rating_score")
    private int ratingScore;
}
