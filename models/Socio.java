/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportingapplication.models;

import java.sql.Date;

/**
 *
 * @author vaira
 */
public class Socio {
    private Integer id;
    private Integer socioId;
    private String firstname;
    private String lastname;
    private String sede;
    private Integer idFamilia;
    private Integer esCabezaFamilia;
    private boolean active;
    private Date registratedAt;
    private Date createdAt;
    private Date modifiedAt;
    
    public Socio(Integer id, 
            Integer socioId,
            String firstname, 
            String lastname, 
            String sede,
            Integer idFamilia,
            Integer esCabezaFamilia,
            boolean active,
            Date registratedAt,
            Date createdAt, 
            Date modifiedAt) 
    {
        this.id = id;
        this.socioId = socioId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sede = sede;
        this.idFamilia = idFamilia;
        this.esCabezaFamilia = esCabezaFamilia;
        this.active = active;
        this.registratedAt = registratedAt;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSocioId() {
        return socioId;
    }

    public void setSocioId(Integer socioId) {
        this.socioId = socioId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getRegistratedAt() {
        return registratedAt;
    }

    public void setRegistratedAt(Date registratedAt) {
        this.registratedAt = registratedAt;
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

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Integer getEsCabezaFamilia() {
        return esCabezaFamilia;
    }

    public void setEsCabezaFamilia(Integer esCabezaFamilia) {
        this.esCabezaFamilia = esCabezaFamilia;
    }
    
    
}
