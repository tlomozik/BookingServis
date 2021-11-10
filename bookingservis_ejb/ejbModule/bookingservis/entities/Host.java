package bookingservis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the host database table.
 * 
 */
@Entity
@NamedQuery(name="Host.findAll", query="SELECT h FROM Host h")
public class Host implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private double phone;

	private String surname;

	//bi-directional many-to-one association to RentalUnit
	@ManyToOne
	@JoinColumn(name="rental_unit_id")
	private RentalUnit rentalUnit;

	//bi-directional many-to-one association to RentalUnit
	@OneToMany(mappedBy="host")
	private List<RentalUnit> rentalUnits;

	public Host() {
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

	public RentalUnit getRentalUnit() {
		return this.rentalUnit;
	}

	public void setRentalUnit(RentalUnit rentalUnit) {
		this.rentalUnit = rentalUnit;
	}

	public List<RentalUnit> getRentalUnits() {
		return this.rentalUnits;
	}

	public void setRentalUnits(List<RentalUnit> rentalUnits) {
		this.rentalUnits = rentalUnits;
	}

	public RentalUnit addRentalUnit(RentalUnit rentalUnit) {
		getRentalUnits().add(rentalUnit);
		rentalUnit.setHost(this);

		return rentalUnit;
	}

	public RentalUnit removeRentalUnit(RentalUnit rentalUnit) {
		getRentalUnits().remove(rentalUnit);
		rentalUnit.setHost(null);

		return rentalUnit;
	}

}