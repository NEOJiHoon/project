package kr.neo.portal.study;


import kr.neo.portal.model.Item;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListTest {
    @Test
    public void test(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(7);
        System.out.println(list);
        for(Integer obj : list) {
            System.out.println(obj * 2 );
        }
    }
    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("WORLD");
        System.out.println(list);
        System.out.println(list.get(1));
    }

    @Test
    public void test2(){
        Item item = new Item();
        item.setItemId(1);
        item.setItemName("홍두깨");
        item.setItemPrice(1200);

        Item item2 = new Item();
        item2.setItemId(2);
        item2.setItemName("곡갱이");
        item2.setItemPrice(4000);

        List<Item> list = new ArrayList<>();
        list.add(item);
        list.add(item2);
        System.out.println(list);

        for(Item it :list){   //(하나씩 빠져 나왔을 때의 타입과 객체이름 : 묶음집합)
            System.out.println(it);
        }
    }

}
