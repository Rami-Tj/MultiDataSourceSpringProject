package com.multiDataSourceSpring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "FORMULAIRES")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORMULAIRE_ID")
    private int id;

    @Column(name = "LEBELLE")
    private String name;

    @Column(name = "NOMBRE_COLONNES")
    private int columnNumber;

    @OneToMany
    @JoinColumn(name = "FORMULAIRE_ID")
    private List<FormField> fields;
}
