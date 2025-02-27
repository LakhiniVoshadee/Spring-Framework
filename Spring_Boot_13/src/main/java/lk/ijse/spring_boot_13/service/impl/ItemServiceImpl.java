package lk.ijse.spring_boot_13.service.impl;

import lk.ijse.spring_boot_13.dto.ItemDTO;
import lk.ijse.spring_boot_13.entity.Item;
import lk.ijse.spring_boot_13.repo.ItemRepo;
import lk.ijse.spring_boot_13.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;

   @Override
    public List<ItemDTO> getAllItems() {
        return itemRepo.findAll().stream()
                .map(item -> new ItemDTO(item.getCode(), item.getName(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public void addItem(ItemDTO itemDTO) {
        /*Item item = new Item(
                itemDTO.getCode(),
                itemDTO.getName(),
                itemDTO.getQuantity(),
                itemDTO.getPrice()
        );*/
        if (itemRepo.existsById(itemDTO.getCode())){
            throw new RuntimeException("Item already exists");
        }
        itemRepo.save(modelMapper.map(itemDTO,Item.class));

    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getCode())) {
          /*  Item item = new Item(
                    itemDTO.getCode(),
                    itemDTO.getName(),
                    itemDTO.getQuantity(),
                    itemDTO.getPrice()
            );*/
            itemRepo.save(modelMapper.map(itemDTO,Item.class));

        }
        throw new RuntimeException("Item not found");
    }

    @Override
    public void deleteItem(int code) {
        if(itemRepo.existsById(code)){
            itemRepo.deleteById(code);

        }
        throw new RuntimeException("Item not found");
    }
}
