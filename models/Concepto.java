/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportingapplication.models;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author vaira
 */
public class Concepto {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private boolean active;
    private Date createdAt;
    private Date modifiedAt;
    
    public Concepto(Integer id, 
            String name, 
            String description, 
            Double price,
            boolean active,
            Date createdAt, 
            Date modifiedAt) 
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
         this.active = active;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;

    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
