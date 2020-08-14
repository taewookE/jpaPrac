package kr.co.wook.prac.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue
    private long id;


    private String name;


    private int age;

    private String hobby;
    private String address;
    //LocalDate 확인 해보기
    private LocalDate birthday;

//소스에서 command + n : class 관련 추가 항목 추가 가능

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
