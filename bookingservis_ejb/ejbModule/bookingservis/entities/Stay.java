package bookingservis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the stay database table.
 * 
 */
@Entity
@NamedQuery(name="Stay.findAll", query="SELECT s FROM Stay s")
public class Stay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_stay")
	private int idStay;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="nr_residents")
	private double nrResidents;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to RentalUnit
	@ManyToOne
	@JoinColumn(name="rental_unit_id")
	private RentalUnit rentalUnit;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Stay() {
	}

	public int getIdStay() {
		return this.idStay;
	}

	public void setIdStay(int idStay) {
		this.idStay = idStay;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getNrResidents() {
		return this.nrResidents;
	}

	public void setNrResidents(double nrResidents) {
		this.nrResidents = nrResidents;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public RentalUnit getRentalUnit() {
		return this.rentalUnit;
	}

	public void setRentalUnit(RentalUnit rentalUnit) {
		this.rentalUnit = rentalUnit;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}