package kr.co.wook.prac.repo;

import kr.co.wook.prac.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.MAP;


@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;
    @Test
    void crud(){
        Person person = new Person();

        person.setAge(10);
        person.setName("wook");

        personRepository.save(person);

        List<Person> people = personRepository.findAll();

        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getAge()).isEqualTo(10);
        assertThat(people.get(0).getName()).isEqualTo("wook");

    }
    @Test
    void ContructorTest(){
       Person person1 = new Person("wook",10,"B");
       Person person2 = new Person("soo", 12,"O");

    }

    @Test
    void hashCodeAndEqueals(){
        Person person1 = new Person("wook",10,"A");
        Person person2 = new Person("wook",10,"A");

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        Map<Person,Integer> map= new HashMap<>();
        map.put(person1,person1.getAge());

        System.out.println(map);
        System.out.println(map.get(person2));


    }
}