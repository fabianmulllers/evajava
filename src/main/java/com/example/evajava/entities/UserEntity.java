package com.example.evajava.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Entity
@Data
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1655244326317122374L;

	@Id
	private UUID idUser;
	
	@OneToMany(mappedBy = "idUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<PhoneEntity> telefonos;
	
	private String nombre;
	
	private String correo;
	
	private String password;
	
	@Column(updatable = false)
	private Date dateCreated;
	
	private Date dateUpdated;
	
	private Date lastLogin;
	
	private Boolean active = true;
	
    @PrePersist
    protected void onCreate() {
        dateCreated = new Date();
        lastLogin = new Date();
    }
    
    
    
    @PreUpdate
    protected void onUpdate() {
        dateUpdated = new Date();
        lastLogin = new Date();
    }
	
}