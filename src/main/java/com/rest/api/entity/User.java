package com.rest.api.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user1")

@Builder // builder를 사용할 수 있게 한다.
@Getter
@Setter
@NoArgsConstructor // 인자없는 생성자 자동 생성
@AllArgsConstructor // 인자 모두 있는 생성자 자동 생성
public class User {

    /*
    !!!JPA 기본키 전략에 대해서는 좀 더 공부해보자!!!
     */
    @Id //primaryKey라는 뜻
    @GeneratedValue(strategy= GenerationType.IDENTITY) //pk생성전략을 DB에 위임. 예를들어 auto_increment
    private long msrl;
    @Column(nullable=false, unique=true, length=30)
    private String uid;
    @Column(nullable=false, length=100)
    private String name;

}
