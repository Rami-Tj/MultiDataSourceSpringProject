package com.multiDataSourceSpring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "RESSOURCE_DONNEES")
public class DataSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESSOURCE_DONNEE_ID")
    private int id;

    @Column(name = "LIBELLE")
    private String name;

    @ManyToOne
    @JoinColumn(name = "TYPE_RESSOURCE_DONNEE_ID")
    private DataSourceType dataSourceType;

    @Column(name = "ADRESSE_IP")
    private String host;

    @Column(name = "PORT")
    private int port;

    @Column(name = "NOM_BASE_DONNEES")
    private String databaseName;

    @Column(name = "LOGIN")
    private String userName;

    @Column(name = "MOT_DE_PASSE")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RESSOURCE_DONNEES_PROPRIETES_MAPPING",
            joinColumns = {
                    @JoinColumn(name = "RESSOURCE_DONNEE_ID")
            })
    @MapKeyColumn(name = "NOM_PROPRIETE")
    @Column(name = "VALEUR_PROPRIETE")
    private Map<String, String> additionalProperties;
}
