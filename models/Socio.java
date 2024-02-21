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
    private Integer familyId;
    private boolean active;
    private Date registratedAt;
    private Date createdAt;
    private Date modifiedAt;
    
    public Socio(Integer id, 
            Integer socioId,
            String firstname, 
            String lastname, 
            String sede,
            Integer familyId,
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
        this.familyId = familyId;
        this.active = active;
        this.registratedAt = registratedAt;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;

    }
}
