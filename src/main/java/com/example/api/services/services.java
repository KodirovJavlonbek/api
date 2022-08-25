package com.example.api.services;

import com.example.api.Repository.DAO;
import com.example.api.dto.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class services {


    public final DAO dao;  //DI



    @GetMapping("/list")
    public void  listing()
    {

        List<Course> lists = dao.list();
        lists.forEach( System.out::println);

    }
    @GetMapping("/ExecSQL")
    public String sql(@RequestParam(value = "sql") String sql) throws SQLException, NamingException {
    return  dao.sql(sql);
    }
    /*
    @GetMapping("/todo")
    public   void todo1(HttpServletRequest  request, HttpServletResponse response) throws Exception {

        dao.todo(request,response);
    }*/

    @PostMapping("/todo")
    public   void todo2(HttpServletRequest  request, HttpServletResponse response) throws Exception {

        dao.todo(request,response);
    }

}

