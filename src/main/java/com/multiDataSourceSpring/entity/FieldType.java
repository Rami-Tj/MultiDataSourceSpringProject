package com.multiDataSourceSpring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TYPE_CHAMPS")
public class FieldType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYPE_CHAMP_ID")
    private int id;

    @Column(name = "LIBELLE")
    private String name;
}
