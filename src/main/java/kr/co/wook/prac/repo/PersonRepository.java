package kr.co.wook.prac.repo;

import kr.co.wook.prac.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* Repository는 interface형식으로 만들어 JPAREPOSITORY 를 구현해준다.
* command + shift + t : test class 생성
* */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
