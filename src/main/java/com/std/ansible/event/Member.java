package com.std.ansible.event;

import com.std.ansible.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@Entity
@Getter
@ToString
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "team", nullable = false, length = 50)
    private String team;

    @Builder
    public Member(String name, String team) {
        this.name = name;
       this.team = team;
    }


}
