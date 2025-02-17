package com.assignment.domain.item.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    String title;

    String content;

    int price;

    String username;

    public void modify(Item modifiedItem) {
        Optional.ofNullable(modifiedItem.getTitle()).ifPresent(title -> this.title = title);
        Optional.ofNullable(modifiedItem.getContent()).ifPresent(content -> this.content = content);
        Optional.of(modifiedItem.getPrice()).ifPresent(price -> this.price = price);
        Optional.ofNullable(modifiedItem.getUsername()).ifPresent(username -> this.username = username);
    }
}
