package com.Registration.System.StudentDBMS.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Facutly")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Facutly {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	@NotNull
	private String qualification;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="books_facutly", joinColumns = @JoinColumn(name="fctly_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="bks_id", referencedColumnName = "id"))
//	@JoinTable(name="books_facutly", joinColumns = @JoinColumn(name="fctly_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="bks_id", referencedColumnName = "id"))
	private List<Books> books;
}