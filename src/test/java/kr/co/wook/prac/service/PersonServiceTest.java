package kr.co.wook.prac.service;

import kr.co.wook.prac.domain.Block;
import kr.co.wook.prac.domain.Person;
import kr.co.wook.prac.repo.BlockRepository;
import kr.co.wook.prac.repo.PersonRepository;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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