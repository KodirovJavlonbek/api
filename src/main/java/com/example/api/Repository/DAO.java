package com.example.api.Repository;

import com.nexacro.java.xapi.tx.HttpPlatformRequest;
import com.nexacro.java.xapi.tx.HttpPlatformResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface DAO<T> {
    List<T> list();
    void  create(T t);

    Optional<T> get(int id);
    void update(T t, int id);
    void delete(int id);
    String sql(String sql) throws SQLException, NamingException;
    void todo(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
