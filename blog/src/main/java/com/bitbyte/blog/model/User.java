package com.bitbyte.blog.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    public enum permission { OWNER, ADMIN, MOD, USER }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 3, max = 45)
    @Column(name = "username")
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @Email
    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NotNull
    @Column(name = "level")
    private Integer level;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "permission", length = 8)
    private permission permission;

    @NotNull
    @Column(name = "")
    private boolean banned;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public User.permission getPermission() {
        return permission;
    }

    public void setPermission(User.permission permission) {
        this.permission = permission;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("username", username)
                .append("fullName", fullName)
                .append("email", email)
                .append("dateOfBirth", dateOfBirth)
                .append("level", level)
                .append("description", description)
                .append("dateOfCreation", dateOfCreation)
                .append("permission", permission)
                .append("banned", banned)
                .toString();
    }
}
