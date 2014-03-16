package com.peopledb.servlet;

import com.peopledb.entity.Person;
import com.peopledb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Oleg on 16.03.14.
 */
@Configuration
public class IndexServlet extends HttpServlet {
    @Autowired
    private PersonService personService;

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        List<Person> pList = personService.findAllPersons();
        for(Person p:pList)
            out.println(p.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        personService.createPerson(request.getParameter("name"));
        PrintWriter out=response.getWriter();
        List<Person> pList = personService.findAllPersons();
        for(Person p:pList)
            out.println(p.toString());
    }
}
