package com.bar3.domain.annonation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Flights {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=10)
    private long id;
    
    @Column(name="flight_code",length=20,nullable=false)
    private String flightCode;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="flight_date",nullable=false)
    private Date flightDate;
    
    @Column(length=50,nullable=false)
    private String airline;
    
    @Column(length=20,nullable=false)
    private String type;
    
    @ManyToOne
    @JoinColumn(name="take_airport_id",columnDefinition="number(10)")
    private Airport takeAirport;
    
    @ManyToOne
    @JoinColumn(name="landing_airport_id",columnDefinition="number(10)")
//    @Column(length=10)报错
    private Airport landAirport;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="take_time",nullable=false)
    private Date takeTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="landing_time",nullable=false)
    private Date loadTime;
    
    @Column(name="flight_time",length=20,nullable=false)
    private String flightTime;
    
    @Column(name="stop_airport",length=50)
    private String stopAirport;
    
    @Column(name="refrence_price",length=10,precision=2,nullable=false)
    private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Airport getTakeAirport() {
		return takeAirport;
	}

	public void setTakeAirport(Airport takeAirport) {
		this.takeAirport = takeAirport;
	}

	public Airport getLandAirport() {
		return landAirport;
	}

	public void setLandAirport(Airport landAirport) {
		this.landAirport = landAirport;
	}

	public Date getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(Date takeTime) {
		this.takeTime = takeTime;
	}

	public Date getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(Date loadTime) {
		this.loadTime = loadTime;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public String getStopAirport() {
		return stopAirport;
	}

	public void setStopAirport(String stopAirport) {
		this.stopAirport = stopAirport;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
    
    
}
