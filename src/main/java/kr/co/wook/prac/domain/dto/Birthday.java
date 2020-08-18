package kr.co.wook.prac.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;


@Embeddable
//@AllArgsConstructor
@NoArgsConstructor
@Data
public class Birthday {
    private int yearOfBirthday;

    @Min(1)
    @Max(12)
    private int monthOfBirthday;

    @Min(1)
    @Max(31)
    private int dayOfBirthday;

    public Birthday(LocalDate birthday){
        this.dayOfBirthday = birthday.getDayOfMonth();
        this.monthOfBirthday = birthday.getMonthValue();
        this.yearOfBirthday = birthday.getYear();
    }
}
