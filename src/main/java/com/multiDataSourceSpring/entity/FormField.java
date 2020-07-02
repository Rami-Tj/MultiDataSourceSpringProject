package com.multiDataSourceSpring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "FORMULAIRE_CHAMPS")
public class FormField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORMULAIRE_CHAMP_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "TYPE_CHAMP_ID")
    private FieldType fieldType;

    @ManyToOne
    @JoinColumn(name = "TYPE_DONNEE_ID")
    private DataType dataType;

    @ManyToOne
    @JoinColumn(name = "LISTE_VALEUR_ID")
    private SelectValues selectValues;

    @Column(name = "LIBELLE")
    private String name;

    @Column(name = "LARGEUR")
    private int width;

    @Column(name = "COLSPAN")
    private int colspan;
}
