package kr.neo.portal.controller;

import kr.neo.portal.model.Item;
import kr.neo.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller // 컨트롤러 웹페이지(html)을 리턴하는 기능을 함
public class HomeController {
    @Autowired // 스프링컨테이너에서 꺼내오기 위함 (ItemService 를 가져옴)
    ItemService itemService;

    @GetMapping(value = "/home") // 웹통신시 http GET 메소드와 매핑
    public String home(Model model, HttpServletRequest request) {// 모델은 뷰(html)로 데이터를 전달하는 방법으로 사용됨.
        String type = request.getParameter("type");
        System.out.println("type: " + type);
        if (type != null && type.equals("1")) {
            model.addAttribute("message", "수정할 대상이 없습니다.");
        } else if (type != null && type.equals("3")) {
            model.addAttribute("message", "ITEM ID를 숫자로 입력해주세요.");
        } else if (type != null && type.equals("4")) {
            model.addAttribute("message", "가격을 숫자로 입력해 주세요.");
        } else if (type != null && type.equals("5")) {
            model.addAttribute("message", "이름을 입력해 주세요.");
        }
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

    @PostMapping(value = "/item/update") // 웹통신시 http POST 메소드와 매핑
    public String update(HttpServletRequest request){
        String itemId = request.getParameter("itemId");
        String itemName = request.getParameter("itemName");
        String itemPrice = request.getParameter("itemPrice");
        if (itemName == null || itemName.trim().equals("")) {
            return "redirect:/home?type=5";
        }

        Item item = new Item();
        try {
            item.setItemId(Integer.parseInt(itemId));
        } catch(NumberFormatException e) {
            return "redirect:/home?type=3";
        }

        item.setItemName(itemName);
        try {
            item.setItemPrice(Integer.parseInt(itemPrice));
        } catch(NumberFormatException e) {
            return "redirect:/home?type=4";
        }

        int result = itemService.updateItem(item);  //
        int type = 0;
        if (result == 0) {
            System.out.println("수정할 대상이 없습니다.");
            type = 1;
        }
        return "redirect:/home?type=" + type;
    }
}
