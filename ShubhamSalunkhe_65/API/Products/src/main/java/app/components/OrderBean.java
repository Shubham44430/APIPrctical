package main.java.app.components;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderBean {

    public List<OrderEntry> getAllOrders() throws SQLException {

        List<OrderEntry> orders = new ArrayList<>();

        try (var conn = Productdb.pool.getConnection();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(
                     "SELECT ORD_NO, ORD_DATE, CUST_ID, PNO, QTY FROM orders")) {

            while (rs.next()) {
                orders.add(new OrderEntry(rs));
            }
        }
        return orders;
    }

    public OrderEntry findByOrderNo(int ordNo) throws Exception {

        OrderEntry order = null;

        try (var conn = Productdb.pool.getConnection();
             var pstmt = conn.prepareStatement(
                     "SELECT ORD_NO, ORD_DATE, CUST_ID, PNO, QTY FROM orders WHERE ORD_NO=?")) {

            pstmt.setInt(1, ordNo);

            try (var rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    order = new OrderEntry(rs);
                }
            }
        }
        return order;
    }

    public int addOrder(OrderEntry ord) throws Exception {

        try (var conn = Productdb.pool.getConnection();
             var pstmt = conn.prepareStatement(
                     "INSERT INTO orders (ORD_NO, ORD_DATE, CUST_ID, PNO, QTY) VALUES (?,?,?,?,?)")) {

            pstmt.setInt(1, ord.getOrdNo());
            pstmt.setDate(2, ord.getOrdDate());
            pstmt.setString(3, ord.getCustId());
            pstmt.setInt(4, ord.getPno());
            pstmt.setInt(5, ord.getQty());

            return pstmt.executeUpdate();
        }
    }
}
