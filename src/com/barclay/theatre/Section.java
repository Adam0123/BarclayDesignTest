package com.barclay.theatre;

import java.util.List;

/**
 * Section pojo class
 *
 * @author zdz
 * @create 2018-07-02-15:05
 */

public class Section {

    private int sectionId;

    private int numOfSeats;

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionid) {
        this.sectionId = sectionid;
    }
}
