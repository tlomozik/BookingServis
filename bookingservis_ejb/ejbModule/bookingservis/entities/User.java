package bookingservis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String login;

	private String name;

	private String password;

	private double phone;

	private String role;

	private String surname;

	//bi-directional many-to-one association to Roommate
	@OneToMany(mappedBy="user")
	private List<Roommate> roommates;

	//bi-directional many-to-one association to Stay
	@OneToMany(mappedBy="user")
	private List<Stay> stays;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getPhone() {
		return this.phone;
	}

	public void setPhone(double phone) {
		this.phone = phone;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Roommate> getRoommates() {
		return this.roommates;
	}

	public void setRoommates(List<Roommate> roommates) {
		this.roommates = roommates;
	}

	public Roommate addRoommate(Roommate roommate) {
		getRoommates().add(roommate);
		roommate.setUser(this);

		return roommate;
	}

	public Roommate removeRoommate(Roommate roommate) {
		getRoommates().remove(roommate);
		roommate.setUser(null);

		return roommate;
	}

	public List<Stay> getStays() {
		return this.stays;
	}

	public void setStays(List<Stay> stays) {
		this.stays = stays;
	}

	public Stay addStay(Stay stay) {
		getStays().add(stay);
		stay.setUser(this);

		return stay;
	}

	public Stay removeStay(Stay stay) {
		getStays().remove(stay);
		stay.setUser(null);

		return stay;
	}

}