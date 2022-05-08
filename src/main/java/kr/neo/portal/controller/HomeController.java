package kr.neo.portal.controller;

import kr.neo.portal.model.Item;
import kr.neo.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 컨트롤러 웹페이지(html)을 리턴하는 기능을 함
public class HomeController {
    @Autowired // 스프링컨테이너에서 꺼내오기 위함 (ItemService 를 가져옴)
    ItemService itemService;

    @GetMapping(value = "/home") // 웹통신시 http GET 메소드와 매핑
    public String home(Model model) {// 모델은 뷰(html)로 데이터를 전달하는 방법으로 사용됨.
        List<Item> items = itemService.selectItems();
        model.addAttribute("test", "테스트입니다.");
        model.addAttribute("items", items); // 모델에 items(리스트)를 전달
        return "home";
    }

    @PostMapping(value = "/item/del/{id}") // 웹통신시 http POST 메소드와 매핑
    public String delete(@PathVariable int id){
        itemService.deleteItem(id);
        return "redirect:/home";
    }
}
