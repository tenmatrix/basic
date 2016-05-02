package by;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXmlToTable {
	 public static String xmlFileStr="G:\\cfsdc\\resources\\treebase.xml";
	 
	 public static ArrayList <OrderInfoBean> getXML(String filename) throws DocumentException{
		 
			SAXReader reader = new SAXReader();
			
			Document document = reader.read(new File(filename));
			
			Element root = document.getRootElement();//<Nodes></Nodes>
			
			ArrayList <OrderInfoBean> nodes = new ArrayList<OrderInfoBean>();
			
			//遍历根节点内的每个节点，即每个<NodeInfo>
			for (Iterator it = root.elementIterator();it.hasNext();){
				
				Element element = (Element) it.next();
				
				//每一个Node用list里面一个元素存储
				OrderInfoBean onenode = new OrderInfoBean();
				
				for ( Iterator iterInner = element.elementIterator(); iterInner.hasNext(); ) {
					
					Element elementInner = (Element) iterInner.next();
					
					if (elementInner.getName().toLowerCase().equals("id")){
						if(elementInner.getText().equals("null")){
							onenode.setId(null);
						}else
						//onenode.setId(Integer.parseInt(elementInner.getText()));
						onenode.setId(elementInner.getText());
						
					}else if (elementInner.getName().toLowerCase().equals("title".toLowerCase())){
						if(elementInner.getText().equals("null")){
							onenode.setTitle(null);
						}else
						onenode.setTitle(elementInner.getText());
						
					}else if (elementInner.getName().toLowerCase().equals("depth".toLowerCase())){
						if(elementInner.getText().equals("null")){
							onenode.setDepth(null);
						}else
						//onenode.setDepth(Integer.valueOf(elementInner.getText()));
						onenode.setDepth(elementInner.getText());
						
					}else if (elementInner.getName().toLowerCase().equals("parentid".toLowerCase())){
						if(elementInner.getText().equals("null")){
							onenode.setParentid(null);
						}else
						//onenode.setParentid(Integer.valueOf(elementInner.getText()));
						onenode.setParentid(elementInner.getText());
						
					}else if (elementInner.getName().toLowerCase().equals("previousslibingid".toLowerCase())){
						if(elementInner.getText().equals("null")){
							onenode.setPreviousslibingid(null);
						}else
						//onenode.setPreviousslibingid(Integer.valueOf(elementInner.getText()));
						onenode.setPreviousslibingid(elementInner.getText());
						
					}else if (elementInner.getName().toLowerCase().equals("nextslibingid".toLowerCase())){
						if(elementInner.getText().equals("null")){
							onenode.setNextslibingid(null);
						}else
						//onenode.setNextslibingid(Integer.valueOf(elementInner.getText()));
						onenode.setNextslibingid(elementInner.getText());
						
					}else if (elementInner.getName().toLowerCase().equals("categoryid".toLowerCase())){
						if(elementInner.getText().equals("null")){
							onenode.setCategoryid(null);
						}else
						//onenode.setCategoryid(Integer.valueOf(elementInner.getText()));
						onenode.setCategoryid(elementInner.getText());
					}
				}
				nodes.add(onenode);
			}
			return nodes;
		}
	 
	 public  static void toDb() throws SQLException, IOException, DocumentException{
		 System.out.println("start");
		 Connection conn=Db.getConnection();
		 String createSql="CREATE TABLE `orderinfo` (  " +
		 		"`id` varchar(255) DEFAULT NULL,  " +
		 		"`title` varchar(255) DEFAULT NULL,  " +
		 		"`depth` varchar(255) DEFAULT NULL,  " +
		 		"`parentid` varchar(255) DEFAULT NULL,  " +
		 		"`previousslibingid` varchar(255) DEFAULT NULL,  " +
		 		"`nextslibingid` varchar(255) DEFAULT NULL,  " +
		 		"`categoryid` varchar(255) DEFAULT NULL" +
		 		") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
		 Statement st1=conn.createStatement();
		 st1.executeUpdate("drop table if EXISTS orderinfo");
		 st1.executeUpdate(createSql);
		 
		 String sql="insert into orderinfo(id,title,depth,parentid,previousslibingid,nextslibingid,categoryid)" +
		 			" values(?,?,?,?,?,?,?)";
		 PreparedStatement st=conn.prepareStatement(sql);
		 List<OrderInfoBean> nodes=getXML(xmlFileStr);
		 for(OrderInfoBean record:nodes){
			 System.out.println(record.getId());
			 st.setString(1, toString(record.getId()));
			 st.setString(2, toString(record.getTitle()));
			 st.setString(3, toString(record.getDepth()));
			 st.setString(4, toString(record.getParentid()));
			 st.setString(5, toString(record.getPreviousslibingid()));
			 st.setString(6, toString(record.getNextslibingid()));
			 st.setString(7, toString(record.getCategoryid()));
			 st.addBatch();
		 }
		 st.executeBatch();
		 conn.close();
		 System.out.println("end");
	 }
	 private static String toString(Object obj){
		 if(obj==null)
			 return null;
		 else
			 return obj.toString();
	 }
	 public static void main(String[] args)
	   {
		 try {
//			toDb();
			order();System.out.println(orderlist.size());
			update();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		catch (DocumentException e) {
//			e.printStackTrace();
//		}//System.out.println(Db.testConnection());
	   }
	 static int orderId=0;
	 static List<String> orderlist=new ArrayList<String>();
	 public static void order() throws NumberFormatException, SQLException, IOException{
		 Connection conn=Db.getConnection();
		 String eight="select id from orderinfo where categoryid=? and depth=1";
		 for(int i=1;i<9;i++){
			 PreparedStatement st=conn.prepareStatement(eight);
			 st.setInt(1, i);
			 ResultSet rs=st.executeQuery();
			 while(rs.next()){
				System.out.println("第"+i+"类根:"+Integer.valueOf(rs.getString(1)));
				orderlist.add(rs.getString("id"));
				int id=Integer.valueOf(rs.getString("id"));
			 	retrieve(conn,id);
			 }
		 }
		 conn.close();
	 }
	 private static void retrieve(Connection conn,int rootId) throws SQLException{
		 String sql="select * from orderinfo where parentid=?";
		 PreparedStatement st=conn.prepareStatement(sql);
		 st.setInt(1, rootId);
		 ResultSet rs=st.executeQuery();
//		 List<OrderInfoBean> slibings=new ArrayList<OrderInfoBean>();
//		 while(rs.next()){
//			 OrderInfoBean one=new OrderInfoBean();
//			 one.setId(rs.getString("id"));
//			 one.setTitle(rs.getString("title"));
//			 one.setDepth(rs.getString("depth"));
//			 one.setParentid(rs.getString("parentid"));
//			 one.setNextslibingid(rs.getString("nextslibingid"));
//			 one.setPreviousslibingid(rs.getString("previousslibingid"));
//			 one.setCategoryid(rs.getString("categoryid"));
//			 slibings.add(one);
//		 }
//		 rs.close();
//		 st.close();
//		 for(OrderInfoBean)
		 String firstid=null;
		 String nextid=null;
		 int currentrow;
		 while(rs.next()){
			 if(rs.getString("previousslibingid")==null){
				 firstid=rs.getString("id");
				 orderlist.add(firstid);//System.out.println("第一个节点:"+firstid);
				 nextid=rs.getString("nextslibingid");
				 break;
			 }else{
				 continue;
			 }
		 }
		 getNextSliId(nextid,rs);
		 //System.out.println(orderlist.toString());
		 
		 List<String> slibings=new ArrayList<String>();
		 rs.beforeFirst();
		 while(rs.next()){
			 slibings.add(rs.getString("id"));
		 }
		 st.close();
		 for(String id:slibings){
			 retrieve(conn,Integer.valueOf(id));
		 }
	 }
	 private static void getNextSliId(String nextid,ResultSet rs) throws SQLException{
		 if(nextid!=null){//System.out.println("?");
			 orderlist.add(nextid);
			 String firstid=nextid;
			// String nextid=
			 rs.beforeFirst();
			 while(rs.next()){
				 String id=rs.getString("id");
				 if(id!=null && id.equals(firstid)){
					 nextid=rs.getString("nextslibingid");
					 //orderlist.add(nextid);
					 getNextSliId(nextid,rs);
					 break;
				 }
			 }
		 }
	 }
	 
	 
	 public static void update() throws SQLException, IOException{System.out.println("开始更新");
		 Connection conn=Db.getConnection();
		 String sql="update cfsdc_resource_class_web set resourceClassOrder=? where id=?";
		 PreparedStatement st=conn.prepareStatement(sql);
		 int i=1;
		 for(String id:orderlist){
			 i=i+1;
			 st.setInt(1, i);
			 st.setInt(2, Integer.valueOf(id));
			 st.addBatch();
		 }
		 st.executeBatch();
		 conn.close();
		 System.out.println("end");
	 }
}
