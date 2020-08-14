package kr.co.wook.prac.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString(exclude = "phoneNumber")
@NoArgsConstructor
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

    private String phoneNumber;

    //exclude 사용시 log에 찍히지 않게 된다.

}
