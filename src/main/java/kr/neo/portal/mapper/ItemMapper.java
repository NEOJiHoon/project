package kr.neo.portal.mapper;

import kr.neo.portal.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 스프링컨테이너의 스프링빈(bean)으로 등록됨, 데이터베이스에 조회/등록/수정/삭제(CRUD) 를 처리함
public interface ItemMapper {
    int insertItem(Item item);// DB 에 아이템 등록

    int deleteItem(int itemId);// DB 에 아이템을 삭제

    int updateItem(Item item);// DB 에 아이템을 수정

    List<Item> selectItems();// DB 에서 데이터를 조회
}
