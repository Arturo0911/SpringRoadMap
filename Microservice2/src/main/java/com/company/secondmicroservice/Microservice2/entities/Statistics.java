package com.company.secondmicroservice.Microservice2.entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "Latest_statistics")
@AllArgsConstructor @NoArgsConstructor
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Getter @Setter
    @Column(name = "description")
    @NotNull @NotBlank @NotEmpty
    private String description;

    @Column(name = "date")
    @Getter @Setter
    private Date date;

    @Getter @Setter
    @Column(name = "email")
    @NotNull @NotBlank @NotEmpty
    private String email;

    @PrePersist
    void getTimeOperation(){
        this.date = new Date();
    }



}
