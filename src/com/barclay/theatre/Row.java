package com.barclay.theatre;

import java.util.List;

/**
 * Row pojo class
 *
 * @author zdz
 * @create 2018-07-02-15:04
 */

public class Row {

    private int rowId;

    private List<Section> sections;

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
