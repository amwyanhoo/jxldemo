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
	 * ����Excel�ļ��е����ݲ���ÿ�����ݷ�װ��һ��ʵ��
	 * 
	 * @param fis
	 *            �ļ�������
	 * @return List<EmployeeInfo> Excel�����ݷ�װʵ��ļ���
	 * @throws ParseException
	 */
	public static List<TbauditInfo> importEmployee(InputStream fis)
			throws ParseException {

		List<TbauditInfo> infos = new ArrayList<TbauditInfo>();
		TbauditInfo tbauditinfo = null;

		try {
			// ���ļ�
			Workbook book = Workbook.getWorkbook(fis);
			// �õ���һ�����������
			Sheet sheet = book.getSheet(0);
			// �õ���һ���������е�������
			int rowCount = sheet.getRows();
			// ���ڸ�ʽ��
			DateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// ѭ��ȡ��Excel�е�����
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