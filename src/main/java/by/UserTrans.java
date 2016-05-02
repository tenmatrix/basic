package by;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
/*
  用户帐号,用户密码,密码问题,密码答案,电子邮件,用户单位,起始日期,用户姓名,性别,出生日期,家庭地址,教育水平,专业,行业,职业,职务
 
 `用户帐号` varchar(40) DEFAULT NULL,
  `用户密码` varchar(40) DEFAULT NULL,
  `密码问题` varchar(60) DEFAULT NULL,
  `密码答案` varchar(60) DEFAULT NULL,
  `电子邮件` varchar(30) DEFAULT NULL,
  `用户单位` varchar(60) DEFAULT NULL,
  `起始日期` varchar(20) DEFAULT NULL,
  `用户姓名` varchar(30) DEFAULT NULL,
  `性别` varchar(10) DEFAULT NULL,
  `出生日期` varchar(10) DEFAULT NULL,
  `家庭地址` varchar(60) DEFAULT NULL,
  `教育水平` varchar(10) DEFAULT NULL,
  `专业` varchar(10) DEFAULT NULL
  `行业` varchar(10) DEFAULT NULL,
  `职业` varchar(10) DEFAULT NULL,
  `职务` varchar(10) DEFAULT NULL,
  
    `邮编` varchar(6) DEFAULT NULL,
  `电话` varchar(20) DEFAULT NULL,

  `传真` varchar(30) DEFAULT NULL,
  `证件号码` varchar(10) DEFAULT NULL,

  `用户组别` varchar(40) DEFAULT NULL,

1
  `备注` varchar(200) DEFAULT NULL,
3

touxiang.jpg
  `截止日期` varchar(20) DEFAULT NULL,
  `用户IP` varchar(10) DEFAULT NULL,

  
  
    `userLoginName` varchar(100) NOT NULL COMMENT '登录名',
  `userPassword` varchar(100) NOT NULL COMMENT '密码',
  `userPasswordQuestion` varchar(255) DEFAULT NULL COMMENT '密码提示问题',
  `userPasswordAnswer` varchar(255) DEFAULT NULL COMMENT '密码提示答案',
  `userEmail` varchar(100) NOT NULL COMMENT '电子邮件',
  `userWorkUnit` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `userRegisterTime` varchar(100) DEFAULT NULL COMMENT '注册时间',
  `userRealName` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `userSex` varchar(10) DEFAULT NULL COMMENT '性别',
  `userBirthday` varchar(20) DEFAULT NULL COMMENT '生日',
  `userAddress` varchar(500) DEFAULT NULL COMMENT '详细地址',
  `userEducateDegree` varchar(50) DEFAULT NULL COMMENT '教育程度(学位)',
  `userMajor` varchar(50) DEFAULT NULL COMMENT '用户专业',
  `userProfession` varchar(100) DEFAULT NULL COMMENT '职业(行业)',
  `userJob` varchar(50) DEFAULT NULL COMMENT '用户所从事的工作',
  `userDuty` varchar(100) DEFAULT NULL COMMENT '职位(职务)',

  `userZipCode` varchar(50) DEFAULT NULL COMMENT '邮编',
  `userTelephone` varchar(50) DEFAULT NULL COMMENT '电话',

  `userFax` varchar(100) DEFAULT NULL COMMENT '传真',
  `userIdentityCard` varchar(100) DEFAULT NULL COMMENT '身份证号码',

  `userGroupId` int(11) NOT NULL COMMENT '用户组编号(用户所在的用户组编号)，外键关联cfsdc_user_group',
  `userAuthorityId` int(11) NOT NULL COMMENT '用户权限编号，外键关联cfsdc_user_authority',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `checkStatus` int(11) DEFAULT NULL COMMENT '审核状态，3未审核,1通过，0不通过',

  `image` varchar(300) DEFAULT NULL COMMENT '用户头像',
  `vipEndTime` varchar(50) DEFAULT NULL COMMENT 'VIP到期时间',
  `Ip` varchar(200) DEFAULT NULL COMMENT '用户注册时的ip',


 */
public class UserTrans {
	Connection conn;
	Statement stm;
	ResultSet rs;
	public static String driver = "com.mysql.jdbc.Driver";
	public static String jdbc_url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
	public static String user = "root";
	public static String pwd = "root";

	public Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName(driver);
		return DriverManager.getConnection(jdbc_url, user, pwd);
	}
	
	public UserTrans(Connection con){
		this.conn=con;
	}
	public UserTrans(){
		try {
			conn=this.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doing(){
		String oldsql="select * from user";// where 用户帐号='admin'";
		try {
			PreparedStatement ps=conn.prepareStatement(oldsql);
			ResultSet rs=ps.executeQuery();
			StringBuilder insertsql=new StringBuilder();
			int count=0;
			int id=1;
			while(rs.next()){
				insertsql.append("insert into cfsdc_user_info")
				.append("(")
				.append("userId").append(",")
				.append("userLoginName").append(",")
				.append("userPassword").append(",")
				.append("userPasswordQuestion").append(",")
				.append("userPasswordAnswer").append(",")
				.append("userEmail").append(",")
				.append("userWorkUnit").append(",")
				.append("userRegisterTime").append(",")
				.append("userRealName").append(",")
				.append("userSex").append(",")
				.append("userBirthday").append(",")
				.append("userAddress").append(",")
				.append("userEducateDegree").append(",")
				.append("userMajor").append(",")
				.append("userProfession").append(",")
				.append("userJob").append(",")
				.append("userDuty").append(",")
				.append("userZipCode").append(",")
				.append("userTelephone").append(",")
				.append("userFax").append(",")
				.append("userIdentityCard").append(",")
				.append("userGroupId").append(",")
				.append("userAuthorityId").append(",")
				.append("note").append(",")
				.append("checkStatus").append(",")
				.append("image").append(",")
				.append("vipEndTime").append(",")
				.append("Ip")
				.append(")");
				
				
				
				
				String mima=rs.getString("用户密码");
				if(mima==null || mima.trim().equals("")){
					mima="123456";
				}else{mima.replaceAll("'", "''");}
				
				String email=rs.getString("电子邮件");
				if(email==null){
					email="";
				}else{mima.replaceAll("'", "''");}
				
				//性别
				//1:男；2:女
				String sex=rs.getString("性别");
				if(sex==null || !(sex.trim().equals("1") || sex.trim().equals("2"))){
					sex="";
				}else{
					if(sex.trim().equals("1")){sex="男";}
					if(sex.trim().equals("2")){sex="女";}
				}
				
				
				//学位
				//	<option value="2" <%if( struserdegree.equals("2")){%>selected<%}%>>博士</option>
		      	//  <option value="3" <%if( struserdegree.equals("3")){%>selected<%}%>>硕士</option>
		      	//  <option value="4" <%if( struserdegree.equals("4")){%>selected<%}%>>学士</option>
		      	//  <option value="9" <%if( struserdegree.equals("9")){%>selected<%}%>>其他</option>
				String degree=rs.getString("教育水平");
				if(degree!=null && !(degree.trim().equals(""))){
					switch(Integer.valueOf(degree)){
					case 2:{degree="博士";break;}
					case 3:{degree="硕士";break;}
					case 4:{degree="学士";break;}
					case 9:{degree="其他";break;}
					default:degree="其他";
					}
				}
				
				
				
				//专业				
				Map<String,String> zhuanyeMap=new HashMap<String,String>();
				zhuanyeMap.put("01", "哲学");
				zhuanyeMap.put("0101", "哲学类");
				zhuanyeMap.put("0102", "马克思主义理论类");
				zhuanyeMap.put("02", "经济学");
				zhuanyeMap.put("0201", "经济学类");
				zhuanyeMap.put("0202", "工商管理类");
				zhuanyeMap.put("03", "法学");
				zhuanyeMap.put("0301", "法学类");
				zhuanyeMap.put("0302", "社会学类");
				zhuanyeMap.put("0303", "政治学类");
				zhuanyeMap.put("0304", "公安学类");
				zhuanyeMap.put("04", "教育学");
				zhuanyeMap.put("0401", "教育学类");
				zhuanyeMap.put("0402", "思想政治教育类");
				zhuanyeMap.put("0403", "体育学类");
				zhuanyeMap.put("0404", "职业技术教育类");
				zhuanyeMap.put("05", "文学");
				zhuanyeMap.put("0501", "中国语言文学类");
				zhuanyeMap.put("0502", "外国语言文学类");
				zhuanyeMap.put("0503", "新闻学类");
				zhuanyeMap.put("0504", "艺术类");
				zhuanyeMap.put("0505", "艺术类(影视制片管理,影视发行管理,戏剧教育,工艺美术教育,影视电化教育,艺术类其他专业)");
				zhuanyeMap.put("06", "历史学");
				zhuanyeMap.put("0601", "历史学类");
				zhuanyeMap.put("0602", "图书信息档案学类");
				zhuanyeMap.put("07", "理学");
				zhuanyeMap.put("0701", "数学类");
				zhuanyeMap.put("0702", "物理学类");
				zhuanyeMap.put("0703", "化学类");
				zhuanyeMap.put("0704", "生物科学类");
				zhuanyeMap.put("0705", "天文学类");
				zhuanyeMap.put("0706", "地址学类");
				zhuanyeMap.put("0707", "地理科学类");
				zhuanyeMap.put("0708", "地球物理学类");
				zhuanyeMap.put("0709", "大气科学类");
				zhuanyeMap.put("0710", "海洋科学类");
				zhuanyeMap.put("0711", "力学类");
				zhuanyeMap.put("0712", "信息与电子科学类");
				zhuanyeMap.put("0713", "材料科学类");
				zhuanyeMap.put("0714", "环境科学类");
				zhuanyeMap.put("0715", "心理学类");
				zhuanyeMap.put("0716", "科技信息与管理");
				zhuanyeMap.put("08", "工学");
				zhuanyeMap.put("0801", "地矿类");
				zhuanyeMap.put("0802", "材料类");
				zhuanyeMap.put("0803", "机械类");
				zhuanyeMap.put("0804", "仪器仪表类");
				zhuanyeMap.put("0805", "热能核能类");
				zhuanyeMap.put("0806", "电工类");
				zhuanyeMap.put("0807", "电子与信息类");
				zhuanyeMap.put("0808", "土建类");
				zhuanyeMap.put("0809", "水利类");
				zhuanyeMap.put("0810", "测绘类");
				zhuanyeMap.put("0811", "环境类");
				zhuanyeMap.put("0812", "化工与制药类");
				zhuanyeMap.put("0813", "轻工粮食食品类");
				zhuanyeMap.put("0814", "农业工程类");
				zhuanyeMap.put("0815", "林业工程类");
				zhuanyeMap.put("0816", "纺织类");
				zhuanyeMap.put("0817", "交通运输类");
				zhuanyeMap.put("0818", "航空航天类");
				zhuanyeMap.put("0819", "兵器类");
				zhuanyeMap.put("0820", "公安技术类");
				zhuanyeMap.put("0821", "工程力学类");
				zhuanyeMap.put("0822", "管理工程类");
				zhuanyeMap.put("09", "农学");
				zhuanyeMap.put("0901", "植物生产类");
				zhuanyeMap.put("0902", "森林资源类");
				zhuanyeMap.put("0903", "环境保护类");
				zhuanyeMap.put("0904", "动物生产与兽医类");
				zhuanyeMap.put("0905", "水产类");
				zhuanyeMap.put("0906", "管理类");
				zhuanyeMap.put("0907", "农业推广类");
				zhuanyeMap.put("10", "医学");
				zhuanyeMap.put("1001", "基础医学类");
				zhuanyeMap.put("1002", "预防医学类");
				zhuanyeMap.put("1003", "临床医学与医学技术类");
				zhuanyeMap.put("1004", "口腔医学类");
				zhuanyeMap.put("1005", "中医学类");
				zhuanyeMap.put("1006", "法医学类");
				zhuanyeMap.put("1007", "护理学类");
				zhuanyeMap.put("1008", "药学类");
				zhuanyeMap.put("1009", "管理类");
				
				String zhuanye=rs.getString("专业");
				if(zhuanye!=null && !(zhuanye.trim().equals(""))){
					zhuanye=zhuanyeMap.get(zhuanye);
				}
				
				
				//组别id
				//1	管理员
				//2	普通用户
				//3	vip用户
				//4	协议用户
				String group=rs.getString("用户组别");
				int groupId=2;
				if(group!=null && !(group.trim().equals(""))){
					if(group.equals("guest_group")){
						groupId=2;
					}else if(group.equals("admin_group")){
						groupId=1;
					}else if(group.equals("林科院")){
						groupId=1;
					}else if(group.equals("7326892536176705")){
						groupId=3;
					}else if(group.equals("9396102573581172")){
						groupId=4;
					}
				}else{throw new RuntimeException("错误的组别id");}
				
				
				//System.out.println(rs.getString("用户帐号"));
				insertsql.append("values(")
				.append(id).append(",")
				.append("'"+notNull(rs.getString("用户帐号"))+"'").append(",")
				.append("'"+mima+"'").append(",")
				.append(this.couldNull(rs.getString("密码问题"))).append(",")
				.append(this.couldNull(rs.getString("密码答案"))).append(",")
				.append("'"+email+"'").append(",")
				.append(this.couldNull(rs.getString("用户单位"))).append(",")
				.append(this.couldNull(rs.getString("起始日期"))).append(",")
				.append(this.couldNull(rs.getString("用户姓名"))).append(",")
				.append(this.couldNull(sex)).append(",")
				.append(this.couldNull(rs.getString("出生日期"))).append(",")
				.append(this.couldNull(rs.getString("家庭地址"))).append(",")
				.append(this.couldNull(degree)).append(",")
				.append(this.couldNull(zhuanye)).append(",")
				.append(this.couldNull(rs.getString("行业"))).append(",")
				.append(this.couldNull(rs.getString("职业"))).append(",")
				.append(this.couldNull(rs.getString("职务"))).append(",")
				.append(this.couldNull(rs.getString("邮编"))).append(",")
				.append(this.couldNull(rs.getString("电话"))).append(",")
				.append(this.couldNull(rs.getString("传真"))).append(",")
				.append(this.couldNull(rs.getString("证件号码"))).append(",")
				.append(groupId).append(",")
				.append(1).append(",")
				.append(this.couldNull(rs.getString("备注"))).append(",")
				.append(3).append(",")
				.append(this.couldNull("touxiang.jpg")).append(",")
				.append(this.couldNull(rs.getString("截止日期"))).append(",")
				.append(this.couldNull(rs.getString("用户IP")))
				
				.append(");\n");
				id=id+1;
				count=count+1;
			}
			
				File f=new File("g:\\baiyu\\cfsdc\\cfsdc_user_info_import.sql");
				PrintWriter pw=new PrintWriter(f,"utf-8");
				pw.write(insertsql.toString());
				pw.flush();
				pw.close();
				System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void doingWithPrep(){
		String oldsql="select * from user";// where 用户帐号='admin'";
		try {
			PreparedStatement ps=conn.prepareStatement(oldsql);
			ResultSet rs=ps.executeQuery();
			//StringBuilder insertsql=new StringBuilder();
			int count=0;
			int id=1;
			while(rs.next()){
				String insertsql="insert into cfsdc_user_info(" +
						"userId," +
						"userLoginName," +
						"userPassword," +
						"userPasswordQuestion," +
						"userPasswordAnswer," +
						"userEmail," +
						"userWorkUnit," +
						"userRegisterTime," +
						"userRealName," +
						"userSex," +
						"userBirthday," +
						"userAddress," +
						"userEducateDegree," +
						"userMajor," +
						"userProfession," +
						"userJob," +
						"userDuty," +
						"userZipCode," +
						"userTelephone," +
						"userFax," +
						"userIdentityCard," +
						"userGroupId," +
						"userAuthorityId," +
						"note," +
						"checkStatus," +
						"image," +
						"vipEndTime," +
						"Ip" +
						")" +
						"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement insert_ps=conn.prepareStatement(insertsql);
	
				
				
				
				
				String mima=rs.getString("用户密码");
				if(mima==null || mima.trim().equals("")){
					mima="123456";
				}
				
				String email=rs.getString("电子邮件");
				if(email==null){
					email="";
				}
				
				//性别
				//1:男；2:女
				String sex=rs.getString("性别");
				if(sex==null || !(sex.trim().equals("1") || sex.trim().equals("2"))){
					sex="";
				}else{
					if(sex.trim().equals("1")){sex="男";}
					if(sex.trim().equals("2")){sex="女";}
				}
				
				
				//学位
				//	<option value="2" <%if( struserdegree.equals("2")){%>selected<%}%>>博士</option>
				//  <option value="3" <%if( struserdegree.equals("3")){%>selected<%}%>>硕士</option>
				//  <option value="4" <%if( struserdegree.equals("4")){%>selected<%}%>>学士</option>
				//  <option value="9" <%if( struserdegree.equals("9")){%>selected<%}%>>其他</option>
				String degree=rs.getString("教育水平");
				if(degree!=null && !(degree.trim().equals(""))){
					switch(Integer.valueOf(degree)){
					case 2:{degree="博士";break;}
					case 3:{degree="硕士";break;}
					case 4:{degree="学士";break;}
					case 9:{degree="其他";break;}
					default:degree="其他";
					}
				}
				
				
				
				//专业				
				Map<String,String> zhuanyeMap=new HashMap<String,String>();
				zhuanyeMap.put("01", "哲学");
				zhuanyeMap.put("0101", "哲学类");
				zhuanyeMap.put("0102", "马克思主义理论类");
				zhuanyeMap.put("02", "经济学");
				zhuanyeMap.put("0201", "经济学类");
				zhuanyeMap.put("0202", "工商管理类");
				zhuanyeMap.put("03", "法学");
				zhuanyeMap.put("0301", "法学类");
				zhuanyeMap.put("0302", "社会学类");
				zhuanyeMap.put("0303", "政治学类");
				zhuanyeMap.put("0304", "公安学类");
				zhuanyeMap.put("04", "教育学");
				zhuanyeMap.put("0401", "教育学类");
				zhuanyeMap.put("0402", "思想政治教育类");
				zhuanyeMap.put("0403", "体育学类");
				zhuanyeMap.put("0404", "职业技术教育类");
				zhuanyeMap.put("05", "文学");
				zhuanyeMap.put("0501", "中国语言文学类");
				zhuanyeMap.put("0502", "外国语言文学类");
				zhuanyeMap.put("0503", "新闻学类");
				zhuanyeMap.put("0504", "艺术类");
				zhuanyeMap.put("0505", "艺术类(影视制片管理,影视发行管理,戏剧教育,工艺美术教育,影视电化教育,艺术类其他专业)");
				zhuanyeMap.put("06", "历史学");
				zhuanyeMap.put("0601", "历史学类");
				zhuanyeMap.put("0602", "图书信息档案学类");
				zhuanyeMap.put("07", "理学");
				zhuanyeMap.put("0701", "数学类");
				zhuanyeMap.put("0702", "物理学类");
				zhuanyeMap.put("0703", "化学类");
				zhuanyeMap.put("0704", "生物科学类");
				zhuanyeMap.put("0705", "天文学类");
				zhuanyeMap.put("0706", "地址学类");
				zhuanyeMap.put("0707", "地理科学类");
				zhuanyeMap.put("0708", "地球物理学类");
				zhuanyeMap.put("0709", "大气科学类");
				zhuanyeMap.put("0710", "海洋科学类");
				zhuanyeMap.put("0711", "力学类");
				zhuanyeMap.put("0712", "信息与电子科学类");
				zhuanyeMap.put("0713", "材料科学类");
				zhuanyeMap.put("0714", "环境科学类");
				zhuanyeMap.put("0715", "心理学类");
				zhuanyeMap.put("0716", "科技信息与管理");
				zhuanyeMap.put("08", "工学");
				zhuanyeMap.put("0801", "地矿类");
				zhuanyeMap.put("0802", "材料类");
				zhuanyeMap.put("0803", "机械类");
				zhuanyeMap.put("0804", "仪器仪表类");
				zhuanyeMap.put("0805", "热能核能类");
				zhuanyeMap.put("0806", "电工类");
				zhuanyeMap.put("0807", "电子与信息类");
				zhuanyeMap.put("0808", "土建类");
				zhuanyeMap.put("0809", "水利类");
				zhuanyeMap.put("0810", "测绘类");
				zhuanyeMap.put("0811", "环境类");
				zhuanyeMap.put("0812", "化工与制药类");
				zhuanyeMap.put("0813", "轻工粮食食品类");
				zhuanyeMap.put("0814", "农业工程类");
				zhuanyeMap.put("0815", "林业工程类");
				zhuanyeMap.put("0816", "纺织类");
				zhuanyeMap.put("0817", "交通运输类");
				zhuanyeMap.put("0818", "航空航天类");
				zhuanyeMap.put("0819", "兵器类");
				zhuanyeMap.put("0820", "公安技术类");
				zhuanyeMap.put("0821", "工程力学类");
				zhuanyeMap.put("0822", "管理工程类");
				zhuanyeMap.put("09", "农学");
				zhuanyeMap.put("0901", "植物生产类");
				zhuanyeMap.put("0902", "森林资源类");
				zhuanyeMap.put("0903", "环境保护类");
				zhuanyeMap.put("0904", "动物生产与兽医类");
				zhuanyeMap.put("0905", "水产类");
				zhuanyeMap.put("0906", "管理类");
				zhuanyeMap.put("0907", "农业推广类");
				zhuanyeMap.put("10", "医学");
				zhuanyeMap.put("1001", "基础医学类");
				zhuanyeMap.put("1002", "预防医学类");
				zhuanyeMap.put("1003", "临床医学与医学技术类");
				zhuanyeMap.put("1004", "口腔医学类");
				zhuanyeMap.put("1005", "中医学类");
				zhuanyeMap.put("1006", "法医学类");
				zhuanyeMap.put("1007", "护理学类");
				zhuanyeMap.put("1008", "药学类");
				zhuanyeMap.put("1009", "管理类");
				
				String zhuanye=rs.getString("专业");
				if(zhuanye!=null && !(zhuanye.trim().equals(""))){
					zhuanye=zhuanyeMap.get(zhuanye);
				}
				
				
				//组别id
				//1	管理员
				//2	普通用户
				//3	vip用户
				//4	协议用户
				String group=rs.getString("用户组别");
				int groupId=2;
				if(group!=null && !(group.trim().equals(""))){
					if(group.equals("guest_group")){
						groupId=2;
					}else if(group.equals("admin_group")){
						groupId=1;
					}else if(group.equals("林科院")){
						groupId=1;
					}else if(group.equals("7326892536176705")){
						groupId=3;
					}else if(group.equals("9396102573581172")){
						groupId=4;
					}
				}else{throw new RuntimeException("错误的组别id");}
				
				
//				insert_ps.setInt(1, id);
//				insert_ps.setString(2,notNull(rs.getString("用户帐号")));
//				insert_ps.setString(3,mima);
//				insert_ps.setString(4,rs.getString("密码问题"));
//				insert_ps.setString(5,rs.getString("密码答案"));
//				insert_ps.setString(6,email);
//				insert_ps.setString(7,rs.getString("用户单位"));
//				insert_ps.setString(8,rs.getString("起始日期"));
//				insert_ps.setString(9,rs.getString("用户姓名"));
//				insert_ps.setString(10,sex);
//				insert_ps.setString(11,rs.getString("出生日期"));
//				insert_ps.setString(12,rs.getString("家庭地址"));
//				insert_ps.setString(13,degree);
//				insert_ps.setString(14,zhuanye);
//				insert_ps.setString(15,rs.getString("行业"));
//				insert_ps.setString(16,rs.getString("职业"));
//				insert_ps.setString(17,rs.getString("职务"));
//				insert_ps.setString(18,rs.getString("邮编"));
//				insert_ps.setString(19,rs.getString("电话"));
//				insert_ps.setString(20,rs.getString("传真"));
//				insert_ps.setString(21,rs.getString("证件号码"));
//				insert_ps.setInt(22,groupId);
//				insert_ps.setInt(23,1);
//				insert_ps.setString(24,rs.getString("备注"));
//				insert_ps.setInt(25,3);
//				insert_ps.setString(26,"touxiang.jpg");
//				insert_ps.setString(27,rs.getString("截止日期"));
//				insert_ps.setString(28,rs.getString("用户IP"));
				
				
				insert_ps.setInt(1, id);
				insert_ps.setString(2,notNull(rs.getString("用户帐号")));
				insert_ps.setString(3,mima);
				insert_ps.setString(4,rs.getString("密码问题"));
				insert_ps.setString(5,rs.getString("密码答案"));
				insert_ps.setString(6,email);
				insert_ps.setString(7,rs.getString("用户单位"));
				insert_ps.setString(8,rs.getString("起始日期"));
				insert_ps.setString(9,rs.getString("用户姓名"));
				insert_ps.setString(10,sex);
				insert_ps.setString(11,rs.getString("出生日期"));
				insert_ps.setString(12,rs.getString("家庭地址"));
				insert_ps.setString(13,degree);
				insert_ps.setString(14,zhuanye);
				insert_ps.setString(15,rs.getString("行业"));
				insert_ps.setString(16,rs.getString("职业"));
				insert_ps.setString(17,rs.getString("职务"));
				insert_ps.setString(18,rs.getString("邮编"));
				insert_ps.setString(19,rs.getString("电话"));
				insert_ps.setString(20,rs.getString("传真"));
				insert_ps.setString(21,rs.getString("证件号码"));
				insert_ps.setInt(22,groupId);
				insert_ps.setInt(23,1);
				insert_ps.setString(24,rs.getString("备注"));
				insert_ps.setInt(25,3);
				insert_ps.setString(26,"touxiang.jpg");
				insert_ps.setString(27,rs.getString("截止日期"));
				insert_ps.setString(28,rs.getString("用户IP"));
				
				//System.out.println(rs.getString("用户帐号"));
//				insertsql.append("values(")
//				.append(id).append(",")
//				.append("'"+notNull(rs.getString("用户帐号"))+"'").append(",")
//				.append("'"+mima+"'").append(",")
//				.append(this.couldNull(rs.getString("密码问题"))).append(",")
//				.append(this.couldNull(rs.getString("密码答案"))).append(",")
//				.append("'"+email+"'").append(",")
//				.append(this.couldNull(rs.getString("用户单位"))).append(",")
//				.append(this.couldNull(rs.getString("起始日期"))).append(",")
//				.append(this.couldNull(rs.getString("用户姓名"))).append(",")
//				.append(this.couldNull(sex)).append(",")
//				.append(this.couldNull(rs.getString("出生日期"))).append(",")
//				.append(this.couldNull(rs.getString("家庭地址"))).append(",")
//				.append(this.couldNull(degree)).append(",")
//				.append(this.couldNull(zhuanye)).append(",")
//				.append(this.couldNull(rs.getString("行业"))).append(",")
//				.append(this.couldNull(rs.getString("职业"))).append(",")
//				.append(this.couldNull(rs.getString("职务"))).append(",")
//				.append(this.couldNull(rs.getString("邮编"))).append(",")
//				.append(this.couldNull(rs.getString("电话"))).append(",")
//				.append(this.couldNull(rs.getString("传真"))).append(",")
//				.append(this.couldNull(rs.getString("证件号码"))).append(",")
//				.append(groupId).append(",")
//				.append(1).append(",")
//				.append(this.couldNull(rs.getString("备注"))).append(",")
//				.append(3).append(",")
//				.append(this.couldNull("touxiang.jpg")).append(",")
//				.append(this.couldNull(rs.getString("截止日期"))).append(",")
//				.append(this.couldNull(rs.getString("用户IP")))
//				
//				.append(");\n");
				id=id+1;
				if(insert_ps.executeUpdate()>0)
					count=count+1;
			}
			
//			File f=new File("g:\\baiyu\\cfsdc\\cfsdc_user_info_import.sql");
//			PrintWriter pw=new PrintWriter(f,"utf-8");
//			pw.write(insertsql.toString());
//			pw.flush();
//			pw.close();
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	private String notNull(String obj){
		if(obj==null || obj.trim().equals("")){
			throw new RuntimeException("非null字段不可以插入null值。"+obj.toString());
		}
		else return obj;
	}
	private String couldNull(String obj){
		if(obj==null){
			return null;
		}
		if(obj.contains("'")){System.out.println(obj);obj=obj.replaceAll("'", "''");System.out.println(obj);}
		if(obj.contains(";")){System.out.println(obj);obj=obj.replaceAll(";", "';");System.out.println(obj);}
		return "'"+obj+"'";
	}
	
	public static void main(String[] args){
		UserTrans me=new UserTrans();
		//me.doing();
		me.doingWithPrep();
		
	}
}
