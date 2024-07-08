package com.assignment.domain.controller;

import com.assignment.domain.dto.ItemAddRequest;
import com.assignment.domain.dto.ItemAddResponse;
import com.assignment.domain.dto.ItemDetailsResponse;
import com.assignment.domain.entity.Item;
import com.assignment.domain.sevice.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/post")
    public ResponseEntity<ItemAddResponse> itemAdd(@RequestBody ItemAddRequest itemAddRequest) {
        ItemAddResponse itemAddResponse = itemService.addItem(itemAddRequest);
        return new ResponseEntity<>(itemAddResponse, HttpStatus.CREATED);
    }

    @GetMapping("/post")
    public ResponseEntity<List<ItemDetailsResponse>> itemDetails() {
        List<ItemDetailsResponse> itemDetailsResponseList = itemService.detailsItem();
        return new ResponseEntity<>(itemDetailsResponseList, HttpStatus.OK);
    }


}
