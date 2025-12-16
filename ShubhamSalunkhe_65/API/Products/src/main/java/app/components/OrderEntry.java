package main.java.app.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class OrderEntry {

    private int ordNo;
    private Date ordDate;
    private String custId;
    private int pno;
    private int qty;

    public OrderEntry() {}

    public OrderEntry(ResultSet rs) throws SQLException {
        this.ordNo = rs.getInt("ORD_NO");
        this.ordDate = rs.getDate("ORD_DATE");
        this.custId = rs.getString("CUST_ID");
        this.pno = rs.getInt("PNO");
        this.qty = rs.getInt("QTY");
    }

    public int getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(int ordNo) {
        this.ordNo = ordNo;
    }

    public Date getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
