//package mk.finki.ukim.mk.lab.servlet;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Book;
//import mk.finki.ukim.mk.lab.service.implementation.BookServiceImplementation;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/book-details-servlet")
//public class BookDetailsServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//    private final BookServiceImplementation bookServiceImplementation;
//
//
//    public BookDetailsServlet(SpringTemplateEngine springTemplateEngine, BookServiceImplementation bookServiceImplementation1) {
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
//        String bookIsbn = req.getParameter("isbn");
//        Book book = bookServiceImplementation.findBookByIsbn(bookIsbn);
//
//        context.setVariable("book", book);
//        context.setVariable("authors", book.getAuthors());
//        springTemplateEngine.process(
//                "bookDetails.html",
//                context,
//                resp.getWriter()
//        );
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("/book-details");
//    }
//}
