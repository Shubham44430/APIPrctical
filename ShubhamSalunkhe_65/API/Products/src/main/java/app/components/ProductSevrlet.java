
package main.java.app.components;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import main.java.app.components.ProductBean;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import com.google.gson.Gson;



@WebServlet("/api/product/*")
public class ProductSevrlet extends HttpServlet {

    private void addCors(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }

    ProductBean pbean = new ProductBean();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("application/json");

        String id = req.getPathInfo();

        try {
            if (id == null || id.equals("/")) {
                res.getWriter().print(
                        gson.toJson(pbean.GetAllProducts()));
            } else {
                int idd = Integer.parseInt(id.substring(1));
                res.getWriter().print(
                        gson.toJson(pbean.FindByID(idd)));

            }
        } catch (Exception e) {
            System.out.println("Error Shows"+e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
            res.setContentType("application/json");

            try {
                ProductEntry pr = gson.fromJson(req.getReader(),ProductEntry.class);
                pbean.AddProducts(pr);
                res.getWriter().print("New Product Added");
            } 
            catch(Exception e){
                System.out.println("No New Product add"+e);
            }
    }
}