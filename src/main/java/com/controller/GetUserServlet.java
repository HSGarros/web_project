package com.controller;

import com.entity.User;
import com.util.DataSourceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/query")
public class GetUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=null;
        String sql="select * from user where id=?";
        try (Connection conn=DataSourceUtils.getConnection();
             PreparedStatement st=conn.prepareStatement(sql)) {
            st.setString(1,req.getParameter("id"));
            try (ResultSet rs = st.executeQuery()){
                rs.next();
                user=new User(rs.getInt(1), rs.getString(2),rs.getTimestamp(3));
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("user",user);
        req.getRequestDispatcher("/WEB-INF/jsp/query.jsp")
                .forward(req,resp);
    }
}
