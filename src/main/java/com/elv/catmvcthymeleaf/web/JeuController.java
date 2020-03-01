package com.elv.catmvcthymeleaf.web;

import com.elv.catmvcthymeleaf.dao.JeuRepository;
import com.elv.catmvcthymeleaf.entities.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


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

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String formJeu(Model model){
        model.addAttribute("jeu", new Jeu());
        return "formJeu";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @Valid Jeu jeu, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "formJeu";
        jeuRepository.save(jeu);
        return "confirmation";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model, int id){
        Jeu jeu = jeuRepository.getOne(id);
        model.addAttribute("jeu", jeu);
        return "editJeu";
    }
}
