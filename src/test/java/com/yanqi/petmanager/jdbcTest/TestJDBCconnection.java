package com.yanqi.petmanager.jdbcTest ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCconnection {
    public static void main(String[] args) {
        // 4个参数
        String driverClass="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/mySchool";
        String user="root";
        String password="050325";

        // 3个SQL的接口
        Connection conn=null;
        Statement stmt=null;

        try {
            // 1、加载JDBC驱动
            Class.forName(driverClass);
            // 2、建立数据库连接
            conn=DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功！");
            // 3、生成StateMent接口对象
            stmt=conn.createStatement();
            // 4、利用StateMent接口执行SQL语句
            String sql="insert into `grade` (`gradeName`) values ('硕一')";
            // execute()：返回boolean,excuteUpdate()：返回指令影响的行数
            int result=stmt.executeUpdate(sql);
            // 5、根据返回信息进行进一步处理（增删改返回int)
            if(result>0) {
                System.out.println("年级信息增加成功！");
            }else {
                System.out.println("年级信息增加失败！");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
