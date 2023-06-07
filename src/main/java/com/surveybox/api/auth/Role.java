package com.surveybox.api.auth;

import com.surveybox.api.user.User;

import jakarta.persistence.*;

import lombok.*;

import java.util.Collection;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@ManyToMany(mappedBy = "roles")
	private Collection<User>users;
}