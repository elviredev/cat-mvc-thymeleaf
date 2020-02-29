package com.elv.catmvcthymeleaf.dao;

import com.elv.catmvcthymeleaf.entities.Jeu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JeuRepository extends JpaRepository<Jeu, Integer> {
    @Query("select j from Jeu j where j.nom like:x")
    Page<Jeu> search(@Param("x") String mc, Pageable pageable);
}
