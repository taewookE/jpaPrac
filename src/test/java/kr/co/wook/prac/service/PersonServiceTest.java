package kr.co.wook.prac.service;

import kr.co.wook.prac.domain.Block;
import kr.co.wook.prac.domain.Person;
import kr.co.wook.prac.repo.BlockRepository;
import kr.co.wook.prac.repo.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private PersonService personService;

    @Test
    void getPeopleExcludeBlocks(){
        givenPeople();
        givenBlocks();

        List<Person> list = personService.getPeopleExcludeBlocks();
//        System.out.println(list);

        list.forEach(System.out::println);
    }

    @Test
    void cascadeTest(){
        givenPeople();

        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);

        Person person = result.get(3);
        person.getBlock().setStartDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());



        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);

//        personRepository.delete(person);
//        personRepository.findAll().forEach(System.out::println);
//        blockRepository.findAll().forEach(System.out::println);

        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);

    }

    @Test
    void getPersonTest(){
        givenPeople();
        Person person = personService.getPerson(3L);
    }

    @Test
    void getPeopleByName(){
        givenPeople();

        List<Person> result = personService.getPeopleByName("wook");
        result.forEach(System.out::println);


    }

    @Test
    void findByBloodType(){
        givenPerson("wook",10,"A");
        givenPerson("david",10,"B");
        givenPerson("jane",10,"O");
        givenPerson("kiki",8,"AB");
        givenPerson("lolo",9,"A");

        List<Person> result = personRepository.findByBloodType("A");
       result.forEach(System.out::println);


    }
    private void givenBlocks() {
        givenBlock("David");
    }

    //save method는 기본적으로 저장한 entity 항목을 return 해준다.
    private Block givenBlock(String name) {
        return blockRepository.save(new Block(name));
    }


    private void givenPeople() {
        givenPerson("wook",10,"B");
        givenPerson("David",9,"A");
        givenPerson("Park",12,"O");
        givenBlockPerson("mark",11,"B");
        givenPerson("wook",12,"O");
    }

    private void givenBlockPerson(String name, int age, String bloodType) {
        Person blockPerson = new Person(name,age,bloodType);
        //blockPerson.setBlock(givenBlock(name));
        blockPerson.setBlock(new Block(name));
        personRepository.save(blockPerson);

    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name,age,bloodType));
    }


}