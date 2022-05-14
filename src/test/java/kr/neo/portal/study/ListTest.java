package kr.neo.portal.study;


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
}
