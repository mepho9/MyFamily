package com.example.myfamilyback.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String calendarName;

    private LocalDateTime creationDate;

    private String calendarPassword;

    @OneToMany(mappedBy = "myCalendar")
    private List<Member> memberList;

}
