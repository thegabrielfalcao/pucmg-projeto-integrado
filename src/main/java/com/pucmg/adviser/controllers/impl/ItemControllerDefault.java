package com.pucmg.adviser.controllers.impl;

import com.pucmg.adviser.controllers.ItemController;
import com.pucmg.adviser.dtos.ItemDTO;
import com.pucmg.adviser.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemControllerDefault implements ItemController {

    private final ItemService itemService;

    public ItemControllerDefault(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    @PostMapping("/batch")
    public ResponseEntity batch(@RequestHeader("Client-Id") String clientId, @RequestBody List<ItemDTO> items) {
        var transactions = itemService.batch(clientId, items);
        return ResponseEntity.ok(transactions);
    }
}
