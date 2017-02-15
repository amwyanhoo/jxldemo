import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ImportEmployee {
	/**
	 * 解析Excel文件中的数据并把每行数据封装成一个实体
	 * 
	 * @param fis
	 *            文件输入流
	 * @return List<EmployeeInfo> Excel中数据封装实体的集合
	 * @throws ParseException
	 */
	public static List<TbauditInfo> importEmployee(InputStream fis)
			throws ParseException {

		List<TbauditInfo> infos = new ArrayList<TbauditInfo>();
		TbauditInfo tbauditinfo = null;

		try {
			// 打开文件
			Workbook book = Workbook.getWorkbook(fis);
			// 得到第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第一个工作表中的总行数
			int rowCount = sheet.getRows();
			// 日期格式化
			DateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 循环取出Excel中的内容
			for (int i = 1; i < rowCount; i++) {
				tbauditinfo = new TbauditInfo();
				Cell[] cells = sheet.getRow(i);
				tbauditinfo.setIauditid(Long.parseLong(cells[0].getContents()));
				tbauditinfo.setCoperatorsn(cells[1].getContents().toString());
				tbauditinfo
						.setIoptype(Short.parseShort(cells[2].getContents()));
				tbauditinfo.setCopcontent(cells[3].getContents().toString());
				tbauditinfo.setIeventresult(Short.parseShort(cells[4]
						.getContents()));
				tbauditinfo
						.setCopersignature(cells[5].getContents().toString());
				// tbauditinfo.setDopstart(new
				// Date(cells[6].getContents().toString()));
				tbauditinfo.setDopstart(ft.parse(cells[6].getContents()
						.toString()));
				tbauditinfo.setDopend(ft.parse(cells[7].getContents()
						.toString()));
				if (!cells[8].getContents().toString().equals("")) {
					tbauditinfo.setDaudittime(ft.parse(cells[8].getContents()
							.toString()));
				}
				if (!cells[9].getContents().toString().equals("")) {
					tbauditinfo.setIauditresult(Short.parseShort(cells[9]
							.getContents()));
				}
				if (!cells[10].getContents().toString().equals("")) {
					tbauditinfo.setCauditopersn(cells[10].getContents()
							.toString());
				}
				if (!cells[11].getContents().toString().equals("")) {
					tbauditinfo.setCauditopersign(cells[11].getContents()
							.toString());
				}
				if (!cells[12].getContents().toString().equals("")) {
					tbauditinfo
							.setCopername(cells[12].getContents().toString());
				}
				if (!cells[13].getContents().toString().equals("")) {
					tbauditinfo.setCauditoption(cells[13].getContents()
							.toString());
				}
				infos.add(tbauditinfo);
			}

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return infos;
	}
}