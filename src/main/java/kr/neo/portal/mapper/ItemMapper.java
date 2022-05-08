package kr.neo.portal.mapper;

import kr.neo.portal.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 스프링컨테이너의 빈(bean)으로 등록됨
public interface ItemMapper {
    int insertItem(Item item);

    int deleteItem(int itemId);

    int updateItem(Item item);

    List<Item> selectItems();
}
