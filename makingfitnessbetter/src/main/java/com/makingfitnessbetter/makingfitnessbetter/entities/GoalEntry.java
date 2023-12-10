package com.makingfitnessbetter.makingfitnessbetter.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class GoalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer goalEntryId;
    private Integer goalListId;
    private String checkTaskName;
    private Boolean isCompleted;
    private String actionCd;
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="goalList_goalListId")
    @JsonBackReference
    private GoalList goalList;




}
