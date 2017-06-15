package com.gluteen.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by yusufaslan on 30.05.2017.
 */
@Entity
@EqualsAndHashCode(of = {"email"})
@ToString(of = {"id", "fullName"})
public class Person implements UserDetails,Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String password;

    private String phone;

    private String personImage;

    private String about;

    private String city;

    private String location;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Convert(converter = GenderConverter.class)
    @JoinColumn(name = "person_gender_id")
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @ManyToMany(fetch = FetchType.EAGER)
    @Getter @Setter @JsonIgnore
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public Person(){}

    public Person(Long id,String firstName, String lastName, String userName, String email, String password, String phone,String personImage,
                  String about, String city, String location, Date birthDate, Gender gender, Set<Role> roles) {
        this.id =id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.about = about;
        this.city = city;
        this.location = location;
        this.birthDate = birthDate;
        this.gender = gender;
        this.roles = roles;
        this.personImage=personImage;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toSet());
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @ToString(of = {"id", "firstName", "lastName"})
    public static class PersonBuilder {

        private Long id;
        private String firstName = "";
        private String lastName = "";
        private String userName = "";
        private String email = "";
        private String password = "";
        private String phone = "";
        private String location="";
        private String about= "";
        private String city="";
        private Date birthDate;
        private Gender gender = Gender.UNDEFINED;
        private Set<Role> roles = Collections.singleton(Role.USER);
        private String personImage="";

        PersonBuilder() {
        }

        public PersonBuilder id(@NonNull Long id) {
            this.id = id;
            return this;
        }

        public PersonBuilder firstName(@NonNull String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(@NonNull String lastName) {
            this.lastName = lastName;
            return this;
        }
        public PersonBuilder about(@NonNull String about) {
            this.about = about;
            return this;
        }
        public PersonBuilder city(@NonNull String city) {
            this.city = city;
            return this;
        }
        public PersonBuilder location(@NonNull String location) {
            this.location = location;
            return this;
        }
        public PersonBuilder userName(String shortName) {
            this.userName = userName;
            return this;
        }

        public PersonBuilder email(@NonNull String email) {
            this.email = email;
            return this;
        }

        public PersonBuilder password(@NonNull String password) {
            this.password = password;
            return this;
        }

        public PersonBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public PersonBuilder personImage(String personImage) {
            this.personImage = personImage;
            return this;
        }


        public PersonBuilder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public PersonBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public PersonBuilder roles(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public Person build() {
            return new Person(id, firstName, lastName, userName, email,password, phone,personImage, about ,city,location, birthDate, gender, roles);
        }
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPersonImage() {
        return personImage;
    }

    public void setPersonImage(String personImage) {
        this.personImage = personImage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }





}
