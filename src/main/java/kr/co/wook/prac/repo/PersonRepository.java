package kr.co.wook.prac.repo;

import kr.co.wook.prac.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
* Repository는 interface형식으로 만들어 JPAREPOSITORY 를 구현해준다.
* command + shift + t : test class 생성
* */

//JPA 확장하는 경우에는 아래 어노테이션을 작성하지 않아도 됨
public interface PersonRepository extends JpaRepository<Person, Long> {

}
