package com.identity.auth.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class UserEntity extends BaseEntity{

    @Basic(optional = false)
    @Column(name = "userName", nullable = false, unique = true, updatable = false)
    @NotBlank(message = "Must have a userName value associated with this entity")
    @Size(max = 100, message = "Max length of a userName is 100 characters")
    private String userName;

    @Basic(optional = false)
    @Column(name = "password", nullable = false, unique = true, updatable = false)
    @NotBlank(message = "Must have a password value associated with this entity")
    @Size(max = 256, message = "Max length of a password is 256 characters")
    private String password;

    @Basic(optional = false)
    @Column(name = "firstName", nullable = false, unique = true, updatable = false)
    @NotBlank(message = "Must have a firstName value associated with this entity")
    @Size(max = 100, message = "Max length of a firstName is 100 characters")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "lastName", nullable = false, unique = true, updatable = false)
    @NotBlank(message = "Must have a lastName value associated with this entity")
    @Size(max = 100, message = "Max length of a lastName is 100 characters")
    private String lastName;

    @Basic(optional = false)
    @Column(name = "email", nullable = false, unique = true, updatable = false)
    @NotBlank(message = "Must have a email value associated with this entity")
    @Size(max = 100, message = "Max length of a email is 100 characters")
    @Email
    private String email;

    public UserEntity() {
        super();
    }
}
