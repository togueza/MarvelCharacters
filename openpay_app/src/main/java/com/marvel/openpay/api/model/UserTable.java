package com.marvel.openpay.api.model;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class UserTable {

    @Id
    private String username;
    private String password;
    private String name;
}
