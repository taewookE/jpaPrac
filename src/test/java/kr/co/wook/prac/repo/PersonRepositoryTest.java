package kr.co.wook.prac.repo;

import kr.co.wook.prac.domain.Person;
import kr.co.wook.prac.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


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

    @Test
    void findByBirthdayBetween(){
        givenPerson("wook",10,"A",LocalDate.of(1991,8,30));
        givenPerson("david",10,"B",LocalDate.of(1991,8,7));
        givenPerson("jane",10,"O",LocalDate.of(1991,8,21));
        givenPerson("kiki",8,"AB",LocalDate.of(2002,3,8));
        givenPerson("lolo",9,"A",LocalDate.of(1988,11,5));

//        List<Person> result = personRepository.findByBirthdayBetween(LocalDate.of(1991,8,1), LocalDate.of(1991,8,31));
        List<Person> result = personRepository.findByMonthOfBirthday(8);

        result.forEach(System.out::println);

    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthday ) {
        Person person = new Person(name,age,bloodType);
        person.setBirthday(new Birthday(birthday) );
        personRepository.save(person);
    }




}