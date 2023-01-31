package com.example.entities;

import jakarta.persistence.*;


    @Entity
    @Table(name = "address") //opcional
    public class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        private String street;

        private String city;

        private String country;



        public Address(){

        }



        // Generar un constructor
        public Address(Long id, String street, String city, String country) {
            this.id = id;
            this.street = street;
            this.city = city;
            this.country = country;
        }

        // generar un getter y Setter

        public Long getId() {  return id;  }

        public String getStreet() {   return street; }

        public String getCity() { return city;  }

        public String getCountry() {  return country;  }

        public void setId(Long id) {  this.id = id;  }

        public void setStreet(String street) {  this.street = street;  }

        public void setCity(String city) {  this.city = city;  }

        public void setCountry(String country) {  this.country = country; }

        // Generar toString()

        @Override
        public String toString() {
            return "Address{" +
                    "id=" + id +
                    ", street='" + street + '\'' +
                    ", city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }











