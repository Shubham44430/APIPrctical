package main.java.app.components;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBean {

    public List<ProductEntry> GetAllProducts() throws SQLException {
        try (var conn = Productdb.pool.getConnection()) {
            List<ProductEntry> emps = new ArrayList<>();
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery("select pno , price, stock from products");
            while (rs.next()) {
                var emp = new ProductEntry(rs);
                emps.add(emp);
            }
            rs.close();
            stmt.close();
            return emps;
        }
    }

    public ProductEntry FindByID(int id) throws Exception {

        ProductEntry emp = null;

        try (var conn = Productdb.pool.getConnection()) {
            var stmt = conn.prepareStatement("select pno , price, stock from products where pno=?");
            stmt.setInt(1, id);

            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    emp = new ProductEntry(rs);
                }
            }
        }
        return emp;

    }

    public int AddProducts(ProductEntry em) throws Exception {

        try (var conn = Productdb.pool.getConnection()) {
            var pstmt = conn.prepareStatement("insert into products (pno ,price ,stock) values(?,?,?)");
            pstmt.setInt(1, em.getId());
            pstmt.setInt(2, em.getPrice());
            pstmt.setInt(3, em.getStock());

            return pstmt.executeUpdate();
        }

    }
}