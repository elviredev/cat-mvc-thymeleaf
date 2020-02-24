package com.elv.catmvcthymeleaf.web;

import com.elv.catmvcthymeleaf.dao.ProduitRepository;
import com.elv.catmvcthymeleaf.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;

    @RequestMapping(value = "/index")
    public String index(Model model,
                        @RequestParam(name="page", defaultValue="0") int p,
                        @RequestParam(name="size", defaultValue="5") int s){
        Page<Produit> pageProduits = produitRepository.findAll(PageRequest.of(p, s));
        model.addAttribute("listProduits", pageProduits.getContent());
        int[] pages = new int[pageProduits.getTotalPages()];
        model.addAttribute("tabPages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourante", p);
        return "produits";
    }
}
