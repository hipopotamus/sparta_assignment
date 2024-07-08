package com.assignment.domain.item.dto;

import com.assignment.domain.item.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemModifyRequest {

    long id;

    String title;

    String content;

    int price;

    String username;

    public Item toItem() {
        return Item.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .price(this.price)
                .username(this.username)
                .build();
    }
}
