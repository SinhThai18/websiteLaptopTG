package com.web.laptoptg.controller.admin;

import com.web.laptoptg.model.Product;
import com.web.laptoptg.service.BrandService;
import com.web.laptoptg.service.CategoryService;
import com.web.laptoptg.service.ProductService;
import com.web.laptoptg.service.impl.BrandServiceImpl;
import com.web.laptoptg.service.impl.CategoryServiceImpl;
import com.web.laptoptg.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/admin/product-delete")
public class ProductDeleteController extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;
    private BrandService brandService;

    public void init() throws ServletException {
        productService = new ProductServiceImpl();
        categoryService = new CategoryServiceImpl();
        brandService = new BrandServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findProductById(id);
        String status = product.getStatus();
        String msg;
        if(status.equals("Inactive")){
            msg = "Sản phẩm đã ở trạng thái 'Ngừng bán'";
        }
        status = "Inactive";
        product.setStatus(status);
        productService.updateProduct(product);
        msg = "Sản phẩm đã đổi trạng thái thành công!";
        req.getSession().setAttribute("msg", msg);
        resp.sendRedirect(req.getContextPath() + "/admin/product-manage");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
