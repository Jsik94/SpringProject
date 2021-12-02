package com.kosmo.springapp.basic.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DatabaseController {
	
	@Resource(name="datasourceByJDBC")
	private DataSource jdbc;
	
	@Resource(name="datasourceByJNDI")
	private DataSource jndi;
	
	
	@RequestMapping("/database/JDBConnection.do")
	public String jdbc(Model model) throws SQLException {
		Connection con = jdbc.getConnection();
		model.addAttribute("message",con==null ? "연결실패하였습니다." : "연결이 성공하였습니다.");
		
		if(con !=null) {
			con.close();
		}
		return "chap07_database/Database";
	}
	
	@RequestMapping("/database/JNDIConnection.do")
	public String jndi(Model model) throws SQLException {
		//주입받은 DataSource객체로 Connection객체 얻기]
		Connection conn= jndi.getConnection();
		//데이타 저장]
		model.addAttribute("message", conn==null?"[데이타베이스 연결실패]":"[데이타베이스 연결성공]");
		//커넥션 풀에 객체 반납
		if(conn !=null) conn.close();
		//뷰정보 반환]
		return "chap07_database/Database";
	}
	
}
