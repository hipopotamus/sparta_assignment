package com.assignment.domain.sevice;

import com.assignment.domain.dto.ItemAddRequest;
import com.assignment.domain.dto.ItemAddResponse;
import com.assignment.domain.entity.Item;
import com.assignment.domain.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public ItemAddResponse addItem(ItemAddRequest itemAddRequest) {
        Item item = itemAddRequest.toItem();
        Item savedItem = itemRepository.save(item);
        return ItemAddResponse.of(item);
    }
}
