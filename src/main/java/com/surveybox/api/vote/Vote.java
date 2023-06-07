package com.surveybox.api.vote;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Integer id;
    @Column(name = "title",columnDefinition = "json")
   private String title;
    @Column(length = 15)
   private String choose;
  private  Boolean status;
}
