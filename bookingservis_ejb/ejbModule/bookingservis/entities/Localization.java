package bookingservis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the localization database table.
 * 
 */
@Entity
@NamedQuery(name="Localization.findAll", query="SELECT l FROM Localization l")
public class Localization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String country;

	private String name;

	//bi-directional many-to-one association to RentalUnit
	@OneToMany(mappedBy="localization")
	private List<RentalUnit> rentalUnits;

	public Localization() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RentalUnit> getRentalUnits() {
		return this.rentalUnits;
	}

	public void setRentalUnits(List<RentalUnit> rentalUnits) {
		this.rentalUnits = rentalUnits;
	}

	public RentalUnit addRentalUnit(RentalUnit rentalUnit) {
		getRentalUnits().add(rentalUnit);
		rentalUnit.setLocalization(this);

		return rentalUnit;
	}

	public RentalUnit removeRentalUnit(RentalUnit rentalUnit) {
		getRentalUnits().remove(rentalUnit);
		rentalUnit.setLocalization(null);

		return rentalUnit;
	}

}