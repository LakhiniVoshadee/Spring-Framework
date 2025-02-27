package lk.ijse.spring_boot_13.controller;

import lk.ijse.spring_boot_13.dto.ItemDTO;
import lk.ijse.spring_boot_13.service.impl.ItemServiceImpl;
import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin(origins = "http://localhost:63342")
public class ItemController {
    @Autowired
    private ItemServiceImpl itemService;

    @PostMapping(path = "save")
    public ResponseUtil getItem(@RequestBody ItemDTO itemdto) {
         itemService.addItem(itemdto);

            return new ResponseUtil(201,"Item is saved!",null);


    }

    @GetMapping("/getall")
    public ResponseUtil getAllItems() {
        return new ResponseUtil(200,"All items have been saved!",itemService.getAllItems());
    }

    @PutMapping("/update")
    public ResponseUtil updateItem(@RequestBody ItemDTO itemdto) {
        itemService.updateItem(itemdto);

            return new ResponseUtil(200,"Item has been updated!",null);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseUtil deleteItem(@PathVariable int id) {
         itemService.deleteItem(id);
         return new ResponseUtil(200,"Item has been deleted!",null);
    }
}
