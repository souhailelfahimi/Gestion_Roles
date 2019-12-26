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
public class Permission {
    private int id;
    private boolean create;
    private boolean delete;
    private boolean update;
    private boolean list;

    public Permission() {
    }

    public Permission(int id, boolean create, boolean delete, boolean update, boolean list) {
        this.id = id;
        this.create = create;
        this.delete = delete;
        this.update = update;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }
    
}
