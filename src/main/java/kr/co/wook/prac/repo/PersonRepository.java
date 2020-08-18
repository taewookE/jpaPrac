package kr.co.wook.prac.repo;

import kr.co.wook.prac.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
* Repository는 interface형식으로 만들어 JPAREPOSITORY 를 구현해준다.
* command + shift + t : test class 생성
* */

//JPA 확장하는 경우에는 아래 어노테이션을 작성하지 않아도 됨
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);
    List<Person> findByBlockIsNull();
    List<Person> findByBloodType(String BloodType);

//    @Query(value = "select person from Person person where person.birthday.monthOfBirthday= ?1 and person.birthday.dayOfBirthday =?2")
//    List<Person> findByMonthOfBirthday(int monthOfBirthday,int dayOfBirthday);

    //JPQL version
    @Query(value = "select person from Person person where person.birthday.monthOfBirthday= :monthOfBirthday")
    List<Person> findByMonthOfBirthday(@Param("monthOfBirthday") int monthOfBirthday);

    //native query
//    @Query(value = "select * from person where month_Of_Birthday= :monthOfBirthday and day_Of_Birthday =:dayOfBirthday",nativeQuery= true)
//    List<Person> findByMonthOfBirthday(@Param("monthOfBirthday") int monthOfBirthday, @Param("dayOfBirthday") int dayOfBirthday);

}
