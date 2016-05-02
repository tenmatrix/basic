package by;

import java.sql.*;

public class LinkMetadata {

	public static String driver = "com.mysql.jdbc.Driver";
	public static String jdbc_url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
	public static String user = "root";
	public static String pwd = "root";
	private Connection con;
	LinkMetadata(){
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(jdbc_url, user, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doing(){
		String tempsql="select * from temp";
		Statement st;
		ResultSet rs;
		try {
			String insertsql="insert into cfsdc_metadata_check (" +
					"metadataid," +
					"name," +
					"inputUserId," +
					"checkStatus," +
					//"checkTime," +
					"checkUserId," +
					"delStatus," +
					//"delTime," +
					//"delUserId," +
					"xmlflag," +
					"onlineflag," +
					"xmlflag2," +
					"inputTime" +
					")values(" +
					"?,?,?,?,?,?,?,?,?,?" +
					")";
			
			PreparedStatement ps=con.prepareStatement(insertsql);
			//con.setAutoCommit(false);
			st = con.createStatement();
			rs=st.executeQuery(tempsql);
			//standardName
			while(rs.next()){
				ps.clearParameters();
				
				int metadataId=rs.getInt("id");//元数据id
				String username=rs.getString("username");//提交它的用户名
				int verify=rs.getInt("verify");//审核状态。注意与新库的状态码不一致。0,2互换
				String verifyusername=rs.getString("verifyusername");//审核人
				int xmlflag=rs.getInt("xmlflag");
				int onlineflag=rs.getInt("onlineflag");
				int xmlflag2=rs.getInt("xmlflag2");

				System.out.println(metadataId+","+username+","+verify+","+verifyusername+","+xmlflag+","+onlineflag+","+xmlflag2);
				
				//从test/cfsdc_metadata获得元数据标准名称，输入日期
				String metaName=null;
				String inputtime=null;
				String getmetanamesql="select dName,createdTime from cfsdc_metadata where id=?";
				PreparedStatement ps1=con.prepareStatement(getmetanamesql);
				ps1.setInt(1, metadataId);
				ResultSet rs1=ps1.executeQuery();
				if(rs1.next()){
					metaName=rs1.getString("dName");
					inputtime=rs1.getString("createdTime");
				}
				
				
				
				
				//依据用户登录名，从test/cfsdc_user_info获得用户的id号
				Integer userId=null;
				Integer verifyUserId=null;
				String usersql="select userid from cfsdc_user_info where userLoginName=?";
				PreparedStatement ps2=con.prepareStatement(usersql);
				ps2.setString(1,username);
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next()){
					userId=rs2.getInt("userid");
				}
				
				ps2.clearParameters();
				ps2.setString(1, verifyusername);
				rs2=ps2.executeQuery();
				if(rs2.next()){
					verifyUserId=rs2.getInt("userid");
				}
				
				
				
				
				//审核状态
				//1-审核通过；0-审核未通过；2-审核进行中
				//与原始库不同1：已审核；0：请审核；2：审核未通过；
				Integer checkStatus=null;
				switch(verify){
				case 0:{checkStatus=2;break;}
				case 1:{checkStatus=1;break;}
				case 2:{checkStatus=0;break;}
				}
				
				
				//删除状态（1-元数据被删除；0-元数据未被删除）
				Integer delStatus=0;
				 

				
				
				ps.setInt(1, metadataId);
				ps.setString(2, metaName);
				if(userId==null){
					ps.setNull(3, java.sql.Types.NULL);
				}else
					ps.setInt(3, userId);
				
				ps.setInt(4, checkStatus);
				if(verifyUserId==null){
					ps.setNull(5, java.sql.Types.NULL);
				}else
					ps.setInt(5, verifyUserId);
				
				ps.setInt(6, delStatus);
				ps.setInt(7, xmlflag);
				ps.setInt(8, onlineflag);
				ps.setInt(9, xmlflag2);
				
				ps.setString(10,inputtime);
				
				ps.executeUpdate();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public boolean isConnect(){
		if(con!=null){
			try {
				return con.isValid(0);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public void closeCon(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		LinkMetadata lm=new LinkMetadata();
		//System.out.print(lm.isConnect());
		//lm.closeCon();
		lm.doing();
	}
}
