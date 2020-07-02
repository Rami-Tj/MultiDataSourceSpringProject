package com.multiDataSourceSpring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "RAPPORTS")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RAPPORT_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "RESSOURCE_DONNEE_ID")
    private DataSource dataSource;

    @ManyToOne
    @JoinColumn(name = "CRITERE_RECHERCHE_ID")
    private Form searchCriteriaForm;

    @ManyToOne
    @JoinColumn(name = "TABLEAU_RESULTAT_ID")
    private TableResult bodyResultTable;

    @Column(name = "LIBELLE")
    private String title;

    @Column(name = "REQUETE_SQL_ENTETE")
    private String headingSQLQuery;

    @Column(name = "REQUETE_SQL_DETAIL")
    private String detailsSQLQuery;

    @Column(name = "AVEC_TEMPLATE")
    private Boolean withTemplate;

    @Column(name = "TEMPLATE")
    private String template;
}
