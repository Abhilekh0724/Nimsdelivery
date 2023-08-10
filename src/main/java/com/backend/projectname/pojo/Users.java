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
private String user_firstname;
private String user_lastname;
private String email;
private String password;


}
