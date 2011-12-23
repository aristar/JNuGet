package ru.aristar.jnuget;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.FileSystems;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sviridov
 */
public class MainRss extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            PackageInfoGenerator generator = new PackageInfoGenerator();
            SyndFeed feed = generator.makeFeed();
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/rss+xml");
            SyndFeedOutput output = new SyndFeedOutput();
            output.output(feed, response.getWriter());
            //TODO Заменить сервлет на RSS. Сама рассылка под ним в /Packages
           /*
             * <?xml version="1.0" encoding="windows-1251" standalone="yes"?>
            <service xml:base="Полный URL, куда должен быть задеполен сервлет" xmlns:atom="http://www.w3.org/2005/Atom" xmlns:app="http://www.w3.org/2007/app" xmlns="http://www.w3.org/2007/app">
            <workspace>
            <atom:title>Default</atom:title>
            <collection href="Packages">
            <atom:title>Packages</atom:title>
            </collection> Алекс
            </workspace>
            </service>
             */
            WritableByteChannel outputChannel = Channels.newChannel(response.getOutputStream());
            File file = new File("sdasdasdas");
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            channel.transferTo(0, channel.size(), outputChannel);

        } catch (FeedException e) {
            logger.error("Ошибка получения ленты RSS", e);
            throw new IOException(e);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
