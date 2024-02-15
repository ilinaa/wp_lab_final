//package mk.finki.ukim.mk.lab.servlet;
//
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.service.implementation.BookServiceImplementation;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/books-servlet")
//public class BookListServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//    private final BookServiceImplementation bookServiceImplementation;
//
//    public BookListServlet(SpringTemplateEngine springTemplateEngine,  BookServiceImplementation bookServiceImplementation1) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.bookServiceImplementation = bookServiceImplementation1;
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//        context.setVariable("books", bookServiceImplementation.listBooks());
//
//        springTemplateEngine.process(
//                "listBooks.html",
//                context,
//                resp.getWriter()
//        );
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String bookIsbn = req.getParameter("bookIsbn");
//        resp.sendRedirect("/author?isbn=" + bookIsbn);
//    }
//}
