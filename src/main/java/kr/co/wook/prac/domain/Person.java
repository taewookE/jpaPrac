package kr.co.wook.prac.domain;

import lombok.*;

import javax.persistence.*;
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

    private LocalDate birthday;
    private String job;

    @ToString.Exclude
    private int phoneNumber;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Block block;


}


