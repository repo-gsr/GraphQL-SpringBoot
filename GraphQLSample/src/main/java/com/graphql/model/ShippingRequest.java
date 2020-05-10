package com.graphql.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ShippingRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String goodsType;
	private Address pickupAddress;
	private Address deliveryLocation;
	private String customerID;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date shippingRequestDate;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public Address getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(Address pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public Address getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(Address deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	@Override
	public String toString() {
		return "CustomerShippingRequest [goodsType=" + goodsType + ", pickupAddress=" + pickupAddress
				+ ", deliveryLocation=" + deliveryLocation + ", customerID=" + customerID + ", shippingRequestDate="
				+ shippingRequestDate + "]";
	}
}
