package com.pucmg.adviser.services;

import com.pucmg.adviser.dtos.ItemDTO;
import com.pucmg.adviser.models.Transaction;

import java.util.List;

public interface ItemService {

    List<Transaction> batch(String clientId, List<ItemDTO> items);
}
