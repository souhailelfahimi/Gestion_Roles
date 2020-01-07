/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author BlackAngel
 */
@Entity
public class Attribute implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String keyD;
    private String value;

    @ManyToOne
    private Document document;

	public Attribute() {
		super();
	}

    public Attribute(String keyD, String value, Document document) {
        this.keyD = keyD;
        this.value = value;
        this.document = document;
    }

    public Attribute(String keyD, String value) {
        this.keyD = keyD;
        this.value = value;
    }

	

	



	public Attribute(long id, String keyD, String value, Document document) {
		super();
		this.id = id;
		this.keyD = keyD;
		this.value = value;
		this.document = document;
	}







	public Document getDocument() {
		return document;
	}







	public void setDocument(Document document) {
		this.document = document;
	}








	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	



	public String getKeyD() {
		return keyD;
	}







	public void setKeyD(String keyD) {
		this.keyD = keyD;
	}







	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


    
    
    
}
