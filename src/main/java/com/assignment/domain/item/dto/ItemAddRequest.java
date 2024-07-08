package com.assignment.domain.item.dto;

import com.assignment.domain.item.entity.Item;
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
