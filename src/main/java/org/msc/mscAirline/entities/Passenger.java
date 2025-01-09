package org.msc.mscAirline.entities;

import jakarta.persistence.*;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String picture;

    public enum Rol {
        ROLE_ADMIN, ROLE_USER
    }

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Passenger(String name, String email, String password, String picture, Rol rol) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.picture = (picture == null || picture.isEmpty()) ? "default image":picture;
        this.rol = rol;
    }

    public Passenger() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
