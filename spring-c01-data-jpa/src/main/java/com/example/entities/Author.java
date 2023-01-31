package com.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Generar id automaticamente
    private Long id;

    @Column(length = 50)
    private String fullName;

    @Column(unique = true) //obliga a que el campo tenga un valor único y distinto para cada Author
    private String nif;  // @Column(nullable = true) /// indica que el campo es opcional, es decir, puede ser null


    @Column(unique = true, nullable = false)
    //Indica que el campo es obligatorio, es decir, no puede ser NULL (nullable = false)
    private String email;

    private LocalDate birthDate;

    private Boolean active;

    private Double salary;
    @OneToOne // Un autor tiene una dirección, una dirección solo puede permanecer a un mismo autor
    private Address address;


    public Author(Long id, String fullName, String nif, String email, LocalDate birthDate, Boolean active, Double salary, Address address) {
        this.id = id;
        this.fullName = fullName;
        this.nif = nif;
        this.email = email;
        this.birthDate = birthDate;
        this.active = active;
        this.salary = salary;
        this.address = address;
    }

    // Método Getter
    public Author() {

    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNif() {
        return nif;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Boolean getActive() {
        return active;
    }

    public Double getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }

    // Método Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", nif='" + nif + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", active=" + active +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}


