package com.makingfitnessbetter.makingfitnessbetter.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "USERTABLE")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer memberId;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;

    @OneToMany
    List<EntryLog> entryLogList;


}
