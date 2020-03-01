package com.elv.catmvcthymeleaf.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "jeux_video")
public class Jeu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 4, max = 50)
    private String nom;
    @NotNull
    private String possesseur;
    @NotNull
    private String console;
    @DecimalMin("1")
    private int prix;
    @DecimalMin("1")
    private int nb_joueurs_max;
    private String commentaires;

    // constructeurs
    public Jeu() {
        super();
    }

    public Jeu(String nom, String possesseur, String console, int prix, int nb_joueurs_max, String commentaires) {
        super();
        this.nom = nom;
        this.possesseur = possesseur;
        this.console = console;
        this.prix = prix;
        this.nb_joueurs_max = nb_joueurs_max;
        this.commentaires = commentaires;
    }

    // getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPossesseur() {
        return possesseur;
    }

    public void setPossesseur(String possesseur) {
        this.possesseur = possesseur;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNb_joueurs_max() {
        return nb_joueurs_max;
    }

    public void setNb_joueurs_max(int nb_joueurs_max) {
        this.nb_joueurs_max = nb_joueurs_max;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }
}
