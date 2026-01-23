package com.bms.bms_backend.model; // folder name for spring to scan

import jakarta.persistence.*; // annotations
import lombok.*; // auto-generates getters and setters

@Entity // tells class = table in DB
@Table(name = "users") // plural form avoids keyword conflict
@Data // auto-generates getters,setters
@NoArgsConstructor // adds empty constructor
@AllArgsConstructor // add constructor with all fields
@Builder // build object easily
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;
    // hibernate automatically maps fields to columns

    /*
            Error	Meaning
            FATAL: password authentication failed	-   Wrong DB password
            relation "user" already exists	-   Table already created manually — ignore or drop it
            No suitable driver found	-   PostgreSQL driver missing (but you have it in pom.xml 👍)
            Cannot connect to localhost:5432	-   PostgreSQL not running — start service
     */

}
