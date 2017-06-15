package com.gluteen.web;

import com.gluteen.configuration.Constants;
import com.gluteen.domain.Person;
import com.gluteen.model.PersonView;
import com.gluteen.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yusufaslan on 3.06.2017.
 */
@RestController
@RequestMapping(value = Constants.URI_API_PREFIX)
public class PersonController {

        private static final Logger log = LoggerFactory.getLogger(PersonController.class);

        private final PersonService personService;

        @Autowired
        public PersonController(PersonService personService) {
            this.personService = personService;
        }

        @GetMapping("/person/{id}")
        public ResponseEntity<PersonView> getPerson(
                @PathVariable("id") Long id) {
            log.debug("REST request to get person id:{}", id);

            final Person person = personService.findById(id);
            if (null == person) {
                log.debug("Person id:{} is not signed up", id);

                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(new PersonView(person));
        }

//        @GetMapping("/people")
//        public Page<PersonView> getPeople(
//                @RequestParam(name = "searchTerm", defaultValue = "", required = false) String searchTerm,
//                @PageableDefault(size = 20) Pageable pageRequest) {
//            log.debug("REST request to get people list (searchTerm:{}, pageRequest:{})", searchTerm, pageRequest);
//
//            final Page<Person> people = personService.getPeople(searchTerm, pageRequest);
//
//            return people.map(PersonView::new);
//        }




}