package com.mercury.finalProject.bean;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ecb_user")
public class User implements UserDetails {
	private static final long serialVersionUID=2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_USER_SEQ_GEN")
	@SequenceGenerator(name = "ECB_USER_SEQ_GEN", sequenceName = "ECB_USER_SEQ", allocationSize = 1)
	private int id;
	
	@NotNull
	@Column(name = "username",unique = true, nullable = false)
	private String username;
	@NotNull
	@Column(name = "password", nullable = false)
	private String password;
	@Column
	private Blob image;
	@Column(name = "onlinestatus")
	private int onlineStatus;
	@Column
	private int activated;
	@Column
	private int credits;
	@Column(name = "REGISTEREDDATE")
	@JsonFormat(pattern = "yyyy/mm/dd")
	private Date registeredDate;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ecb_user_ecb_user_profile", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
					@JoinColumn(name = "user_profile_id",referencedColumnName = "id")})
	private List<UserProfile> profiles = new ArrayList<UserProfile>();
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private UserDetail userDetail;
	

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return profiles;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public User(int id, @NotNull String username, @NotNull String password, Blob image, int activated, int credits,
			Date registeredDate, List<UserProfile> profiles, UserDetail userDetail) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.image = image;
		this.activated = activated;
		this.credits = credits;
		this.registeredDate = registeredDate;
		this.profiles = profiles;
		this.userDetail = userDetail;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public int getActivated() {
		return activated;
	}
	public void setActivated(int activated) {
		this.activated = activated;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public List<UserProfile> getProfiles() {
		return profiles;
	}
	public void setProfiles(List<UserProfile> profiles) {
		this.profiles = profiles;
	}
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", image=" + image
				+ ", activated=" + activated + ", credits=" + credits + ", registeredDate=" + registeredDate
				+ ", profiles=" + profiles + ", userDetail=" + userDetail + "]";
	}
	

}
