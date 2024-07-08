package com.assignment.domain.dto;

import com.assignment.domain.entity.Item;
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
