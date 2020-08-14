package kr.co.wook.prac.repo;

import kr.co.wook.prac.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    //자동화된 테스트가 아님
    @Test
    void curd(){
        Person person = new Person();

        person.setAge(10);
        person.setName("wook");
        personRepository.save(person);
        //ctrl+shift+r : test실행
//      System.out.println(personRepository.findAll()); //person hash code 값이 출력 , toString override 되어 있지 않아 문제 발생.

        List<Person> people = personRepository.findAll();

        //assertThat 과 관련된 내용은 손에 익을 수 있도록 진행
        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("wook");
        assertThat(people.get(0).getAge()).isEqualTo(10);
    }
}