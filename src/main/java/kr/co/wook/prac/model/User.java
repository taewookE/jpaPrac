package kr.co.wook.prac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    Integer userId;

    @Column
    String userName;
    String userPhone;

}
