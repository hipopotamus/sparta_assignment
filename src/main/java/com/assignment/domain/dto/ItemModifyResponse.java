package com.assignment.domain.dto;

import com.assignment.domain.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemModifyResponse {

    long id;

    String title;

    String content;

    int price;

    String username;

    public static ItemModifyResponse of(Item item) {
        return ItemModifyResponse.builder()
                .id(item.getId())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .username(item.getUsername())
                .build();
    }
}
