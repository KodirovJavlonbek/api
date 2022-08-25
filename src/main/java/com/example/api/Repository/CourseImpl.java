package com.example.api.Repository;

import com.example.api.dto.Course;
import jdk.nashorn.internal.runtime.JSONFunctions;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

import com.nexacro.java.xapi.data.*;
import com.nexacro.java.xapi.tx.*;

@Repository
@RequiredArgsConstructor
public class CourseImpl implements  DAO<Course> {

    private final JdbcTemplate jdbcTemplate;
    private final DataSource ds;

    public Connection con;
    public Statement stmt;
    public ResultSet rs;
    public ResultSetMetaData rsmd;
    public int sqlcode = 0;
    public String sqlerr = "";

    private static final Logger log  =  LoggerFactory.getLogger(Course.class);


    @Override
    public List<Course> list() {
        String sql = "select * from course ";
        return jdbcTemplate.query(sql,(rs,rowNum) -> {
            Course  course  = new Course();
            course.setCourseId(rs.getInt("COURSE_ID"));
            course.setTitle(rs.getString("TITLE"));
            course.setDescription(rs.getString("DESCRIPTION"));
            course.setLink(rs.getString("LINK"));
            return course;
        });
    }

    @Override
    public void create(Course course) {

    }


    @Override
    public Optional get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Course course, int id) {

    }


    @Override
    public void delete(int id) {

    }


    @Override
    public String sql(String sql) throws SQLException {
        Timestamp   now = new Timestamp(System.currentTimeMillis() );

        System.out.println(now  + " ExecSQL  from client " + sql );

        SqlRowSet  rs =  jdbcTemplate.queryForRowSet(sql);

        JSONArray lists = new JSONArray();
        JSONObject fld = null;
        while (rs.next()) {
            fld = new JSONObject();
            ;
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                fld.put(rs.getMetaData().getColumnName(i), rs.getString(i));
                System.out.println(rs.getString(i));
            }
            lists.put(fld);
        }

        return lists.toString();
    }
    public String rsGet(ResultSet rs, String id) throws Exception
    {
        if( rs.getString(id) == null )
        {
            return "";
        } else {
            return rs.getString(id);
        }
    }
    public DataSet Rs2Ds(ResultSet rs, String ds_id) throws Exception
    {
        int i;
        int col_cnt;
        String col_name;

        DataSet ds = new DataSet(ds_id);
        ResultSetMetaData rsmd = rs.getMetaData();

        col_cnt = rsmd.getColumnCount();
        for( i = 1 ; i <= col_cnt ; i++ )
        {
            col_name = rsmd.getColumnName(i).toUpperCase();
            ds.addColumn(col_name, DataTypes.STRING, (short)rsmd.getColumnDisplaySize(i));
        }
        while(rs.next())
        {
            int row = ds.newRow();
            for( i = 1 ; i <= col_cnt ; i++ )
            {
                col_name = rsmd.getColumnName(i).toUpperCase();
                ds.set(row, col_name, rsGet(rs, col_name));
            }
        }
        return ds;
    }

    @Override
     public void todo(HttpServletRequest  request , HttpServletResponse response) throws Exception {
       // Client To Server Get Argument
        HttpPlatformRequest  req = new HttpPlatformRequest(request);
        req.receiveData();
        PlatformData  rcvData = req.getData();
        System.out.println("DataSet Count = " +rcvData.getDataSetCount());

        VariableList varList  = rcvData.getVariableList();
        String encsql  =  varList.getString("sql");
        String sql      = new String(Base64.getDecoder().decode(encsql));
        System.out.println("sql = " + sql);

        // Client To Server  Data DUMP

        if (rcvData.getDataSetCount() > 0){
            DataSet nexaDs  = rcvData.getDataSet(0);
            System.out.println("ds  = " + nexaDs.getName());
            for (int i=0;i< nexaDs.getRowCount(); i++)
            {
                if (nexaDs.getRowType(i) == DataSet.ROW_TYPE_DELETED)  System.out.println("DataStatus = DELETED");
                if (nexaDs.getRowType(i) == DataSet.ROW_TYPE_INSERTED) System.out.println("DataStatus = INSERTED");
                if (nexaDs.getRowType(i) == DataSet.ROW_TYPE_UPDATED)  System.out.println("DataStatus = UPDATED");
                for (int j=0; j<nexaDs.getColumnCount();j++)
                    System.out.println( nexaDs.getColumn(j).getName() + "  =   "  + nexaDs.getString(i,j) );
            }

        }



        con = ds.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        rsmd = rs.getMetaData();

        // Send To Clinet
        PlatformData o_xpData = new PlatformData();
        o_xpData.addDataSet(Rs2Ds(rs,"fromServer"));
        HttpPlatformResponse pRes = new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML, "UTF-8");
        pRes.setData(o_xpData);
        pRes.sendData();
        //return "toclient";


    }




}

