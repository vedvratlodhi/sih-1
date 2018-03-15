package com.creathon.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="agency")
public class Agency {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
	
	 @Column(name = "agency_name")
	 private String name;
	 
	 @Column(name = "email")
	 private String email;
	 
	 @JoinColumn(name = "address_id")
	 @OneToOne
	 private Address addressId;
	 
	 
	 @Column(name = "representative_name")
	 private String representativeName;
	 
	 @Column(name = "representative_contact_no")
	 private Long representativeContactNo;
	 
	 public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public String getRepresentativeName() {
		return representativeName;
	}

	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}

	public Long getRepresentativeContactNo() {
		return representativeContactNo;
	}

	public void setRepresentativeContactNo(Long representativeContactNo) {
		this.representativeContactNo = representativeContactNo;
	}

	public String getRepresentativeEmail() {
		return representativeEmail;
	}

	public void setRepresentativeEmail(String representativeEmail) {
		this.representativeEmail = representativeEmail;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "representative_email")
	 private String representativeEmail;
	 
	 @Column(name = "photo")
	 private String photo;
	 
	 @Column(name = "type")
	 private String type;
	 
	 
	 
	
}
