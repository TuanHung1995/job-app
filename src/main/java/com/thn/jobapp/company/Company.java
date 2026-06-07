package com.thn.jobapp.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thn.jobapp.job.Job;
import com.thn.jobapp.review.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "companies")
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;


    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

}
