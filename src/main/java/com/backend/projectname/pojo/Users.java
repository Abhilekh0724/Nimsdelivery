package com.backend.projectname.pojo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int user_id;
private String fullName;
private String phoneNumber;
private String address;
private String email;
private String password;
private String confirmPassword;
private String birthday;


    public void setUser_fullName(String fullName) {
    }
}
