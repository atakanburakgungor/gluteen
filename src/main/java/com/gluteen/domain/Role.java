package com.gluteen.domain;

/**
 * Created by yusufaslan on 30.05.2017.
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by yusufaslan on 25.05.2017.
 */
@Entity
@NoArgsConstructor
@Table(name = "roles")
public class Role implements Serializable {

    public static final Role ADMIN =new Role(1L,"ROLE_ADMIN","admin");
    public static final Role USER =new Role(2L,"ROLE_USER","user");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String description;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Person> users;

    public Role(Long id, String name, String description) {
        this.name = name;
        this.description = description;
        this.id=id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Person> getUsers() {
        return users;
    }

    public void setUsers(Set<Person> users) {
        this.users = users;
    }
}