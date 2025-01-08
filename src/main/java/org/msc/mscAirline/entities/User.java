package org.msc.mscAirline.entities;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String login;
    private String password;
    private String picture;

    public enum Rol {
        ROLE_ADMIN, ROLE_USER
    }

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public User(String name, String login, String password, String picture, Rol rol) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.picture = (picture == null || picture.isEmpty()) ? "default image":picture;
        this.rol = rol;
    }

    public User() {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
