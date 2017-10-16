package RezerveTicketServlet;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "Ticket") 
public class Ticket {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
@Column
	private String passengerName;
@Column
	private String To;
@Column
	private String From;
@Column
	private String date;
@Column
 private int flightNumber;



	public int getFlightNumber() {
	return flightNumber;
}

public void setFlightNumber(int flightNumber) {
	this.flightNumber = flightNumber;
}

	Ticket(){
		
	}
	
	public Ticket(int id, String passengerName) {
		super();
		this.id = id;
		this.passengerName = passengerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getTo() {
		return To;
	}

	public void setTo(String to) {
		To = to;
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date2) {
		this.date = date2;
	}

	
	
	

}
