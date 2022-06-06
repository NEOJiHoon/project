package kr.neo.portal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Item { // 데이터베이스 테이블명
    private int itemId;// 데이터베이스 필드명의 카멜케이스 DB: item_id
    private String itemName;// DB: item_name
    private int itemPrice;// DB: item_price


}
