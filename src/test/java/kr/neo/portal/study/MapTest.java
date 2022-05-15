package kr.neo.portal.study;

import kr.neo.portal.model.Item;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    @Test
    public void test(){
        Map<String, Integer> map = new HashMap<>();
        map.put("jihoon", 70);
        map.put("jinam", 80);
        System.out.println(map);
        System.out.println(map.get("jihoon"));
        System.out.println(map.get("jinam"));

    }
    @Test
    //public은 접근제한자 void 반환타입 test2 메소드이름 (파라미터)
    public void test2(){
        Item item = new Item();
        item.setItemId(1);
        item.setItemName("코카콜라");
        item.setItemPrice(1200);

        Item item2 = new Item();
        item2.setItemId(2);
        item2.setItemName("식혜");
        item2.setItemPrice(900);

        Map<String, Item> map = new HashMap<>();
        map.put("A", item);
        map.put("B", item2);
        System.out.println(map);
        System.out.println(map.get("B").getItemName()); //(map.item2.getItemName());

        Item testItem = map.get("B");
        System.out.println(testItem.getItemName());
    }




}
