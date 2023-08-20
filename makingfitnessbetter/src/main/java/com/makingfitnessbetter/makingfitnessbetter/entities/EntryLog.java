package com.makingfitnessbetter.makingfitnessbetter.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class EntryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer entryId;
    private String entryName;
    private String overallComments;

    @OneToMany
    private List<ExerciseLog> exerciseLogList;

}
