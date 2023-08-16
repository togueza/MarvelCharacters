package com.marvel.openpay.api.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

//import javax.persistence.Entity;
//import javax.persistence.Id;


@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class UserTable {

    @Id
    private String username;
    private String password;
    @NotNull
    private String name;
}
