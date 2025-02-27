package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    // Appliying the loose coupling

    List<ItemDTO> getAllItems();
    void addItem(ItemDTO itemDTO);
    void updateItem(ItemDTO itemDTO);
    void deleteItem(int code);
}
