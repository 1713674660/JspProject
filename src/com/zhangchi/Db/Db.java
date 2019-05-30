package com.zhangchi.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhangchi.DbUtil.DbUtil;
import com.zhangchi.model.Student;
import com.zhangchi.model.User;

public class Db {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * 注册用户
	 * @param u
	 * @return
	 */
	public int insert(User u){
		con=DbUtil.getConnection();
		String sql="insert into user(name,password) values(?,?)";
		int num=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			num=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);

		Connection con2=DbUtil.getConnection();
		String sql2="update user set password=md5(?) where name=?";
		PreparedStatement ps2=null;
		try {
			ps2=con2.prepareStatement(sql2);
			ps2.setString(1, u.getPassword());
			ps2.setString(2,u.getName());
			ps2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con2, ps2, rs);		
		return num;
	}
	
	/**
	 * user表判断用户是否已存在
	 * @param name
	 * @return
	 */
	public int find(String name,String password){
		con=DbUtil.getConnection();
		String sql="select count(*) as num from user where name=? and password=?";
		int num=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()){
				num=rs.getInt("num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);
		return num;
	}
	
	/**
	 * student表判断用户是否已存在
	 * @param name
	 * @param password
	 * @return
	 */
	public int findStudent(String name,String password){
		con=DbUtil.getConnection();
		String sql="select count(*) as num from student where name=? and password=?";
		int num=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()){
				num=rs.getInt("num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);
		return num;
	}
	
	/**
	 * 登录
	 * @param u
	 * @return
	 */
	public int loginSelect(User u){
		con=DbUtil.getConnection();
		String sql="select count(*) as num from user where name=? and password=md5(?)";
		int num=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			rs=ps.executeQuery();
			while(rs.next()){
				num=rs.getInt("num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);
		return num;
	}
	
	/**
	 * 分页查询
	 * @param index
	 * @param end
	 * @return
	 */
	public List<Student> queryLimit(int index,int end){
		//System.out.println(index);
		List<Student> list=new ArrayList<Student>();
		con=DbUtil.getConnection();
		String sql="select * from student limit ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (index-1)*end);
			ps.setInt(2, end);
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
	
	/**
	 * 查询记录总条数，用以判断页面该分几页
	 * @return
	 */
	public int getCount(){
		con=DbUtil.getConnection();
		String sql="select count(*) as count from student";
		int count=0;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);
		return count;
	}
	
	/**
	 * 增
	 * @param s
	 */
	public int create(Student s){
		con=DbUtil.getConnection();
		String sql="insert into student(name,password,sex,age,phone,address) values(?,?,?,?,?,?)";
		int num=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,s.getName());
			ps.setString(2, s.getPassword());
			ps.setString(3, s.getSex());
			ps.setInt(4, s.getAge());
			ps.setString(5,s.getPhone());
			ps.setString(6,s.getAddress());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);
		return num;
	}
	
	/**
	 * 删
	 * @param id
	 */
	public int delete(int id){
		con=DbUtil.getConnection();
		String sql="delete from student where id=?";
		int num=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			num=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);
		return num;
	}
	
	/**
	 * 改
	 * @param s
	 */
	public int update(Student s){
		con=DbUtil.getConnection();
		String sql="update student set password=?,sex=?,age=?,phone=?,address=? where id=?";
		int num=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, s.getPassword());
			ps.setString(2, s.getSex());
			ps.setInt(3, s.getAge());
			ps.setString(4, s.getPhone());
			ps.setString(5, s.getAddress());
			ps.setInt(6, s.getId());
			num=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);
		return num;
	}
	
	
	/**
	 * 根据id号查询
	 * @param id
	 * @return
	 */
	public Student findOne(int id){
		Student s=new Student();
		con=DbUtil.getConnection();
		String sql="select * from student where id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPassword(rs.getString("password"));
				s.setSex(rs.getString("sex"));
				s.setAge(rs.getInt("age"));
				s.setPhone(rs.getString("phone"));
				s.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);
		return s;
	}
	
	/**
	 * 查
	 * @return
	 */
	public List<Student> findAll(){
		
		List<Student> list=new ArrayList<Student>();
		
		con=DbUtil.getConnection();
		String sql="select * from Student";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPassword(rs.getString("password"));
				s.setSex(rs.getString("sex"));
				s.setAge(rs.getInt("age"));
				s.setPhone(rs.getString("phone"));
				s.setAddress(rs.getString("address"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.close(con, ps, rs);
		return list;
	}
}
