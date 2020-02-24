package com.elv.catmvcthymeleaf.dao;

import com.elv.catmvcthymeleaf.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}
