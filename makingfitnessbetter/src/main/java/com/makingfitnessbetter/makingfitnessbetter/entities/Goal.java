package com.makingfitnessbetter.makingfitnessbetter.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer goalId;
    private String goalName;
    private String actionCd;


    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<GoalList> goalLists;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_memberId")
    @JsonBackReference
    private User user;


}
