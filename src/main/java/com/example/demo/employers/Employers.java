package com.example.demo.employers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
    public class Employers{
        @Id
        @SequenceGenerator(
                name = "employers_sequence",
                sequenceName = "employers_sequence",
                allocationSize = 1

        )
        @GeneratedValue(
                strategy  = GenerationType.SEQUENCE,
                generator = "employers_sequence"

        )
        private Integer Id;
        private String Name;
        private String Email;
        private String PhoneNumber;
        

        public Integer getId() {
            return Id;
        }

        public void setId(Integer id) {
            Id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            PhoneNumber = phoneNumber;
        }

        public Employers() {
        }

        public Employers(Integer id, String name, String email, String phoneNumber) {
            Id = id;
            Name = name;
            Email = email;
            PhoneNumber = phoneNumber;
        } 

        public Employers(String name, String email, String phoneNumber) {
            Name = name;
            Email = email;
            PhoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Employers [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + "]";
        }
    }


    