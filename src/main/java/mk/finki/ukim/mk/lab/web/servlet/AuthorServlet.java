//package mk.finki.ukim.mk.lab.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.service.implementation.AuthorServiceImplementation;
//import mk.finki.ukim.mk.lab.service.implementation.BookServiceImplementation;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//import mk.finki.ukim.mk.lab.model.Book;
//
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/author-servlet")
//public class AuthorServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//    private final AuthorServiceImplementation authorServiceImplementation;
//    private final BookServiceImplementation bookServiceImplementation;
//
//    public AuthorServlet(SpringTemplateEngine springTemplateEngine,AuthorServiceImplementation authorServiceImplementation, BookServiceImplementation bookServiceImplementation) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.authorServiceImplementation = authorServiceImplementation;
//        this.bookServiceImplementation = bookServiceImplementation;
//
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
//        context.setVariable("authors", authorServiceImplementation.listAuthors());
//        context.setVariable("bookIsbn", req.getParameter("isbn"));
//        springTemplateEngine.process(
//                "authorList.html",
//                context,
//                resp.getWriter()
//        );
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        Integer authorId = Integer.valueOf(req.getParameter("authorId"));
////        String bookIsbn = req.getParameter("bookIsbn");
////        bookServiceImplementation.addAuthorToBook(authorId,bookIsbn );
////        resp.sendRedirect("/bookDetails?isbn=" + bookIsbn);
////    }
//        String bookIsbn = req.getParameter("isbn");//null
//        Book book = bookServiceImplementation.findBookByIsbn(bookIsbn);
//        if(book != null){
//            Integer authorId = Integer.valueOf(req.getParameter("authorId"));
//            bookServiceImplementation.addAuthorToBook(Long.valueOf(authorId), bookIsbn);
//            resp.sendRedirect("/book-details?isbn=" + bookIsbn);
//        }else{
//            resp.sendRedirect("/error-page");
//        }
//    }
//}
