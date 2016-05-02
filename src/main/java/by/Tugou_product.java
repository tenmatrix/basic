package by;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 从progresql倒到mysql
 * @author Administrator
 *
 */
public class Tugou_product {
	Connection conn;
	Connection mysqlConn;
	String sql1="insert into product1 set `uri`=?,`name`=?,`cat_name`=?,`specific`=?,`description`=?,`reviews`=?";
	String sql2 = "SELECT uri,name,cat_name,specific,description,reviews FROM public.product ORDER BY uri limit ? OFFSET ?;";
	String sql3="select count(*) from public.product";
	class Product{
		String uri;
		String name;
		String cat_name;
		String specific;
		String description;
		String reviews;
	}
	Tugou_product() throws SQLException, IOException, ClassNotFoundException{
		this.init();
	}
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException{
		Tugou_product me=new Tugou_product();
		me.doing();
		System.out.println("finished");
	}
	private void init() throws SQLException, IOException, ClassNotFoundException{
		conn=Db.getConnection();
		String drivers = "com.mysql.jdbc.Driver";
		Class.forName(drivers);
		String url = "jdbc:mysql://localhost:3306/tugou?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "root";

		mysqlConn= DriverManager.getConnection(url, username, password);
		System.out.println("初始化完成");
	}
//	private void single(){
//		String sql1="SELECT uri,name,cat_name,specific,description,reviews FROM public.produc";
//		String sql2="insert into product set `uri`=?,`name`=?,`cat_name`=?,`specific`=?,`description`=?,`reviews`=?";
//		try {
//			try {
//
//			} finally {
//
//			}
//		} catch (Exception e) {
//
//		}
//	}
	private void doing() throws SQLException{
		int amount=10000;
		int total=gotTotalAmount();
		//如果没记录，就不处理
		if(total<=0){
			return;
		}
		//结束号
		int endNum=total-1;
		//开始号
		int startNum=920000;
		System.out.println("总个数："+total+" 开始编号:"+startNum+" 结束编号:"+endNum+" 获取数量:"+amount);
		int tempamount=amount;
		
		while(startNum<=endNum){
			//如果开始编号+获取数量大于等于结束编号，那么需要重新计算amount
			if(startNum+amount>endNum){
				tempamount=endNum-startNum+1;
			}
			System.out.println("limit "+startNum+","+tempamount);
			
			
			//获取记录，包装成entity
			//取得spec的商品名称段
			//将cat部分中，与商品名称相等的部分替换为""
			//解析cat剩下的部分
			//插入brand表
			transfer(startNum,amount);
			
			tempamount=amount;
			
			startNum=startNum+amount;System.out.println(startNum);
		}
		this.destroy();
	}
	private void destroy() throws SQLException{
		if(conn!=null)this.conn.close();
		if(mysqlConn!=null)this.mysqlConn.close();
	}
	private void transfer(int start, int amount){
		List<Product> result =this.gotOrigin(start, amount);
		this.insertToMysql(result);
		result.clear();
		result=null;
		System.gc();
		
	}
	private void insertToMysql(List<Product> products){
		try {
			
			PreparedStatement ps = null;
			try {
				ps = this.mysqlConn.prepareStatement(sql1);
				for(Product one:products){
					ps.clearParameters();
					ps.setString(1, one.uri);
					ps.setString(2, one.name);
					ps.setString(3, one.cat_name);
					ps.setString(4, one.specific);
					ps.setString(5, one.description);
					ps.setString(6, one.reviews);
					
					ps.addBatch();
				}System.out.println("批量添加");
				ps.executeBatch();

			} finally {
				if (ps != null)
				{ps.close();ps=null;}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private List<Product> gotOrigin(int start, int amount) {
		List<Product> result = new ArrayList<Product>();
		
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, amount);
				ps.setInt(2, start);

				rs = ps.executeQuery();

				while (rs.next()) {
					Product product = new Product();
					product.uri=rs.getString("uri");
					product.name=rs.getString("name");
					product.cat_name=rs.getString("cat_name");
					product.specific=rs.getString("specific");
					product.description=rs.getString("description");
					product.reviews=rs.getString("reviews");
					result.add(product);
				}
			} finally {
				if (ps != null)
					{ps.close();ps=null;}
				if (rs != null)
					{rs.close();rs=null;}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	private int gotTotalAmount(){
		int result=0;
		try{
			
			PreparedStatement ps=null;
			ResultSet rs=null;
			try{
				ps=conn.prepareStatement(sql3);
				rs=ps.executeQuery();
				if(rs.next()){
					result=rs.getInt(1);
				}
			}finally{
				if(rs!=null)
					{rs.close();rs=null;}
				if(ps!=null)
					{ps.close();ps=null;}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
