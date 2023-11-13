package com.example.demo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class Booking {
	@Id
	@Column(name = "BOOKINGNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingNO;
	
	@Column(name = "GUESTNO")
	private Integer guestNO;
	
	@Column(name = "ROOMNO")
	private Integer roomNO;
	
	@Column(name = "HOTELNO")
	private Integer hotelNO;
	
	@Column(name = "DATEBOOKING")
	private Date dateBooking;
	
	@Column(name = "DATECHECKIN")
	private Date dateBookingIN;
	
	@Column(name = "DATECHECKOUT")
	private Date dateBookingOUT;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "NUMBERGUEST")
	private String numberGuest;

	public Integer getBookingNO() {
		return bookingNO;
	}

	public void setBookingNO(Integer bookingNO) {
		this.bookingNO = bookingNO;
	}

	public Integer getGuestNO() {
		return guestNO;
	}

	public void setGuestNO(Integer guestNO) {
		this.guestNO = guestNO;
	}

	public Integer getRoomNO() {
		return roomNO;
	}

	public void setRoomNO(Integer roomNO) {
		this.roomNO = roomNO;
	}

	public Integer getHotelNO() {
		return hotelNO;
	}

	public void setHotelNO(Integer hotelNO) {
		this.hotelNO = hotelNO;
	}

	public Date getDateBooking() {
		return dateBooking;
	}

	public void setDateBooking(Date dateBooking) {
		this.dateBooking = dateBooking;
	}

	public Date getDateBookingIN() {
		return dateBookingIN;
	}

	public void setDateBookingIN(Date dateBookingIN) {
		this.dateBookingIN = dateBookingIN;
	}

	public Date getDateBookingOUT() {
		return dateBookingOUT;
	}

	public void setDateBookingOUT(Date dateBookingOUT) {
		this.dateBookingOUT = dateBookingOUT;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumberGuest() {
		return numberGuest;
	}

	public void setNumberGuest(String numberGuest) {
		this.numberGuest = numberGuest;
	}
	
}