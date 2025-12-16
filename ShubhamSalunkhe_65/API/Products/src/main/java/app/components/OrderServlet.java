package main.java.app.components;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/orders/*")
public class OrderServlet extends HttpServlet {

    OrderBean obean = new OrderBean();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("application/json");
        String id = req.getPathInfo();

        try {
            if (id == null || id.equals("/")) {
              
                res.getWriter().print(
                        gson.toJson(obean.getAllOrders()));
            } else {
               
                int ordNo = Integer.parseInt(id.substring(3));
                res.getWriter().print(
                        gson.toJson(obean.findByOrderNo(ordNo)));
            }
        } catch (Exception e) {
            res.setStatus(500);
            res.getWriter().print(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("application/json");

        try {
            OrderEntry ord =
                    gson.fromJson(req.getReader(), OrderEntry.class);

            obean.addOrder(ord);
            res.getWriter().print("Order Created Successfully");
        } catch (Exception e) {
           System.out.println("Error");
        }
    }
}
