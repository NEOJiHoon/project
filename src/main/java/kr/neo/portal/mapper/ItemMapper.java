package kr.neo.portal.mapper;

import kr.neo.portal.model.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {
    int insertItem(Item item);
}
