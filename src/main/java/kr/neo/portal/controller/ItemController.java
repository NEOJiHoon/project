package kr.neo.portal.controller;

import kr.neo.portal.model.Item;
import kr.neo.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping(value = "/item/add/{id}")
    public void add(@PathVariable int id) {
        Item item = new Item();
        item.setItemId(id);
        item.setItemName("사탕");
        item.setItemPrice(1000);
        itemService.saveItem(item);
    }
}
