package com.example.myfamilyback.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String memberName;

    private String memberPassword;
    @ManyToOne
    private Calendar myCalendar;

    @OneToMany(mappedBy = "noteMember")
    private List<Note> noteList;



}
