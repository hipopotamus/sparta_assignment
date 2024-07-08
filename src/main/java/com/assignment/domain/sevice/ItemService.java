package com.assignment.domain.sevice;

import com.assignment.domain.dto.*;
import com.assignment.domain.entity.Item;
import com.assignment.domain.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public ItemAddResponse addItem(ItemAddRequest itemAddRequest) {
        Item item = itemAddRequest.toItem();
        Item savedItem = itemRepository.save(item);

        return ItemAddResponse.of(savedItem);
    }

    public List<ItemDetailsResponse> detailsItem() {
        return itemRepository.findAllByOrderByIdAsc().stream()
                .map(ItemDetailsResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public ItemModifyResponse modifyItem(ItemModifyRequest itemModifyRequest) {
        Item modifiyItem = itemModifyRequest.toItem();
        Item item = itemRepository.findById(modifiyItem.getId())
                .orElseThrow(() -> new NoSuchElementException("Item not found"));
        item.modify(modifiyItem);

        return ItemModifyResponse.of(modifiyItem);
    }


}
