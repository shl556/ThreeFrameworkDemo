package com.bar3.domain.annonation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="flight_tickets")
public class Tickets {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(length=10)
   private long id;
   
   @ManyToOne
   @JoinColumn(name="flight_id",columnDefinition="number(10)")
   private Flights flights;
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name="flight_date",columnDefinition="date not null")
   private Date flightDate;
   
   @Column(name="ticket_price",columnDefinition="number(10,2)")
   private double ticketPrice;
   
   @Column(name="sell_company",length=50)
   private String sellCompany;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Flights getFlights() {
	return flights;
}

public void setFlights(Flights flights) {
	this.flights = flights;
}

public Date getFlightDate() {
	return flightDate;
}

public void setFlightDate(Date flightDate) {
	this.flightDate = flightDate;
}

public double getTicketPrice() {
	return ticketPrice;
}

public void setTicketPrice(double ticketPrice) {
	this.ticketPrice = ticketPrice;
}

public String getSellCompany() {
	return sellCompany;
}

public void setSellCompany(String sellCompany) {
	this.sellCompany = sellCompany;
}
   
}
