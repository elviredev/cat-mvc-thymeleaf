package com.elv.catmvcthymeleaf.web;

import com.elv.catmvcthymeleaf.dao.JeuRepository;
import com.elv.catmvcthymeleaf.entities.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class JeuController {
    @Autowired
    private JeuRepository jeuRepository;

    @RequestMapping(value = "/index")
    public String index(Model model,
                        @RequestParam(name="page", defaultValue="0") int p,
                        @RequestParam(name="size", defaultValue="5") int s,
                        @RequestParam(name="mc", defaultValue = "") String mc){
        //Page<Jeu> pageJeux = jeuRepository.findAll(PageRequest.of(p,s));
        Page<Jeu> pageJeux = jeuRepository.search("%"+mc+"%", PageRequest.of(p, s));
        model.addAttribute("listJeux", pageJeux.getContent());
        int[] pages = new int[pageJeux.getTotalPages()];
        model.addAttribute("tabPages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourante", p);
        model.addAttribute("mc", mc);
        return "jeux";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id, String mc, int page, int size){
        jeuRepository.deleteById(id);
        return "redirect:/index?page="+page+"&size="+size+"&mc="+mc;
    }
}
