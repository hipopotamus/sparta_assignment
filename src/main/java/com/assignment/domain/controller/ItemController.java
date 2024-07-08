package com.assignment.domain.controller;

import com.assignment.domain.dto.*;
import com.assignment.domain.entity.Item;
import com.assignment.domain.sevice.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/post/{id}")
    public ResponseEntity<ItemModifyResponse> itemModify(@RequestBody ItemModifyRequest itemModifyRequest,
                                                         @PathVariable Long id) {
        itemModifyRequest.setId(id);
        ItemModifyResponse itemModifyResponse = itemService.modifyItem(itemModifyRequest);

        return new ResponseEntity<>(itemModifyResponse, HttpStatus.OK);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<String> itemDelete(@PathVariable Long id) {
        itemService.deleteItem(id);

        return new ResponseEntity<>("삭제완료", HttpStatus.OK);
    }

}
