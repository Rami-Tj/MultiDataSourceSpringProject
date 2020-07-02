package com.multiDataSourceSpring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TABLEAU_COLONNES")
public class TableColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TABLEAU_COLONNE_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "TYPE_DONNEE_ID")
    private DataType dataType;

    @Column(name = "LIBELLE")
    private String name;

    @Column(name = "LARGEUR")
    private int width;
}
