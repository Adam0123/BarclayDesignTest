package com.barclay.theatre;

/**
 * Party pojo class
 *
 * @author zdz
 * @create 2018-07-02-15:07
 */

public class Party {

    private String customerName;

    private int requestedSeats;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getRequestedSeats() {
        return requestedSeats;
    }

    public void setRequestedSeats(int requestedSeats) {
        this.requestedSeats = requestedSeats;
    }
}
