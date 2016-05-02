package by;

import java.io.IOException;
import java.sql.*;

public class MetadataCode {
	
	public void doing(){
		try {
			String tempsql="select id,dClassEncode from cfsdc_metadata";
			String fromCodeSql="select id from cfsdc_metadata_code where classEncode=?";
			String updateMetadataSql="update cfsdc_metadata set dClassNameId=? where id=?";
			PreparedStatement st1;
			PreparedStatement st2;
			PreparedStatement st3;
			ResultSet rs1;
			ResultSet rs2;
			Connection conn=Db.getConnection();
			try{
				st1=conn.prepareStatement(tempsql);
				st2=conn.prepareStatement(fromCodeSql);
				st3=conn.prepareStatement(updateMetadataSql);
				
				rs1=st1.executeQuery();
				while(rs1.next()){
					int id=rs1.getInt("id");
					String encode=rs1.getString("dClassEncode");
					
					System.out.println(id+"号元数据开始。其科学编码是："+encode);
					
					st2.setString(1, encode);
					rs2=st2.executeQuery();
					
					if(rs2.next()){
						String codeId;
						codeId=rs2.getString("id");
						System.out.println("科学编码对应的id是："+codeId);
						st3.setString(1, codeId);
						st3.setInt(2, id);
						st3.executeUpdate();
						
					}
				}
			}finally{
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		MetadataCode lm=new MetadataCode();
		//System.out.print(lm.isConnect());
		//lm.closeCon();
		lm.doing();
	}
}
