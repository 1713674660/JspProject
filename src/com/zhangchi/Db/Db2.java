package com.zhangchi.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zhangchi.DbUtil.DbUtil;
import com.zhangchi.model.Student;

public class Db2 {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	/**
	 * 根据用户名进行模糊查询
	 * @param name
	 * @return
	 */
	public List<Student> likeQuery(String name,int index,int end){
		List<Student> list=new ArrayList<Student>();
		con=DbUtil.getConnection();
		String sql="select * from student where name like ? limit ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ps.setInt(2, (index-1)*end);
			ps.setInt(3, end);
			rs=ps.executeQuery();
			while(rs.next()){
				Student stu=new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setPassword(rs.getString("password"));
				stu.setSex(rs.getString("sex"));
				stu.setAge(rs.getInt("age"));
				stu.setPhone(rs.getString("phone"));
				stu.setAddress(rs.getString("address"));
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);
		return list;	
	}
	
	public int likeCount(String name){
		List<Student> list=new ArrayList<Student>();
		con=DbUtil.getConnection();
		String sql="select * from student where name like ?";
		int num=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs=ps.executeQuery();
			while(rs.next()){
				num=num+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);
		return num;	
	}
	
}
