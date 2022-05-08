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

@Controller
public class HomeController {
    @Autowired
    ItemService itemService;

    @GetMapping(value = "/home")
    public String home(Model model) {
        List<Item> items = itemService.selectItems();
        model.addAttribute("test", "테스트입니다.");
        model.addAttribute("items", items);
        return "home";
    }

    @PostMapping(value = "/item/del/{id}")
    public String delete(@PathVariable int id){
        itemService.deleteItem(id);
        return "redirect:/home";
    }
}
