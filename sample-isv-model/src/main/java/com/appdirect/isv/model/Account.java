package com.appdirect.isv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "isv_accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "uuid", unique = true)
	private String uuid;

	@Column(name = "appdirect_base_url", length = 1000)
	private String appDirectBaseUrl;

	@Column(name = "edition_code")
	private String editionCode;

	@Column(name = "max_users")
	private Integer maxUsers = null;

	@OneToMany(mappedBy = "account", orphanRemoval = true, cascade = { CascadeType.ALL })
	private List<User> users = new ArrayList<User>();

	@OneToMany(mappedBy = "account", orphanRemoval = true, cascade = { CascadeType.ALL })
	private List<Addon> addons = new ArrayList<Addon>();
}
