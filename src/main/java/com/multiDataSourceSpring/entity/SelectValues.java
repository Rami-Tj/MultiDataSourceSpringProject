package com.multiDataSourceSpring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "LISTE_VALEURS")
public class SelectValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LISTE_VALEUR_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "RESSOURCE_DONNEE_ID")
    private DataSource dataSource;

    @Column(name = "LIBELLE")
    private String name;

    @Column(name = "REQUETE_SQL")
    private String sqlQuery;

    @Column(name = "COLONNE_ID")
    private String columnId;

    @Column(name = "COLONNE_VALEUR")
    private String columnName;
}
