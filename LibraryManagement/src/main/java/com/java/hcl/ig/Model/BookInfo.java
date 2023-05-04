package com.java.hcl.ig.Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class BookInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;

	private String bookName;

	private String author;

	private float price;

	private Long bookPages;

	private Long noOfCopies;

	private String bookPublication;

	@ManyToOne
	@JoinColumn(name = "CreatedBy")
	private LibUser createdBy;

	@ManyToOne
	@JoinColumn(name = "ModifiedBy")
	private LibUser modifiedBy;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date createdOn;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date modifiedOn;

	private int activeFlag;
}
