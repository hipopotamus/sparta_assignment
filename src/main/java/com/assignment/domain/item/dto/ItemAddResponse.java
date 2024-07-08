package com.assignment.domain.item.dto;

import com.assignment.domain.item.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemAddResponse {

    long id;

    String username;

    String title;

    String content;

    int price;

    public static ItemAddResponse of(Item item) {
        return ItemAddResponse.builder()
                .id(item.getId())
                .username(item.getUsername())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .build();
    }
}
