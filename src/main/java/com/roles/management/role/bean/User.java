/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.bean;

/**
 *
 * @author BlackAngel
 */
public class User {
    
    private Long id;
    private Long nom;
    private Long prenom;
    private Long tele;
    private Long mail;
    private Long age;
    private Long jobTitle;

    public User() {
    }

    public User(Long id, Long nom, Long prenom, Long tele, Long mail, Long age, Long jobTitle) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
        this.mail = mail;
        this.age = age;
        this.jobTitle = jobTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNom() {
        return nom;
    }

    public void setNom(Long nom) {
        this.nom = nom;
    }

    public Long getPrenom() {
        return prenom;
    }

    public void setPrenom(Long prenom) {
        this.prenom = prenom;
    }

    public Long getTele() {
        return tele;
    }

    public void setTele(Long tele) {
        this.tele = tele;
    }

    public Long getMail() {
        return mail;
    }

    public void setMail(Long mail) {
        this.mail = mail;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(Long jobTitle) {
        this.jobTitle = jobTitle;
    }
    
}
