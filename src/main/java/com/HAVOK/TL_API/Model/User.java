package com.HAVOK.TL_API.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "user")
@Data
public class User {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String mail;
    @Column
    private String password;
}
