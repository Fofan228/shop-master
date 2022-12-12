package com.example.shoppinglist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean isBought;

    public Product(String name) {
        this.id = id;
        this.name = name;
        this.isBought = isBought;
    }
    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
        this.isBought = isBought;
    }
    public Product(Long id, String name, boolean bought) {
        this.id = id;
        this.name = name;
        this.isBought = bought;
    }

    public Product() {

    }
    public void Update(boolean isBought) {
        this.isBought = isBought;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }
}
