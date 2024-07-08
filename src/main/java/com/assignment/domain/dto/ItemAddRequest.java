package com.assignment.domain.dto;

import com.assignment.domain.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemAddRequest {

    String username;

    String title;

    String content;

    int price;

    public Item toItem() {
        return Item.builder()
                .username(this.username)
                .title(this.title)
                .content(this.content)
                .price(this.price)
                .build();
    }
}
