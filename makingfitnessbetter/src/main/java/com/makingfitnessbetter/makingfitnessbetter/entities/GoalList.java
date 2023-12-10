package com.makingfitnessbetter.makingfitnessbetter.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class GoalList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer goalListId;
    private String goalName;
    private Boolean isGoalCompleted;
    private String actionCd;
    private Date dateCreated;

    @OneToMany(mappedBy = "goalList", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<GoalEntry> goalEntryList;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_memberId")
    @JsonBackReference
    private User user;

}
