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

    @GetMapping(value = "/item/add/{id}/{name}/{price}")
    public void add(@PathVariable int id, @PathVariable String name, @PathVariable int price) {
        Item item = new Item();
        item.setItemId(id);
        item.setItemName(name);
        item.setItemPrice(price);
        itemService.saveItem(item);
    }
    @GetMapping(value = "/item/del/{id}")
    public void delete(@PathVariable int id){
        itemService.deleteItem(id);
    }
}
