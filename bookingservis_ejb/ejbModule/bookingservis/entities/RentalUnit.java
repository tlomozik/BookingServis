package bookingservis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rental_unit database table.
 * 
 */
@Entity
@Table(name="rental_unit")
@NamedQuery(name="RentalUnit.findAll", query="SELECT r FROM RentalUnit r")
public class RentalUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String name;

	//bi-directional many-to-one association to Detail
	@OneToMany(mappedBy="rentalUnit")
	private List<Detail> details;

	//bi-directional many-to-one association to Host
	@OneToMany(mappedBy="rentalUnit")
	private List<Host> hosts;

	//bi-directional many-to-one association to Detail
	@ManyToOne
	@JoinColumn(name="details_id")
	private Detail detail;

	//bi-directional many-to-one association to Host
	@ManyToOne
	private Host host;

	//bi-directional many-to-one association to Localization
	@ManyToOne
	private Localization localization;

	//bi-directional many-to-one association to Stay
	@OneToMany(mappedBy="rentalUnit")
	private List<Stay> stays;

	public RentalUnit() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Detail> getDetails() {
		return this.details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	public Detail addDetail(Detail detail) {
		getDetails().add(detail);
		detail.setRentalUnit(this);

		return detail;
	}

	public Detail removeDetail(Detail detail) {
		getDetails().remove(detail);
		detail.setRentalUnit(null);

		return detail;
	}

	public List<Host> getHosts() {
		return this.hosts;
	}

	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}

	public Host addHost(Host host) {
		getHosts().add(host);
		host.setRentalUnit(this);

		return host;
	}

	public Host removeHost(Host host) {
		getHosts().remove(host);
		host.setRentalUnit(null);

		return host;
	}

	public Detail getDetail() {
		return this.detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Host getHost() {
		return this.host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public Localization getLocalization() {
		return this.localization;
	}

	public void setLocalization(Localization localization) {
		this.localization = localization;
	}

	public List<Stay> getStays() {
		return this.stays;
	}

	public void setStays(List<Stay> stays) {
		this.stays = stays;
	}

	public Stay addStay(Stay stay) {
		getStays().add(stay);
		stay.setRentalUnit(this);

		return stay;
	}

	public Stay removeStay(Stay stay) {
		getStays().remove(stay);
		stay.setRentalUnit(null);

		return stay;
	}

}