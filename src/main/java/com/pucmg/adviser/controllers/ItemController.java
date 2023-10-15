package com.pucmg.adviser.controllers;

import com.pucmg.adviser.dtos.ItemDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemController {

    ResponseEntity batch(String clientId, List<ItemDTO> items);
}
