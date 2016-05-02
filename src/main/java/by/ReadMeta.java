package by;
import java.io.*;
import java.sql.*;
import java.util.*;
/*
b3.B3a1,
b3.B3a2,
b3.B3a3,
b4.B4b1,
b4.B4b2,
b4.B4b3,
v_b4c.b8a2 ,
v_b4c.b8a1 ,
v_b4c.B8a3 ,
v_b4c.B8a4 ,
v_b4c.B8a5 ,
v_b4c.B8a6 ,
v_b4c.B8a7 ,
v_b4c.B8a8 ,
v_b4c.B8a9 ,
v_b4c.B8a10 ,
v_b4c.B8a11 ,
v_b4c.B8a12 ,
b4.B4d1,
b4.B4d2,
b4.B4a1,
b4.B4a2,
b4.B4a3,
b5.B5a1,
v_b5b.B10a1,
v_b5b.B10a2,
v_b5b.B10a3,
v_b5b.B10a4,
v_b5b.B10a5,
b5.B5c1,
b5.B5c2,
b5.B5c3,
b5.B5c4,
b5.B5c5,
b5.B5d1,
b5.B5d2,
b5.B5d3,
b5.B5d4,
b5.B5d5,
b5.B5d6,
b5.B5d7,
b5.B5d8,
v_B5e.b8a2 ,
v_B5e.b8a1 ,
v_B5e.B8a3 ,
v_B5e.B8a4 ,
v_B5e.B8a5 ,
v_B5e.B8a6 ,
v_B5e.B8a7 ,
v_B5e.B8a8 ,
v_B5e.B8a9 ,
v_B5e.B8a10 ,
v_B5e.B8a11 ,
v_B5e.B8a12 ,
v_B5f.B10a1,
v_B5f.B10a2,
v_B5f.B10a3,
v_B5f.B10a4,
v_B5f.B10a5,
b5.B5a2,
b6.B6a1,
b6.B6a2,
b6.B6a3,
b6.B6a4,
b6.B6a5,
b6.B6a6,
b6.B6b1,
b6.B6b2,
b6.B6b3,
b6.B6b4,
b6.B6b5,
b6.B6b6,
b6.B6b7,
b6.B6b8,
b6.B6b9,
b6.B6b10,
b6.B6b11,
b6.B6b12,
b6.B6b13,
b6.B6b14,
b6.B6b15,
b6.B6b16,
b6.B6b17,
b6.B6b18,
b6.B6c1,
b6.B6c2,
b6.B6d1,
b6.B6d2,
b7.B7a1,
b7.B7b1,
b7.B7b2,
b7.B7b3,
b7.B7b4,
b7.B7b5,
b7.B7b6,
b7.B7b7,
b7.B7b8,
b7.B7b9,
b7.B7b10,
b7.B7b11,
b7.B7b12,
b7.B7b13,
b7.B7b14,
b7.B7b15,
b7.B7b16,
b7.B7b17,
b7.B7b18,
b7.B7b19,
b7.B7c1,
b7.B7c2,
b7.B7c3,
b7.B7c4,
b7.B7a2
*/


public class ReadMeta {
	Connection conn;
	Statement stm;
	ResultSet rs;
	public static String driver = "com.mysql.jdbc.Driver";
	public static String jdbc_url = "jdbc:mysql://localhost:3306/cfsdc?useUnicode=true&characterEncoding=UTF-8";
	public static String user = "root";
	public static String pwd = "root";

	public Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName(driver);
		return DriverManager.getConnection(jdbc_url, user, pwd);
	}
	
	public ReadMeta(Connection con){
		this.conn=con;
	}
	public ReadMeta(){
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
	private Map<String,String> initMap(){
		Map<String,String> result=new HashMap<String,String>();
		result.put("b1.id", null);
		result.put("b1.b1a2", null);
		result.put("b1.b1a3", null);
		result.put("b1b.b8a1", null);
		result.put("b1b.b8a2", null);
		result.put("b1b.b8a3", null);
		result.put("b1b.b8a4", null);
		result.put("b1b.b8a5", null);
		result.put("b1b.b8a6", null);
		result.put("b1b.b8a7", null);
		result.put("b1b.b8a8", null);
		result.put("b1b.b8a9", null);
		result.put("b1b.b8a10", null);
		result.put("b1b.b8a11", null);
		result.put("b1b.b8a12", null);
		result.put("b1.b1a4", null);
		result.put("b1.b1a5", null);
		result.put("b1.b1a6", null);
		result.put("b1c.b9a1", null);
		result.put("b1c.b9a2", null);
		result.put("b1c.b9a3", null);
		result.put("b1c.b9a4", null);
		result.put("b1.b1d1", null);
		result.put("b2.b2a1", null);
		result.put("b2.b2a2", null);
		result.put("b2.b2a3", null);
		result.put("b2.b2a4", null);
		result.put("b2.b2a5", null);
		result.put("b2.b2a6", null);
		result.put("b2b.b8a2", null);
		result.put("b2b.b8a1", null);
		result.put("b2b.b8a3", null);
		result.put("b2b.b8a4", null);
		result.put("b2b.b8a5", null);
		result.put("b2b.b8a6", null);
		result.put("b2b.b8a7", null);
		result.put("b2b.b8a8", null);
		result.put("b2b.b8a9", null);
		result.put("b2b.b8a10", null);
		result.put("b2b.b8a11", null);
		result.put("b2b.b8a12", null);
		result.put("b2.b2a7", null);
		result.put("b2.b2a8", null);
		result.put("b2.b2a9", null);
		result.put("b2.b2a10", null);
		result.put("b2c.b8a2", null);
		result.put("b2c.b8a1", null);
		result.put("b2c.b8a3", null);
		result.put("b2c.b8a4", null);
		result.put("b2c.b8a5", null);
		result.put("b2c.b8a6", null);
		result.put("b2c.b8a7", null);
		result.put("b2c.b8a8", null);
		result.put("b2c.b8a9", null);
		result.put("b2c.b8a10", null);
		result.put("b2c.b8a11", null);
		result.put("b2c.b8a12", null);
		result.put("b2.b2d1", null);
		result.put("b2.b2d2", null);
		result.put("b2.b2d3", null);
		result.put("b2.b2a11", null);
		result.put("b2.b2a12", null);
		result.put("b2.b2a13", null);
		result.put("b2.b2a14", null);
		result.put("b2.b2a15", null);
		result.put("b2.b2a16", null);
		result.put("b2.b2a17", null);
		result.put("b2e.b9a1", null);
		result.put("b2e.b9a2", null);
		result.put("b2e.b9a3", null);
		result.put("b2e.b9a4", null);
		result.put("b2.b2a18", null);
		result.put("b2.b2a19", null);
		result.put("b2.b2a20", null);
		result.put("b2.b2a21", null);
		result.put("b2.b2a22", null);
		result.put("b2.b2a23", null);
		result.put("b3.b3a1", null);
		result.put("b3.b3a2", null);
		result.put("b3.b3a3", null);
		result.put("b4.b4b1", null);
		result.put("b4.b4b2", null);
		result.put("b4.b4b3", null);
		result.put("b4c.b8a2", null);
		result.put("b4c.b8a1", null);
		result.put("b4c.b8a3", null);
		result.put("b4c.b8a4", null);
		result.put("b4c.b8a5", null);
		result.put("b4c.b8a6", null);
		result.put("b4c.b8a7", null);
		result.put("b4c.b8a8", null);
		result.put("b4c.b8a9", null);
		result.put("b4c.b8a10", null);
		result.put("b4c.b8a11", null);
		result.put("b4c.b8a12", null);
		result.put("b4.b4d1", null);
		result.put("b4.b4d2", null);
		result.put("b4.b4a1", null);
		result.put("b4.b4a2", null);
		result.put("b4.b4a3", null);
		result.put("b5.b5a1", null);
		result.put("b5b.b10a1", null);
		result.put("b5b.b10a2", null);
		result.put("b5b.b10a3", null);
		result.put("b5b.b10a4", null);
		result.put("b5b.b10a5", null);
		result.put("b5.b5c1", null);
		result.put("b5.b5c2", null);
		result.put("b5.b5c3", null);
		result.put("b5.b5c4", null);
		result.put("b5.b5c5", null);
		result.put("b5.b5d1", null);
		result.put("b5.b5d2", null);
		result.put("b5.b5d3", null);
		result.put("b5.b5d4", null);
		result.put("b5.b5d5", null);
		result.put("b5.b5d6", null);
		result.put("b5.b5d7", null);
		result.put("b5.b5d8", null);
		result.put("b5e.b8a2", null);
		result.put("b5e.b8a1", null);
		result.put("b5e.b8a3", null);
		result.put("b5e.b8a4", null);
		result.put("b5e.b8a5", null);
		result.put("b5e.b8a6", null);
		result.put("b5e.b8a7", null);
		result.put("b5e.b8a8", null);
		result.put("b5e.b8a9", null);
		result.put("b5e.b8a10", null);
		result.put("b5e.b8a11", null);
		result.put("b5e.b8a12", null);
		result.put("b5f.b10a1", null);
		result.put("b5f.b10a2", null);
		result.put("b5f.b10a3", null);
		result.put("b5f.b10a4", null);
		result.put("b5f.b10a5", null);
		result.put("b5.b5a2", null);
		result.put("b6.b6a1", null);
		result.put("b6.b6a2", null);
		result.put("b6.b6a3", null);
		result.put("b6.b6a4", null);
		result.put("b6.b6a5", null);
		result.put("b6.b6a6", null);
		result.put("b6.b6b1", null);
		result.put("b6.b6b2", null);
		result.put("b6.b6b3", null);
		result.put("b6.b6b4", null);
		result.put("b6.b6b5", null);
		result.put("b6.b6b6", null);
		result.put("b6.b6b7", null);
		result.put("b6.b6b8", null);
		result.put("b6.b6b9", null);
		result.put("b6.b6b10", null);
		result.put("b6.b6b11", null);
		result.put("b6.b6b12", null);
		result.put("b6.b6b13", null);
		result.put("b6.b6b14", null);
		result.put("b6.b6b15", null);
		result.put("b6.b6b16", null);
		result.put("b6.b6b17", null);
		result.put("b6.b6b18", null);
		result.put("b6.b6c1", null);
		result.put("b6.b6c2", null);
		result.put("b6.b6d1", null);
		result.put("b6.b6d2", null);
		result.put("b7.b7a1", null);
		result.put("b7.b7b1", null);
		result.put("b7.b7b2", null);
		result.put("b7.b7b3", null);
		result.put("b7.b7b4", null);
		result.put("b7.b7b5", null);
		result.put("b7.b7b6", null);
		result.put("b7.b7b7", null);
		result.put("b7.b7b8", null);
		result.put("b7.b7b9", null);
		result.put("b7.b7b10", null);
		result.put("b7.b7b11", null);
		result.put("b7.b7b12", null);
		result.put("b7.b7b13", null);
		result.put("b7.b7b14", null);
		result.put("b7.b7b15", null);
		result.put("b7.b7b16", null);
		result.put("b7.b7b17", null);
		result.put("b7.b7b18", null);
		result.put("b7.b7b19", null);
		result.put("b7.b7c1", null);
		result.put("b7.b7c2", null);
		result.put("b7.b7c3", null);
		result.put("b7.b7c4", null);
		result.put("b7.b7a2", null);
		
		return result;
	}
	public void doAll()throws SQLException{
		Connection con=this.conn;
		String id="";
		String b1sql="select * from b1";
		PreparedStatement pstm=con.prepareStatement(b1sql);
		ResultSet rs=pstm.executeQuery();
		StringBuilder insert_sql=new StringBuilder();
		while(rs.next()){
			Map<String,String> resultmap=new HashMap<String,String>();
			
			resultmap=doing(rs);
			
			//操作时间类型。新库中时间相关的字段设计为varchar，并且长度小于原来日期值，所以要截取一下
			for(Map.Entry<String, String> elem:resultmap.entrySet()){
				String key=elem.getKey();
				String value=elem.getValue();
				if(!(key.equals("b2.b2a4")) || !(key.equals("b1.id"))){
					if(key.equals("b1.b1a4,")
							|| key.equals("b2.b2a16")
							|| key.equals("b5.B5d8")
							|| key.equals("b2.b2a3")
							|| key.equals("b2.b2a6")
							|| key.equals("b5.b5d5")
							|| key.equals("b5.b5d8")
							|| key.equals("b6.b6b15")
							|| key.equals("b1.b1a4")
					){
						if(value!=null && (!(value.equals(""))) && value.length()>=10){
							value=value.substring(0, 10);
						}
						
					}
					value="'"+value+"'";
					resultmap.put(key,value);
				}
			}
			
			//StringBuilder insert_sql=new StringBuilder();
			insert_sql.append("insert into cfsdc_metadata");
			insert_sql.append("(")
					.append("Id,")
					.append("language,")
					.append("encodeset,")
					.append("contacterName,")
					.append("unit,")
					.append("position,")
					.append("telephone,")
					.append("fax,")
					.append("address,")
					.append("city,")
					.append("province,")
					.append("zip,")
					.append("country,")
					.append("email,")
					.append("workhour,")
					.append("createdTime,")
					.append("standardName,")
					.append("standardVersion,")
					.append("applicability,")
					.append("accessRestriction,")
					.append("useRestriction,")
					.append("restrictionName,")
					.append("modifyFrequency,")
					.append("dName,")
					.append("dRename,")
					.append("dTime,")
					.append("dType,")
					.append("dVersion,")
					.append("dVersionTime,")
					.append("funit,")
					.append("fcontacterName,")
					.append("fposition,")
					.append("ftelephone,")
					.append("ffax,")
					.append("faddress,")
					.append("fcity,")
					.append("fprovince,")
					.append("fzip,")
					.append("fcountry,")
					.append("femail,")
					.append("fworkhour,")
					.append("dSummary,")
					.append("dPurpose,")
					.append("dStatus,")
					.append("dUpdateFre,")
					.append("hContact,")
					.append("hName,")
					.append("hPosition,")
					.append("hTel,")
					.append("hFax,")
					.append("hAddress,")
					.append("hCity,")
					.append("hProvince,")
					.append("hZip,")
					.append("hCountry,")
					.append("hEmail,")
					.append("hHours,")
					.append("hPicName,")
					.append("hPicDirection,")
					.append("hPicType,")
					.append("hFormat,")
					.append("hVersion,")
					.append("hDecompression,")
					.append("hKeyword,")
					.append("hDictionary,")
					.append("hDicDate,")
					.append("hDicType,")
					.append("dapplicability,")
					.append("daccessRestriction,")
					.append("duseRestriction,")
					.append("drestrictionName,")
					.append("dLanguage,")
					.append("dEncode,")
					.append("dClassName,")
					.append("dClassEncode,")
					.append("dStandard,")
					.append("dLinkAddress,")
					.append("m_range,")
					.append("metadataDescribe,")
					.append("detail,")
					.append("oName,")
					.append("oVersion,")
					.append("unzipDiscribe,")
					.append("ounit,")
					.append("ocontacterName,")
					.append("oposition,")
					.append("otelephone,")
					.append("ofax,")
					.append("oaddress,")
					.append("ocity,")
					.append("oprovince,")
					.append("ozip,")
					.append("ocountry,")
					.append("oemail,")
					.append("oworkhour,")
					.append("transferUnit,")
					.append("amount,")
					.append("onlineAddress,")
					.append("onlineFunction,")
					.append("mediaName,")
					.append("dataChiDir,")
					.append("westWarp,")
					.append("eastWarp,")
					.append("southWarp,")
					.append("northWarp,")
					.append("coverAreaDes,")
					.append("propWarpRep,")
					.append("logicOneRep,")
					.append("completeRep,")
					.append("levPosAccRep,")
					.append("pluLocaAccRep,")
					.append("dataSourDir,")
					.append("rateDenom,")
					.append("referFraneName,")
					.append("sChnName,")
					.append("sTime,")
					.append("sTimeType,")
					.append("sVersion,")
					.append("sVersionDate,")
					.append("sunit,")
					.append("scontacterName,")
					.append("sposition,")
					.append("stelephone,")
					.append("sfax,")
					.append("saddress,")
					.append("scity,")
					.append("sprovince,")
					.append("szip,")
					.append("scountry,")
					.append("semail,")
					.append("sworkhour,")
					.append("_westWarp,")
					.append("_eastWarp,")
					.append("_southWarp,")
					.append("_northWarp,")
					.append("_coverAreaDes,")
					.append("dataDealStep,")
					.append("pixelOrigin,")
					.append("rowNum,")
					.append("columnNum,")
					.append("layerNum,")
					.append("pixelColorDir,")
					.append("toneClassify,")
					.append("imageType,")
					.append("photoCondition,")
					.append("cloudCoverRate,")
					.append("radioDateAva,")
					.append("imageDealAva,")
					.append("storageMedia,")
					.append("igRateAva,")
					.append("sensorTime,")
					.append("satelliteName,")
					.append("sensorName,")
					.append("sensorType,")
					.append("sensorMode,")
					.append("sensorWaveInfor,")
					.append("trackNum,")
					.append("imaTranDate,")
					.append("imaTranTime,")
					.append("imaResolution,")
					.append("imaOtherDir,")
					.append("scaleDenom,")
					.append("topoLevel,")
					.append("geometryType,")
					.append("geoObjCount,")
					.append("systemType,")
					.append("shadowName,")
					.append("gridNum,")
					.append("normWeft,")
					.append("centralWarp,")
					.append("shaOriWeft,")
					.append("eastShift,")
					.append("northShift,")
					.append("shiftUnit,")
					.append("equatorScale,")
					.append("viewHeight,")
					.append("shaCenWarp,")
					.append("shaCenWeft,")
					.append("cenWarpScale,")
					.append("polePlumbWarp,")
					.append("shaOriScale,")
					.append("tiltedAxisAngle,")
					.append("axisMeasure,")
					.append("tiltedAxisWeft,")
					.append("tiltedAxisWarp,")
					.append("ellipsoidName,")
					.append("ellSemimajor,")
					.append("ellAxisUnit,")
					.append("flatRateDenom,")
					.append("horiReferName")
					.append(")");
			
			
			
			insert_sql.append("values")
					.append("(")
					
					.append(resultmap.get("b1.id")+",")
					.append(resultmap.get("b1.b1a2")+",")
					.append(resultmap.get("b1.b1a3")+",")
					.append(resultmap.get("b1b.b8a1")+",")
					.append(resultmap.get("b1b.b8a2")+",")
					.append(resultmap.get("b1b.b8a3")+",")
					.append(resultmap.get("b1b.b8a4")+",")
					.append(resultmap.get("b1b.b8a5")+",")
					.append(resultmap.get("b1b.b8a6")+",")
					.append(resultmap.get("b1b.b8a7")+",")
					.append(resultmap.get("b1b.b8a8")+",")
					.append(resultmap.get("b1b.b8a9")+",")
					.append(resultmap.get("b1b.b8a10")+",")
					.append(resultmap.get("b1b.b8a11")+",")
					.append(resultmap.get("b1b.b8a12")+",")
					.append(resultmap.get("b1.b1a4")+",")
					.append(resultmap.get("b1.b1a5")+",")
					.append(resultmap.get("b1.b1a6")+",")
					.append(resultmap.get("b1c.b9a1")+",")
					.append(resultmap.get("b1c.b9a2")+",")
					.append(resultmap.get("b1c.b9a3")+",")
					.append(resultmap.get("b1c.b9a4")+",")
					.append(resultmap.get("b1.b1d1")+",")
					.append(resultmap.get("b2.b2a1")+",")
					.append(resultmap.get("b2.b2a2")+",")
					.append(resultmap.get("b2.b2a3")+",")
					.append(resultmap.get("b2.b2a4")+",")
					.append(resultmap.get("b2.b2a5")+",")
					.append(resultmap.get("b2.b2a6")+",")
					.append(resultmap.get("b2b.b8a2")+",")
					.append(resultmap.get("b2b.b8a1")+",")
					.append(resultmap.get("b2b.b8a3")+",")
					.append(resultmap.get("b2b.b8a4")+",")
					.append(resultmap.get("b2b.b8a5")+",")
					.append(resultmap.get("b2b.b8a6")+",")
					.append(resultmap.get("b2b.b8a7")+",")
					.append(resultmap.get("b2b.b8a8")+",")
					.append(resultmap.get("b2b.b8a9")+",")
					.append(resultmap.get("b2b.b8a10")+",")
					.append(resultmap.get("b2b.b8a11")+",")
					.append(resultmap.get("b2b.b8a12")+",")
					.append(resultmap.get("b2.b2a7")+",")
					.append(resultmap.get("b2.b2a8")+",")
					.append(resultmap.get("b2.b2a9")+",")
					.append(resultmap.get("b2.b2a10")+",")
					.append(resultmap.get("b2c.b8a2")+",")
					.append(resultmap.get("b2c.b8a1")+",")
					.append(resultmap.get("b2c.b8a3")+",")
					.append(resultmap.get("b2c.b8a4")+",")
					.append(resultmap.get("b2c.b8a5")+",")
					.append(resultmap.get("b2c.b8a6")+",")
					.append(resultmap.get("b2c.b8a7")+",")
					.append(resultmap.get("b2c.b8a8")+",")
					.append(resultmap.get("b2c.b8a9")+",")
					.append(resultmap.get("b2c.b8a10")+",")
					.append(resultmap.get("b2c.b8a11")+",")
					.append(resultmap.get("b2c.b8a12")+",")
					.append(resultmap.get("b2.b2d1")+",")
					.append(resultmap.get("b2.b2d2")+",")
					.append(resultmap.get("b2.b2d3")+",")
					.append(resultmap.get("b2.b2a11")+",")
					.append(resultmap.get("b2.b2a12")+",")
					.append(resultmap.get("b2.b2a13")+",")
					.append(resultmap.get("b2.b2a14")+",")
					.append(resultmap.get("b2.b2a15")+",")
					.append(resultmap.get("b2.b2a16")+",")
					.append(resultmap.get("b2.b2a17")+",")
					.append(resultmap.get("b2e.b9a1")+",")
					.append(resultmap.get("b2e.b9a2")+",")
					.append(resultmap.get("b2e.b9a3")+",")
					.append(resultmap.get("b2e.b9a4")+",")
					.append(resultmap.get("b2.b2a18")+",")
					.append(resultmap.get("b2.b2a19")+",")
					.append(resultmap.get("b2.b2a20")+",")
					.append(resultmap.get("b2.b2a21")+",")
					.append(resultmap.get("b2.b2a22")+",")
					.append(resultmap.get("b2.b2a23")+",")
					.append(resultmap.get("b3.b3a1")+",")
					.append(resultmap.get("b3.b3a2")+",")
					.append(resultmap.get("b3.b3a3")+",")
					.append(resultmap.get("b4.b4b1")+",")
					.append(resultmap.get("b4.b4b2")+",")
					.append(resultmap.get("b4.b4b3")+",")
					.append(resultmap.get("b4c.b8a2")+",")
					.append(resultmap.get("b4c.b8a1")+",")
					.append(resultmap.get("b4c.b8a3")+",")
					.append(resultmap.get("b4c.b8a4")+",")
					.append(resultmap.get("b4c.b8a5")+",")
					.append(resultmap.get("b4c.b8a6")+",")
					.append(resultmap.get("b4c.b8a7")+",")
					.append(resultmap.get("b4c.b8a8")+",")
					.append(resultmap.get("b4c.b8a9")+",")
					.append(resultmap.get("b4c.b8a10")+",")
					.append(resultmap.get("b4c.b8a11")+",")
					.append(resultmap.get("b4c.b8a12")+",")
					.append(resultmap.get("b4.b4d1")+",")
					.append(resultmap.get("b4.b4d2")+",")
					.append(resultmap.get("b4.b4a1")+",")
					.append(resultmap.get("b4.b4a2")+",")
					.append(resultmap.get("b4.b4a3")+",")
					.append(resultmap.get("b5.b5a1")+",")
					.append(resultmap.get("b5b.b10a1")+",")
					.append(resultmap.get("b5b.b10a2")+",")
					.append(resultmap.get("b5b.b10a3")+",")
					.append(resultmap.get("b5b.b10a4")+",")
					.append(resultmap.get("b5b.b10a5")+",")
					.append(resultmap.get("b5.b5c1")+",")
					.append(resultmap.get("b5.b5c2")+",")
					.append(resultmap.get("b5.b5c3")+",")
					.append(resultmap.get("b5.b5c4")+",")
					.append(resultmap.get("b5.b5c5")+",")
					.append(resultmap.get("b5.b5d1")+",")
					.append(resultmap.get("b5.b5d2")+",")
					.append(resultmap.get("b5.b5d3")+",")
					.append(resultmap.get("b5.b5d4")+",")
					.append(resultmap.get("b5.b5d5")+",")
					.append(resultmap.get("b5.b5d6")+",")
					.append(resultmap.get("b5.b5d7")+",")
					.append(resultmap.get("b5.b5d8")+",")
					.append(resultmap.get("b5e.b8a2")+",")
					.append(resultmap.get("b5e.b8a1")+",")
					.append(resultmap.get("b5e.b8a3")+",")
					.append(resultmap.get("b5e.b8a4")+",")
					.append(resultmap.get("b5e.b8a5")+",")
					.append(resultmap.get("b5e.b8a6")+",")
					.append(resultmap.get("b5e.b8a7")+",")
					.append(resultmap.get("b5e.b8a8")+",")
					.append(resultmap.get("b5e.b8a9")+",")
					.append(resultmap.get("b5e.b8a10")+",")
					.append(resultmap.get("b5e.b8a11")+",")
					.append(resultmap.get("b5e.b8a12")+",")
					.append(resultmap.get("b5f.b10a1")+",")
					.append(resultmap.get("b5f.b10a2")+",")
					.append(resultmap.get("b5f.b10a3")+",")
					.append(resultmap.get("b5f.b10a4")+",")
					.append(resultmap.get("b5f.b10a5")+",")
					.append(resultmap.get("b5.b5a2")+",")
					.append(resultmap.get("b6.b6a1")+",")
					.append(resultmap.get("b6.b6a2")+",")
					.append(resultmap.get("b6.b6a3")+",")
					.append(resultmap.get("b6.b6a4")+",")
					.append(resultmap.get("b6.b6a5")+",")
					.append(resultmap.get("b6.b6a6")+",")
					.append(resultmap.get("b6.b6b1")+",")
					.append(resultmap.get("b6.b6b2")+",")
					.append(resultmap.get("b6.b6b3")+",")
					.append(resultmap.get("b6.b6b4")+",")
					.append(resultmap.get("b6.b6b5")+",")
					.append(resultmap.get("b6.b6b6")+",")
					.append(resultmap.get("b6.b6b7")+",")
					.append(resultmap.get("b6.b6b8")+",")
					.append(resultmap.get("b6.b6b9")+",")
					.append(resultmap.get("b6.b6b10")+",")
					.append(resultmap.get("b6.b6b11")+",")
					.append(resultmap.get("b6.b6b12")+",")
					.append(resultmap.get("b6.b6b13")+",")
					.append(resultmap.get("b6.b6b14")+",")
					.append(resultmap.get("b6.b6b15")+",")
					.append(resultmap.get("b6.b6b16")+",")
					.append(resultmap.get("b6.b6b17")+",")
					.append(resultmap.get("b6.b6b18")+",")
					.append(resultmap.get("b6.b6c1")+",")
					.append(resultmap.get("b6.b6c2")+",")
					.append(resultmap.get("b6.b6d1")+",")
					.append(resultmap.get("b6.b6d2")+",")
					.append(resultmap.get("b7.b7a1")+",")
					.append(resultmap.get("b7.b7b1")+",")
					.append(resultmap.get("b7.b7b2")+",")
					.append(resultmap.get("b7.b7b3")+",")
					.append(resultmap.get("b7.b7b4")+",")
					.append(resultmap.get("b7.b7b5")+",")
					.append(resultmap.get("b7.b7b6")+",")
					.append(resultmap.get("b7.b7b7")+",")
					.append(resultmap.get("b7.b7b8")+",")
					.append(resultmap.get("b7.b7b9")+",")
					.append(resultmap.get("b7.b7b10")+",")
					.append(resultmap.get("b7.b7b11")+",")
					.append(resultmap.get("b7.b7b12")+",")
					.append(resultmap.get("b7.b7b13")+",")
					.append(resultmap.get("b7.b7b14")+",")
					.append(resultmap.get("b7.b7b15")+",")
					.append(resultmap.get("b7.b7b16")+",")
					.append(resultmap.get("b7.b7b17")+",")
					.append(resultmap.get("b7.b7b18")+",")
					.append(resultmap.get("b7.b7b19")+",")
					.append(resultmap.get("b7.b7c1")+",")
					.append(resultmap.get("b7.b7c2")+",")
					.append(resultmap.get("b7.b7c3")+",")
					.append(resultmap.get("b7.b7c4")+",")
					.append(resultmap.get("b7.b7a2"))
					
					.append(")");

			insert_sql.append(";\n");
			writefile(insert_sql.toString());
		}
	}
	private void writefile(String s){
		try {
			File f=new File("d:\\jxq_soft\\tbsrsp\\tbscenter\\web\\tmd\\metadatasql.sql");
			PrintWriter pw=new PrintWriter(f,"utf-8");
			pw.write(s);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//兼容方法
	public Map<String,String> doing() throws SQLException{
		Connection con=this.conn;
		String id="";
		String b1sql="select * from b1 where id=14";
		PreparedStatement pstm=con.prepareStatement(b1sql);
		ResultSet rs=pstm.executeQuery();
		//while(rs.next()){
			rs.next();return doing(rs);
		//}
	}
	public Map<String,String> doing(ResultSet rs) throws SQLException{
		Connection con=this.conn;
		Map<String,String> result;
		
		//String id="";
		//String b1sql="select * from b1 where id=14";
		//PreparedStatement pstm=con.prepareStatement(b1sql);
		//ResultSet rs=pstm.executeQuery();
		
		//while(rs.next()){
			result=this.initMap();
			String b1b,b1c,b2b,b2c,b2e,b4c,b5b,b5e,b5f;
			
			//获得一条元数据的id
			String b1id=rs.getString("id");
			//把id放到map中
			result.put("b1.id", b1id);


			result.put("b1.b1a2", rs.getString("b1a2"));
			result.put("b1.b1a3", rs.getString("b1a3"));
			result.put("b1.b1a4", rs.getString("b1a4"));
			result.put("b1.b1a5", rs.getString("b1a5"));
			result.put("b1.b1a6", rs.getString("b1a6"));
			result.put("b1.b1d1", rs.getString("b1d1"));
			
			
			result.put("b1.username", rs.getString("username"));
			result.put("b1.verify", rs.getString("verify"));
			result.put("b1.verifyusername", rs.getString("verifyusername"));
			result.put("b1.xmlflag", rs.getString("xmlflag"));
			result.put("b1.onlineflag", rs.getString("onlineflag"));
			result.put("b1.xmlflag2", rs.getString("xmlflag2"));
			
			
			
			
			//获得b1b外键，从b8中得到相应id的记录
			b1b=rs.getString("b1b");
			this.lianxiren("b1b", b1b, con, result);
			
			//获得b1c外键，从b9中得到相应id的记录
			b1c=rs.getString("b1c");
			this.xianzhi("b1c", b1c, con, result);
			
			String[] b2cols=new String[]{
					"b2a1",
					"b2a2",
					"b2a3",
					"b2a4",
					"b2a5",
					"b2a6",
					"b2a7",
					"b2a8",
					"b2a9",
					"b2a10",
					"b2d1",
					"b2d2",
					"b2d3",
					"b2a11",
					"b2a12",
					"b2a13",
					"b2a14",
					"b2a15",
					"b2a16",
					"b2a17",
					"b2a18",
					"b2a19",
					"b2a20",
					"b2a21",
					"b2a22",
					"b2a23"
			};
			this.tableRetreive("b2", b1id, b2cols, new String[]{"b2b","b2c","b2e"}, con, result);
			
			
			String [] b3cols=new String[]{
					"b3a1",
					"b3a2",
					"b3a3"
			};
			this.tableRetreive("b3", b1id, b3cols, new String[]{}, con, result);
			
			
			String [] b4cols=new String[]{
					"b4b1",
					"b4b2",
					"b4b3",
					"b4d1",
					"b4d2",
					"b4a1",
					"b4a2",
					"b4a3"
			};
			this.tableRetreive("b4", b1id, b4cols, new String[]{"b4c"}, con, result);
			
			
			String[] b5cols=new String[]{
					"b5a1",
					"b5c1",
					"b5c2",
					"b5c3",
					"b5c4",
					"b5c5",
					"b5d1",
					"b5d2",
					"b5d3",
					"b5d4",
					"b5d5",
					"b5d6",
					"b5d7",
					"b5d8",
					"b5a2"
			};
			this.tableRetreive("b5", b1id, b5cols, new String[]{"b5b","b5e","b5f"}, con, result);
			
			
			String[] b6cols=new String[]{
					"b6a1",
					"b6a2",
					"b6a3",
					"b6a4",
					"b6a5",
					"b6a6",
					"b6b1",
					"b6b2",
					"b6b3",
					"b6b4",
					"b6b5",
					"b6b6",
					"b6b7",
					"b6b8",
					"b6b9",
					"b6b10",
					"b6b11",
					"b6b12",
					"b6b13",
					"b6b14",
					"b6b15",
					"b6b16",
					"b6b17",
					"b6b18",
					"b6c1",
					"b6c2",
					"b6d1",
					"b6d2"
			};
			this.tableRetreive("b6", b1id, b6cols, new String[]{}, con, result);
			
			
			String[] b7cols=new String[]{
					"b7a1",
					"b7b1",
					"b7b2",
					"b7b3",
					"b7b4",
					"b7b5",
					"b7b6",
					"b7b7",
					"b7b8",
					"b7b9",
					"b7b10",
					"b7b11",
					"b7b12",
					"b7b13",
					"b7b14",
					"b7b15",
					"b7b16",
					"b7b17",
					"b7b18",
					"b7b19",
					"b7c1",
					"b7c2",
					"b7c3",
					"b7c4",
					"b7a2"
			};
			this.tableRetreive("b7", b1id, b7cols, new String[]{}, con, result);
			
			
//			String b2sql="select * from b2 where id=?";
//			PreparedStatement b2pstm=con.prepareStatement(b2sql);
//			b2pstm.setString(1, b1id);
//			ResultSet b2rs=pstm.executeQuery(b2sql);
//			if(b2rs.next()){
//				result.put("b2.b2a1", b2rs.getString("b2a1"));
//				result.put("b2.b2a2", b2rs.getString("b2a2"));
//				result.put("b2.b2a3", b2rs.getString("b2a3"));
//				result.put("b2.b2a4", b2rs.getString("b2a4"));
//				result.put("b2.b2a5", b2rs.getString("b2a5"));
//				result.put("b2.b2a6", b2rs.getString("b2a6"));
//				
//				b2b=b2rs.getString("b2b");
//				this.lianxiren("b2b", b2b, con, result);
//				
//				
//				b2c=b2rs.getString("b2c");
//				this.lianxiren("b2c", b2c, con, result);
//				
//				
//				b2e=b2rs.getString("b2e");
//				this.xianzhi("b2e", b2e, con, result);
//				
//				
//				result.put("b2.b2a7", b2rs.getString("b2a7"));
//				result.put("b2.b2a8", b2rs.getString("b2a8"));
//				result.put("b2.b2a9", b2rs.getString("b2a9"));
//				result.put("b2.b2a10", b2rs.getString("b2a10"));
//				
//				
//				result.put("b2.b2d1", b2rs.getString("b2d1"));
//				result.put("b2.b2d2", b2rs.getString("b2d2"));
//				result.put("b2.b2d3", b2rs.getString("b2d3"));
//				result.put("b2.b2a11", b2rs.getString("b2a11"));
//				result.put("b2.b2a12", b2rs.getString("b2a12"));
//				result.put("b2.b2a13", b2rs.getString("b2a13"));
//				result.put("b2.b2a14", b2rs.getString("b2a14"));
//				result.put("b2.b2a15", b2rs.getString("b2a15"));
//				result.put("b2.b2a16", b2rs.getString("b2a16"));
//				result.put("b2.b2a17", b2rs.getString("b2a17"));
//				
//				
//				result.put("b2.b2a18", b2rs.getString("b2a18"));
//				result.put("b2.b2a19", b2rs.getString("b2a19"));
//				result.put("b2.b2a20", b2rs.getString("b2a20"));
//				result.put("b2.b2a21", b2rs.getString("b2a21"));
//				result.put("b2.b2a22", b2rs.getString("b2a22"));
//				result.put("b2.b2a23", b2rs.getString("b2a23"));
//			}
			
			
		
		//}
		return result;
	}
	
	/**
	 * 
	 * @param tableName 需要遍历的表
	 * @param id		表主键
	 * @param cols		表字段名
	 * @param fks		外键字段名
	 * @throws SQLException 
	 */
	private void tableRetreive(String tableName,String id,String[] cols,String[] fks,Connection con,Map result) throws SQLException{
		if(id!=null && !(id.trim().equals(""))){//System.out.println("id:"+id+"\ntable:"+tableName);
			String sql="select * from "+tableName+" where id=?";
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, Integer.valueOf(id));//id
			ResultSet rs=pstm.executeQuery();
			if(rs.next()){
				for(String col:cols){//System.out.println("col:"+col);
					result.put(tableName+"."+col, rs.getString(col));
				}
				
				for(String fk:fks){System.out.println("fk:"+fk);
					String fkid=rs.getString(fk);
					
					if(fk.equals("b2b")){
						this.lianxiren("b2b", fkid, con, result);
					}
					if(fk.equals("b2c")){
						this.lianxiren("b2c", fkid, con, result);
					}
					if(fk.equals("b2e")){
						this.xianzhi("b2e", fkid, con, result);
					}
					if(fk.equals("b4c")){
						this.lianxiren("b4c", fkid, con, result);
					}
					if(fk.equals("b5b")){
						this.fanwei("b5b", fkid, con, result);
					}
					if(fk.equals("b5e")){
						this.lianxiren("b5e", fkid, con, result);
					}
					if(fk.equals("b5f")){
						this.fanwei("b5f", fkid, con, result);
					}
				}
			}
		}
	}
	
	private void lianxiren(String fkname,String id,Connection con,Map result) throws SQLException{
		result.put(fkname+".b8a1",null);
		result.put(fkname+".b8a2",null);
		result.put(fkname+".b8a3",null);
		result.put(fkname+".b8a4",null);
		result.put(fkname+".b8a5",null);
		result.put(fkname+".b8a6",null);
		result.put(fkname+".b8a7",null);
		result.put(fkname+".b8a8",null);
		result.put(fkname+".b8a9",null);
		result.put(fkname+".b8a10",null);
		result.put(fkname+".b8a11",null);
		result.put(fkname+".b8a12",null);
		
		if(id!=null && !(id.trim().equals(""))){
			String lxr_sql="select id,b8a1,b8a2,B8a3,B8a4,B8a5,B8a6,B8a7,B8a8,B8a9,B8a10,B8a11,B8a12 from b8 where id=?";
			PreparedStatement lxr_pstm=con.prepareStatement(lxr_sql);
			lxr_pstm.setString(1, id);
			ResultSet lxr_rs=lxr_pstm.executeQuery();
			if(lxr_rs.next()){
				result.put(fkname+".b8a1",lxr_rs.getString("b8a1"));
				result.put(fkname+".b8a2",lxr_rs.getString("b8a2"));
				result.put(fkname+".b8a3",lxr_rs.getString("B8a3"));
				result.put(fkname+".b8a4",lxr_rs.getString("B8a4"));
				result.put(fkname+".b8a5",lxr_rs.getString("B8a5"));
				result.put(fkname+".b8a6",lxr_rs.getString("B8a6"));
				result.put(fkname+".b8a7",lxr_rs.getString("B8a7"));
				result.put(fkname+".b8a8",lxr_rs.getString("B8a8"));
				result.put(fkname+".b8a9",lxr_rs.getString("B8a9"));
				result.put(fkname+".b8a10",lxr_rs.getString("B8a10"));
				result.put(fkname+".b8a11",lxr_rs.getString("B8a11"));
				result.put(fkname+".b8a12",lxr_rs.getString("B8a12"));
			}
		}
	}
	
	private void xianzhi(String fkname,String id,Connection con,Map result) throws SQLException{
		result.put(fkname+".b9a1",null);
		result.put(fkname+".b9a2",null);
		result.put(fkname+".b9a3",null);
		result.put(fkname+".b9a4",null);
		
		if(id!=null && !(id.trim().equals(""))){
			String xz_sql="select id,B9a1,B9a2,B9a3,B9a4 from b9 where id=?";
			PreparedStatement xz_pstm=con.prepareStatement(xz_sql);
			xz_pstm.setString(1, id);
			ResultSet xz_rs=xz_pstm.executeQuery();
			if(xz_rs.next()){
				result.put(fkname+".b9a1",xz_rs.getString("B9a1"));
				result.put(fkname+".b9a2",xz_rs.getString("B9a2"));
				result.put(fkname+".b9a3",xz_rs.getString("B9a3"));
				result.put(fkname+".b9a4",xz_rs.getString("B9a4"));
			}
		}
	}
	
	private void fanwei(String fkname,String id,Connection con,Map result) throws SQLException{
		result.put(fkname+".b10a1",null);
		result.put(fkname+".b10a2",null);
		result.put(fkname+".b10a3",null);
		result.put(fkname+".b10a4",null);
		result.put(fkname+".b10a5",null);
		
		if(id!=null && !(id.trim().equals(""))){
			String xz_sql="select id,B10a1,B10a2,B10a3,B10a4,B10a5 from b10 where id=?";
			PreparedStatement xz_pstm=con.prepareStatement(xz_sql);
			xz_pstm.setString(1, id);
			ResultSet xz_rs=xz_pstm.executeQuery();
			if(xz_rs.next()){
				result.put(fkname+".b10a1",xz_rs.getString("b10a1"));
				result.put(fkname+".b10a2",xz_rs.getString("b10a2"));
				result.put(fkname+".b10a3",xz_rs.getString("b10a3"));
				result.put(fkname+".b10a4",xz_rs.getString("b10a4"));
				result.put(fkname+".b10a5",xz_rs.getString("b10a5"));
			}
		}
	}
	
	public Map<String,String> entry(){
		try {
			return this.doing();
		} catch (SQLException e) {
			e.printStackTrace();//throw new RuntimeException(e);
		}finally{
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public void doAllForLink()throws SQLException{
		Connection con=this.conn;
		String id="";
		String b1sql="select id,username,verify,verifyusername,xmlflag,onlineflag,xmlflag2 from b1";
		PreparedStatement pstm=con.prepareStatement(b1sql);
		ResultSet rs=pstm.executeQuery();
		StringBuilder insert_sql=new StringBuilder();
		while(rs.next()){
			String metadataId,username,verify,verifyusername,xmlflag,onlineflag,xmlflag2;
			metadataId=rs.getString("id");
			username=rs.getString("username");
			verify=rs.getString("verify");
			verifyusername=rs.getString("verifyusername");
			xmlflag=rs.getString("xmlflag");
			onlineflag=rs.getString("onlineflag");
			xmlflag2=rs.getString("xmlflag2");

			insert_sql.append("insert into temp(id,username,verify,verifyusername,xmlflag,onlineflag,xmlflag2) values(")
			.append("'"+metadataId+"'")
			.append(",")
			.append("'"+username+"'")
			.append(",")
			.append("'"+verify+"'")
			.append(",")
			.append("'"+verifyusername+"'")
			.append(",")
			.append("'"+xmlflag+"'")
			.append(",")
			.append("'"+onlineflag+"'")
			.append(",")
			.append("'"+xmlflag2+"'")
			.append(");\n");

		}
		
		
		try {
			File f=new File("d:\\jxq_soft\\tbsrsp\\tbscenter\\web\\tmd\\metadataverify.sql");
			PrintWriter pw=new PrintWriter(f,"utf-8");
			pw.write(insert_sql.toString());
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
