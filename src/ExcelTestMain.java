import java.io.File;
import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ExcelTestMain {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static List logsList = null;
	static ExcelUtil excelUtil = new ExcelUtil();

	public static void main(String args[]) throws Exception {
		MysqlConnect mycon = new MysqlConnect();
		conn = mycon.getConnect();
		String sql = "select * from tbauditinfo";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		logsList = new ArrayList();
		TbauditInfo logsVo = new TbauditInfo();
		while (rs.next()) {
			logsVo.setIauditid(rs.getLong(1));
			logsVo.setCoperatorsn(rs.getString(2));
			rs.getShort(3);
			if(!rs.wasNull()){
				logsVo.setIoptype(rs.getShort(3));
			}
			logsVo.setCopcontent(rs.getString(4));
			rs.getShort(5);
			if(!rs.wasNull()){
				logsVo.setIeventresult(rs.getShort(5));
			}
			logsVo.setCopersignature(rs.getString(6));
			if(rs.getTimestamp(7)!=null){
				logsVo.setDopstart(new Date(rs.getTimestamp(7).getTime()));
			}
			if(rs.getTimestamp(8)!=null){
				logsVo.setDopend(new Date(rs.getTimestamp(8).getTime()));
			}
			if(rs.getTimestamp(9)!=null){
				logsVo.setDaudittime(new Date(rs.getTimestamp(9).getTime()));
			}
			rs.getShort(10);
			if(!rs.wasNull()){
				logsVo.setIauditresult(rs.getShort(10));
			}
			logsVo.setCauditopersn(rs.getString(11));
			logsVo.setCauditopersign(rs.getString(12));
			logsVo.setCopername(rs.getString(13));
			logsVo.setCauditoption(rs.getString(14));
			logsList.add(logsVo);
		}
		File file = new File("D:\\在用日志表.xls");
		excelUtil.createLogsExcelFile(logsList, file);

	}
}