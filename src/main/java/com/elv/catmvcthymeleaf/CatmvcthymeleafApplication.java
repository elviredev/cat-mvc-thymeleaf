package com.elv.catmvcthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatmvcthymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatmvcthymeleafApplication.class, args);
		/*ApplicationContext ctx=SpringApplication.run(CatmvcthymeleafApplication.class, args);
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("World of Warcraft", 49.99, 120));
		produitRepository.save(new Produit("The Witcher", 39.00, 180));
		produitRepository.save(new Produit("Final Fantasy", 69.50, 65));
		produitRepository.save(new Produit("The Elder Scroll Online", 35.00, 40));

		produitRepository.findAll().forEach(p -> {
			System.out.println(p.getDesignation());
		});*/
	}

}
