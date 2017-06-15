package com.gluteen.service;

import com.gluteen.domain.Person;
import com.gluteen.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yusufaslan on 31.05.2017.
 */
@Service
public class PersonService {

    //BURASI İHTİYAÇLARA GÖRE DAHA SONRA YAZILACAK
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Person updatePerson(Person person){
        return personRepository.save(person);
    }

    @Transactional
    public Person findById(Long id)
    {
        return personRepository.findById(id);
    }
    @Transactional
    public Person findByEmail(String email)
    {
        return personRepository.findByEmail(email);
    }
    @Transactional
    public void update(Person person) {
        personRepository.save(person);
    }
    @Transactional
    public Person create(String firstName, String lastName, String email, String password) {
        final Person person = Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();

        return personRepository.save(person);
    }
    @Transactional
    public boolean hasValidPassword(Person person, String pwd) {
        return passwordEncoder.matches(pwd, person.getPassword());
    }
    @Transactional
    public void changePassword(Person person, String pwd) {
        person.setPassword(passwordEncoder.encode(pwd));
        personRepository.save(person);
    }
//    public void changePassword(Person person, String pwd) {
//        person.setPassword(passwordEncoder.encode(pwd));
//        personRepository.save(person);
//    }
    @Transactional
    public Person save(Person person, MultipartFile imgPerfil) {

        person.setPersonImage("/imgs/perfil/" + imgPerfil.getOriginalFilename());

        return personRepository.save(person);
    }
    @Transactional
    public Person save(Person person)
    {
        return personRepository.save(person);
    }

//    @Transactional(readOnly = true)
//    public Page<Person> getPeople(String searchTerm, Pageable pageRequest) {
//        return personRepository.findPeople(searchTerm, pageRequest);
//    }
}
