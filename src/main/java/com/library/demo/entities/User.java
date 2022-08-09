
package com.library.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
    
    @Id
    @GeneratedValue (generator = "uuid")
    @GenericGenerator (name = "uuid" , strategy = "uuid2")
    private String id;
    private String name;
    private String mail;
}
