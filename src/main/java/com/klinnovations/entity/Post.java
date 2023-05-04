package com.klinnovations.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "POST_TBL")
@Setter
@Getter
public class Post {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer postId;

private String title;

private String description;

@Lob
private String content;

@CreationTimestamp
private LocalDate createdOn;

@UpdateTimestamp
private LocalDate updatedOn;

@ManyToOne
@JoinColumn(name="user_id")
private User user;

@OneToMany(mappedBy = "post", cascade=CascadeType.REMOVE)

private List<Comment> comments;


}
