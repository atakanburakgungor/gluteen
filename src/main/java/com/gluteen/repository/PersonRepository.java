package com.gluteen.repository;

import com.gluteen.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yusufaslan on 31.05.2017.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findById(Long id);
    Person findByEmail(String email);
//    @Modifying
//    @Query("update Person m set m.about=:postBody,m.birthDate=:birthdate, m.city=:city,m.email=:email,m.firstName=:firtsname," +
//            "m.lastName=:lastName,m.password=:password,m.phone=:phone,m.userName=:userName where m.id =:id ")
//    Person updatePerson(@PathParam("id") Long id, @PathParam("postBody") String about, @PathParam("birthDate") Date birthDate,
//                        String personCity, String personEmail, @PathParam("city") String city, @PathParam("email") String email,
//                        @PathParam("firstName") String firstName);
//

//    @Query("SELECT p FROM Person p " +
//            "WHERE LOWER(p.fullName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
//            "ORDER BY p.fullName")
//    Page<Person> findPeople(
//            @Param("searchTerm") String searchTerm,
//            Pageable pageRequest);


   }
