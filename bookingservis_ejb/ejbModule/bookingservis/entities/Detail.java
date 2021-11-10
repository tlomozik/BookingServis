package bookingservis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the details database table.
 * 
 */
@Entity
@Table(name="details")
@NamedQuery(name="Detail.findAll", query="SELECT d FROM Detail d")
public class Detail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String available;

	@Lob
	private String description;

	@Column(name="double_bed")
	private String doubleBed;

	@Column(name="free_parking")
	private String freeParking;

	private String kitchen;

	@Column(name="pets_allowed")
	private String petsAllowed;

	private double phone;

	@Column(name="price_per_night")
	private int pricePerNight;

	private int slots;

	private String wifi;

	//bi-directional many-to-one association to RentalUnit
	@ManyToOne
	@JoinColumn(name="rental_unit_id")
	private RentalUnit rentalUnit;

	//bi-directional many-to-one association to RentalUnit
	@OneToMany(mappedBy="detail")
	private List<RentalUnit> rentalUnits;

	public Detail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvailable() {
		return this.available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDoubleBed() {
		return this.doubleBed;
	}

	public void setDoubleBed(String doubleBed) {
		this.doubleBed = doubleBed;
	}

	public String getFreeParking() {
		return this.freeParking;
	}

	public void setFreeParking(String freeParking) {
		this.freeParking = freeParking;
	}

	public String getKitchen() {
		return this.kitchen;
	}

	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}

	public String getPetsAllowed() {
		return this.petsAllowed;
	}

	public void setPetsAllowed(String petsAllowed) {
		this.petsAllowed = petsAllowed;
	}

	public double getPhone() {
		return this.phone;
	}

	public void setPhone(double phone) {
		this.phone = phone;
	}

	public int getPricePerNight() {
		return this.pricePerNight;
	}

	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getSlots() {
		return this.slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public String getWifi() {
		return this.wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
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
		rentalUnit.setDetail(this);

		return rentalUnit;
	}

	public RentalUnit removeRentalUnit(RentalUnit rentalUnit) {
		getRentalUnits().remove(rentalUnit);
		rentalUnit.setDetail(null);

		return rentalUnit;
	}

}