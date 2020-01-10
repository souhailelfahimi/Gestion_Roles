/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BlackAngel
 */
@Entity
@Table(name = "document")
public class Document {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @ManyToOne
    //
    private Folder folder;

    @OneToMany(mappedBy = "document")
    private List<Attribute> attributes;

    public Document() {
    }

    public Document(String titre, List<Attribute> attributes) {
        this.titre = titre;
        this.attributes = attributes;
    }

    public Document(String titre, Folder folder, List<Attribute> attributes) {
        this.titre = titre;
        this.folder = folder;
        this.attributes = attributes;
    }

    public Document(String titre, Folder folder) {
        super();
        this.titre = titre;
        this.folder = folder;
    }

    @JsonIgnore
    public Folder getFolder() {
        return folder;
    }

    
    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Document{" + "id=" + id + ", titre=" + titre + ", folder=" + folder + ", attributes=" + attributes + '}';
    }

}
