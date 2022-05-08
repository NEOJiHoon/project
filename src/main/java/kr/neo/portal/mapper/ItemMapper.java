package kr.neo.portal.mapper;

import kr.neo.portal.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    int insertItem(Item item);

    int deleteItem(int itemId);

    int updateItem(Item item);

    List<Item> selectItems();
}
