package org.kai.academy.signinservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.kai.academy.signinservlet.model.Product;
import org.kai.academy.signinservlet.model.Users;
import org.kai.academy.signinservlet.utils.HibernateUtil;
import org.kai.academy.signinservlet.utils.MD5Util;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@WebServlet(name = "ProductsServlet2", value = "/Productsjiu")
    public class ProductsServletjiujiu extends HttpServlet {
    Session session;
    private Object HttpServletResponse;
    private Product[] Products;


    @Override
    public void init() throws ServletException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
        @Override
        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
            Root<Product> root = criteriaQuery.from(Product.class);
            try {
                criteriaQuery.select(root);
                List<Product> products = session.createQuery(criteriaQuery).getResultList();
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<head>\n" +
                        "        <meta charset=\"utf-8\" />\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n" +
                        "        <meta name=\"description\" content=\"\" />\n" +
                        "        <meta name=\"author\" content=\"\" />\n" +
                        "        <title>Shop Homepage - Start Bootstrap Template</title>\n" +
                        "        <!-- Favicon-->\n" +
                        "        <link rel=\"icon\" type=\"image/x-icon\" href=\"assets/favicon.ico\" />\n" +
                        "        <!-- Bootstrap icons-->\n" +
                        "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\" rel=\"stylesheet\" />\n" +
                        "        <!-- Core theme CSS (includes Bootstrap)-->\n" +
                        "        <link href=\"https://twitter-storage.s3.ap-northeast-2.amazonaws.com/styles.css\" rel=\"stylesheet\" />\n" +
                        "    </head>");
                out.println(" <body>\n" +
                        "        <!-- Navigation-->\n" +
                        "        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
                        "            <div class=\"container px-4 px-lg-5\">\n" +
                        "                <a class=\"navbar-brand\" href=\"#!\">Start Bootstrap</a>\n" +
                        "                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\"><span class=\"navbar-toggler-icon\"></span></button>\n" +
                        "                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
                        "                    <ul class=\"navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4\">\n" +
                        "                        <li class=\"nav-item\"><a class=\"nav-link active\" aria-current=\"page\" href=\"#!\">Home</a></li>\n" +
                        "                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"#!\">About</a></li>\n" +
                        "                        <li class=\"nav-item dropdown\">\n" +
                        "                            <a class=\"nav-link dropdown-toggle\" id=\"navbarDropdown\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Shop</a>\n" +
                        "                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n" +
                        "                                <li><a class=\"dropdown-item\" href=\"#!\">All Products</a></li>\n" +
                        "                                <li><hr class=\"dropdown-divider\" /></li>\n" +
                        "                                <li><a class=\"dropdown-item\" href=\"#!\">Popular Items</a></li>\n" +
                        "                                <li><a class=\"dropdown-item\" href=\"#!\">New Arrivals</a></li>\n" +
                        "                            </ul>\n" +
                        "                        </li>\n" +
                        "                    </ul>\n" +
                        "                    <form class=\"d-flex\">\n" +
                        "                        <button class=\"btn btn-outline-dark\" type=\"submit\">\n" +
                        "                            <i class=\"bi-cart-fill me-1\"></i>\n" +
                        "                            Cart\n" +
                        "                            <span class=\"badge bg-dark text-white ms-1 rounded-pill\">0</span>\n" +
                        "                        </button>\n" +
                        "                    </form>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </nav>\n" +
                        "        <!-- Header-->\n" +
                        "        <header class=\"bg-dark py-5\">\n" +
                        "            <div class=\"container px-4 px-lg-5 my-5\">\n" +
                        "                <div class=\"text-center text-white\">\n" +
                        "                    <h1 class=\"display-4 fw-bolder\">Shop in style</h1>\n" +
                        "                    <p class=\"lead fw-normal text-white-50 mb-0\">With this shop hompeage template</p>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </header>\n" +
                        "        <!-- Section-->\n" +
                        "        <section class=\"py-5\">\n" +
                        "            <div class=\"container px-4 px-lg-5 mt-5\">\n");
                out.println("<section class=\"py-5\">																												");
                out.println("           <div class=\"container px-4 px-5 mt-5\">                                                                              "  );
                out.println("               <div class\"row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center\">                       "  );
                for (Product pro : products) {
                    out.println("  <div class=\"col-5\">    ");
                out.println("                           <img class=\"card-img-top\" src=\n" + pro.getProductImageLink() +  " alt=\"...\" />          "  );
                out.println("                           <!-- Product details-->                                                                                "  );
                out.println("                           <div class=\"card-body p-4\">                                                                            "  );
                out.println("                               <div class=\"text-center\">                                                                          "  );
                out.println("                                   <!-- Product name-->                                                                           "  );
                out.println("                                   <h5 class=\"fw-bolder\">"  + pro.getProductName() + "></h5>                                                       "  );
                out.println("                                   <!-- Product price-->                                                                          "  );
                out.println("                                   $" + pro.getBuyPrice() +  "                                                                 ");
                out.println("                               </div>                                                                                             "  );
                out.println("                           </div>                                                                                                 "  );
                out.println("                           <!-- Product actions-->                                                                                "  );
                out.println("                           <div class=\"card-footer p-4 pt-0 border-top-0 bg-transparent\">                                         "  );
                out.println("                               <div class=\"text-center\"><a class=\"btn btn-outline-dark mt-auto\" href=\"#\">View options</a></div>   "  );
                out.println("                           </div>                                                                                                 "  );
                out.println("                       </div>                                                                                                     "  );
                out.println("                   </div>");
                }

                out.println("</body>");
            } catch (NoResultException  exception) {
                exception.printStackTrace();
            }

        }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}






