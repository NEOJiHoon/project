package kr.neo.portal.service;

import kr.neo.portal.mapper.ItemMapper;
import kr.neo.portal.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemMapper itemMapper;

    public int saveItem(Item item) {
        return itemMapper.insertItem(item);
    }
    public int deleteItem(int itemId) {
        return itemMapper.deleteItem(itemId);
    }

    public int updateItem(Item item) {
        return itemMapper.updateItem(item);
    }

    public List<Item> selectItems(){
        return itemMapper.selectItems();
    }
}
