package bookingservis.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the roommates database table.
 * 
 */
@Entity
@Table(name="roommates")
@NamedQuery(name="Roommate.findAll", query="SELECT r FROM Roommate r")
public class Roommate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private double phone;

	private String surname;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Roommate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPhone() {
		return this.phone;
	}

	public void setPhone(double phone) {
		this.phone = phone;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}