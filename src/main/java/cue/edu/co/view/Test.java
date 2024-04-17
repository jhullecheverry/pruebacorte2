package cue.edu.co.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

// Anotación que define la URL relativa que mapea esta servlet
@WebServlet(value="/test")
public class Test extends HttpServlet {

    // Método que maneja las peticiones GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        // Obteniendo información de la petición HTTP
        String metodoHttp = req.getMethod(); // Método HTTP utilizado (GET, POST, etc.)
        String requestUri = req.getRequestURI(); // URI de la solicitud
        String requestUrl = req.getRequestURL().toString(); // URL completa de la solicitud
        String contexPath = req.getContextPath(); // Ruta del contexto de la aplicación
        String servletPath = req.getServletPath(); // Ruta del servlet

        // Obteniendo información de direcciones IP y puertos
        String ipCliente = req.getRemoteAddr(); // Dirección IP del cliente
        String ip = req.getLocalAddr(); // Dirección IP local
        int port = req.getLocalPort(); // Puerto local

        // Obteniendo información del protocolo y host
        String scheme = req.getScheme(); // Protocolo utilizado (HTTP, HTTPS, etc.)
        String host = req.getHeader("host"); // Host de la solicitud

        // Construyendo URLs
        String url = scheme + "://" + host + contexPath + servletPath; // URL con host
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath; // URL con IP y puerto

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println(" <meta charset=\"UTF-8\">");
            out.println(" <title>Cabeceras HTTP Request</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <h1>Cabeceras HTTP Request!</h1>");
            out.println("<ul>");
            // Mostrando información obtenida
            out.println("<li>metodo http: " + metodoHttp + "</li>");
            out.println("<li>request uri: " + requestUri + "</li>");
            out.println("<li>request url: " + requestUrl + "</li>");
            out.println("<li>context path: " + contexPath + "</li>");
            out.println("<li>servlet path: " + servletPath + "</li>");
            out.println("<li>ip local: " + ip + "</li>");
            out.println("<li>ip cliente: " + ipCliente + "</li>");
            out.println("<li>puerto local: " + port + "</li>");
            out.println("<li>scheme: " + scheme + "</li>");
            out.println("<li>host: " + host + "</li>");
            out.println("<li>url: " + url + "</li>");
            out.println("<li>url2: " + url2 + "</li>");
            // Mostrando todas las cabeceras HTTP
            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String cabecera = headerNames.nextElement();
                out.println("<li>"+ cabecera + ": " + req.getHeader(cabecera) + "</li>");
            }
            out.println("</ul>");
            out.println(" </body>");
            out.println("</html>");
        }
    }
}