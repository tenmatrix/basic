package by;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
//中国海洋微生物菌种保藏管理中心 MCCC
public class JZ {
	
	public static void a() throws Exception{
		Connection conn=Db.getConnection();
		String sql="select " +
				"i.平台资源号 as 'ptzyh'," +
				"i.菌株保藏编号 as 'bcbh'," +
				"i.中文名称 as 'jzm'," +
				"i.属名 as 'sm'," +
				"i.种名加词 as 'zmjc'," +
				"i.其他保藏中心编号 as 'qtzxbh'," +
				"i.来源历史 as 'lyls'," +
				"i.收藏时间 as 'scsj'," +
				"i.原始编号 as 'ysbh'," +
				"i.原产国 as 'ycg'," +
				"i.资源归类编码 as 'glbm'," +
				"i.模式菌株 as 'msjz'," +
				"i.主要用途 as 'zyyt'," +
				"i.特征特性 as 'jctztx'," +
				"i.具体用途 as 'jtyt'," +
				"i.生物危害程度 as 'swwxdj'," +
				"i.寄主名称 as 'jzzwmc'," +
				"i.致病对象	as 'zbdx'," +
				"i.致病名称	as 'zbmc'," +
				"i.传播途径	as 'cbtj'," +
				"i.分离基物	as 'fljw'," +
				"i.采集地 as 'cjjtdd'," +
				"i.培养基编号 as 'pyjbh'," +
				"i.培养温度	as 'pywd'," +
				"i.基因元器件 as 'jyyqj'," +
				"i.记录地址 as 'url'," +
				"i.图像 as 'xwxt'," +
				"i.机构名称	as 'jgmc'," +
				"i.机构名称缩写	as 'jgmcsx'," +
				"i.隶属单位名称	as 'lsdwmc'," +
				"i.资源保藏类型	as 'zybclx'," +
				"i.保存方法	as 'bcff'," +
				"i.实物状态	as 'swzt'," +
				"i.共享方式	as 'gxfs'," +
				"i.提供形式	as 'tgxs'," +
				"i.获取途径	as 'hqtj'," +
				"i.联系方式	as 'lxfs'," +
				"m.关键字 as 'gjc'," +
				"m.描述 as 'xtms'," +
				"m.最近修改日期 as 'xgrq'," +
				"m.资源类目名称 as 'zylmmc'," +
				//"m.资源归类编码 as 'glbm'," +
				"m.资源分类版本号 as 'zyflbbh'," +
				"m.资源分类标准名称 as 'zyflbzmc'," +
				"m.访问控制 as 'aqfwkz' " +
				"from hy_info as i,hy_meta as m where i.平台资源号=m.平台资源号";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		String insertSql="insert into cdcm_resource_home_bk " +
				"(ptzyh,bcbh,jzm,sm,zmjc,qtzxbh,lyls,scsj,ysbh,ycg,glbm,msjz,zyyt,jctztx,jtyt,swwxdj,jzzwmc,zbdx,zbmc,cbtj,fljw,cjjtdd,pyjbh,pywd,jyyqj,url,xwxt,jgmc,jgmcsx,lsdwmc,zybclx,bcff,swzt,gxfs,tgxs,hqtj,lxfs,gjc,xtms,xgrq,zylmmc,zyflbbh,zyflbzmc,aqfwkz) " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement insertSt=conn.prepareStatement(insertSql);
		
		String updateSql="update cdcm_resource_home set " +
				"bcbh=?,jzm=?,sm=?,zmjc=?,qtzxbh=?,lyls=?,scsj=?,ysbh=?,ycg=?,glbm=?,msjz=?,zyyt=?,jctztx=?,jtyt=?,swwxdj=?,jzzwmc=?,zbdx=?,zbmc=?,cbtj=?,fljw=?,cjjtdd=?,pyjbh=?,pywd=?,jyyqj=?,url=?,xwxt=?,jgmc=?,jgmcsx=?,lsdwmc=?,zybclx=?,bcff=?,swzt=?,gxfs=?,tgxs=?,hqtj=?,lxfs=?,gjc=?,xtms=?,xgrq=?,zylmmc=?,zyflbbh=?,zyflbzmc=?,aqfwkz=? " +
				"where ptzyh=?";
		PreparedStatement updateSt=conn.prepareStatement(updateSql);
		
		String hasSql="select count(*) from cdcm_resource_home_bk where ptzyh=?";
		PreparedStatement exist=conn.prepareStatement(hasSql);
		while(rs.next()){
			String ptzyh=rs.getString("ptzyh");
			
			exist.setString(1, ptzyh);
			ResultSet exitstRs=exist.executeQuery();
			exitstRs.next();
			int has=0;
			has=exitstRs.getInt(1);
			if(has==0){//没有.所以插入
				insertSt.setString(1, ptzyh);
				insertSt.setString(2, rs.getString("bcbh"));
				insertSt.setString(3, rs.getString("jzm"));
				insertSt.setString(4, rs.getString("sm"));
				insertSt.setString(5, rs.getString("zmjc"));
				insertSt.setString(6, rs.getString("qtzxbh"));
				insertSt.setString(7, rs.getString("lyls"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				insertSt.setString(8, sdf.format(rs.getDate("scsj")).toString());
				insertSt.setString(9, rs.getString("ysbh"));
				insertSt.setString(10, rs.getString("ycg"));
				insertSt.setString(11, rs.getString("glbm"));
				insertSt.setString(12, rs.getString("msjz"));
				insertSt.setString(13, rs.getString("zyyt"));
				insertSt.setString(14, rs.getString("jctztx"));
				insertSt.setString(15, rs.getString("jtyt"));
				insertSt.setString(16, rs.getString("swwxdj"));
				insertSt.setString(17, rs.getString("jzzwmc"));
				insertSt.setString(18, rs.getString("zbdx"));
				insertSt.setString(19, rs.getString("zbmc"));
				insertSt.setString(20, rs.getString("cbtj"));
				insertSt.setString(21, rs.getString("fljw"));
				insertSt.setString(22, rs.getString("cjjtdd"));
				insertSt.setString(23, rs.getString("pyjbh"));
				insertSt.setString(24, rs.getString("pywd"));
				insertSt.setString(25, rs.getString("jyyqj"));
				insertSt.setString(26, rs.getString("url"));
				insertSt.setString(27, rs.getString("xwxt"));
				insertSt.setString(28, rs.getString("jgmc"));
				insertSt.setString(29, rs.getString("jgmcsx"));
				insertSt.setString(30, rs.getString("lsdwmc"));
				insertSt.setString(31, rs.getString("zybclx"));
				insertSt.setString(32,rs.getString("bcff") );
				insertSt.setString(33,rs.getString("swzt") );
				insertSt.setString(34, rs.getString("gxfs"));
				insertSt.setString(35, rs.getString("tgxs"));
				insertSt.setString(36, rs.getString("hqtj"));
				insertSt.setString(37, rs.getString("lxfs"));
				insertSt.setString(38, rs.getString("gjc"));
				insertSt.setString(39, rs.getString("xtms"));
				insertSt.setString(40, sdf.format(rs.getDate("xgrq")).toString());
				insertSt.setString(41, rs.getString("zylmmc"));
				//insertSt.setString(42, rs.getString("glbm"));
				insertSt.setString(42, rs.getString("zyflbbh"));
				insertSt.setString(43, rs.getString("zyflbzmc"));
				insertSt.setString(44, rs.getString("aqfwkz"));
				
				insertSt.addBatch();
				
			}else if(has==1){//有,所以修改
				updateSt.setString(1, rs.getString("bcbh"));
				updateSt.setString(2, rs.getString("jzm"));
				updateSt.setString(3, rs.getString("sm"));
				updateSt.setString(4, rs.getString("zmjc"));
				updateSt.setString(5, rs.getString("qtzxbh"));
				updateSt.setString(6, rs.getString("lyls"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				updateSt.setString(7, sdf.format(rs.getDate("scsj")).toString());
				updateSt.setString(8, rs.getString("ysbh"));
				updateSt.setString(9, rs.getString("ycg"));
				updateSt.setString(10, rs.getString("glbm"));
				updateSt.setString(11, rs.getString("msjz"));
				updateSt.setString(12, rs.getString("zyyt"));
				updateSt.setString(13, rs.getString("jctztx"));
				updateSt.setString(14, rs.getString("jtyt"));
				updateSt.setString(15, rs.getString("swwxdj"));
				updateSt.setString(16, rs.getString("jzzwmc"));
				updateSt.setString(17, rs.getString("zbdx"));
				updateSt.setString(18, rs.getString("zbmc"));
				updateSt.setString(19, rs.getString("cbtj"));
				updateSt.setString(20, rs.getString("fljw"));
				updateSt.setString(21, rs.getString("cjjtdd"));
				updateSt.setString(22, rs.getString("pyjbh"));
				updateSt.setString(23, rs.getString("pywd"));
				updateSt.setString(24, rs.getString("jyyqj"));
				updateSt.setString(25, rs.getString("url"));
				updateSt.setString(26, rs.getString("xwxt"));
				updateSt.setString(27, rs.getString("jgmc"));
				updateSt.setString(28, rs.getString("jgmcsx"));
				updateSt.setString(29, rs.getString("lsdwmc"));
				updateSt.setString(30, rs.getString("zybclx"));
				updateSt.setString(31,rs.getString("bcff") );
				updateSt.setString(32,rs.getString("swzt") );
				updateSt.setString(33, rs.getString("gxfs"));
				updateSt.setString(34, rs.getString("tgxs"));
				updateSt.setString(35, rs.getString("hqtj"));
				updateSt.setString(36, rs.getString("lxfs"));
				updateSt.setString(37, rs.getString("gjc"));
				updateSt.setString(38, rs.getString("xtms"));
				updateSt.setString(39, sdf.format(rs.getDate("xgrq")).toString());
				updateSt.setString(40, rs.getString("zylmmc"));
				//updateSt.setString(41, rs.getString("glbm"));
				updateSt.setString(41, rs.getString("zyflbbh"));
				updateSt.setString(42, rs.getString("zyflbzmc"));
				updateSt.setString(43, rs.getString("aqfwkz"));
				updateSt.setString(44, ptzyh);
			}else{
				throw new Exception("错误记录数");
			}
		}
		//rs.last();
		//System.out.println(rs.getRow());
		insertSt.executeBatch();
		conn.close();
		
	}
	public static void main(String[] args)
	   {
		 try {
			//toDb();
			//order();System.out.println(orderlist.size());
			//update();
			 a();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//catch (DocumentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}//System.out.println(Db.testConnection());
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
}
