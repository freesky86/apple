package com.freesky.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.freesky.bean.MyBean;
 
/**
 * @Author: geng
 * @Date: 2018/9/15
 */
@WebServlet("/test")
public class Servlet1 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Context initContext = new InitialContext();
            
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
//            DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/mysql");
            
            MyBean bean = (MyBean) envContext.lookup("bean/MyBeanFactory");

            System.out.println("foo = " + bean.getFoo() + ", bar = " +
                           bean.getBar());
            
            Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from person");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	System.out.println(rs.getString("name"));
            }
            rs.close();
            conn.close();
            
            resp.getWriter().write("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}