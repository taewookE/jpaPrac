package kr.co.wook.prac.domain;

import kr.co.wook.prac.domain.dto.Birthday;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import javax.validation.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;

    @NonNull
    private String bloodType;


    @Valid
    @Embedded
    private Birthday birthday;

    private String job;

    @ToString.Exclude
    private int phoneNumber;

    //@OneToOne(cascade = {CascadeType.PERSIST ,CascadeType.MERGE, CascadeType.REMOVE})
    //FetchType은 EAGER가 default 임 => entity호출 시, 두개의 테이블을 한번에 join하여서 가지고 오게 되어있음.
    //LAZY option의 경우 Person객체를 select 할때 함꼐 outer join을 통해서 가지고 오는것이 아니고, 필요시점에 Blcok을 다시 호출하게 됨.
    //현재 소스를 수정했는데 jpaQuery에서 분리가 되어서 호출하지 않고 있음....

    //LAZY option에 tostring exclude시켜버리면, blcok의 쿼리가 수행 X , 불필요 쿼리 수행을 막을 수 있음.
    //optional false로 변경하면 inner Join으로 query가 변경됨.
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) //, fetch = FetchType.EAGER, optional = false)
    @ToString.Exclude
    private Block block;


}


