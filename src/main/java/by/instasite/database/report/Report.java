package by.instasite.database.report;

import javax.persistence.*;


@Entity
@Table(name = "Report")
public class Report {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ID_Zapravka")
    private int idStation;

    @Column(name = "Fuel")
    private int idFuel;

    @Column(name = "Fueling_date")
    private String fuelingDate;

    @Column(name = "Employee")
    private int idEmployee;

    @Column(name = "Client")
    private int idClient;


}