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
public class ItemDetailsResponse {

    long id;

    String username;

    String title;

    String content;

    int price;

    public static ItemDetailsResponse of(Item item) {
        return ItemDetailsResponse.builder()
                .id(item.getId())
                .username(item.getUsername())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .build();
    }
}
