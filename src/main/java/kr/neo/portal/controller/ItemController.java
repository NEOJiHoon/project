package kr.neo.portal.controller;

import kr.neo.portal.model.Item;
import kr.neo.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // REST 웹 통신을 위한 컨트롤러
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping(value = "/item/add/{id}/{name}/{price}")
    public void add(@PathVariable int id, @PathVariable String name, @PathVariable int price) {
        Item item = new Item();
        item.setItemId(id);
        item.setItemName(name);
        item.setItemPrice(price);
        itemService.saveItem(item);
    }


    @GetMapping(value = "/item/update/{id}/{name}/{price}")
    public void update(@PathVariable int id, @PathVariable String name, @PathVariable int price) {
        Item item = new Item();
        item.setItemId(id);
        item.setItemName(name);
        item.setItemPrice(price);
        itemService.updateItem(item);
    }

    @GetMapping(value = "/items")
    public void selectItems(){
        List<Item> items = itemService.selectItems();
        for (Item item : items){
            System.out.println("ITEM: " + item );
        }
    }
}
