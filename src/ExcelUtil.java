import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import jxl.Cell;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelUtil {
	// ���ⵥԪ���ʽ
	private static WritableCellFormat titleFormat = null;
	// �������ݵ�Ԫ���ʽ
	private static WritableCellFormat bodyFormat = null;
	// ע�͵�Ԫ���ʽ
	private static WritableCellFormat noteFormat = null;

	private static WritableCellFormat floatFormat = null;

	private static WritableCellFormat intFormat = null;

	private static WritableCellFormat stringFormat = null;

	private static boolean init = false;

	private static void init() throws WriteException{
		WritableFont font1, font2, font3, font4, font5;
		// Arial���壬9�ţ����壬��Ԫ���ɫ�����ֱ߿򣬾��ж���
		font1 = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD,
				false);
		titleFormat = new WritableCellFormat(font1);
		// titleFormat.setBackground(c)
		titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setAlignment(Alignment.CENTRE);
		// Arial���壬9�ţ����壬��Ԫ���ɫ�����ֱ߿����Ҿ��ж��룬��ֱ���ж��룬�Զ�����
		font2 = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD,
				false);
		noteFormat = new WritableCellFormat(font2);
		// noteFormat.setColour();
		noteFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		noteFormat.setAlignment(Alignment.CENTRE);
		noteFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		noteFormat.setWrap(true);
		// Arial���壬9�ţ��Ǵ��壬��Ԫ����ɫ�����ֱ߿�
		font3 = new WritableFont(WritableFont.ARIAL, 9, WritableFont.NO_BOLD,
				false);
		bodyFormat = new WritableCellFormat(font3);
		// bodyFormat.setColour.LIGHT_GREEN;
		bodyFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		// Arial���壬9�ţ��Ǵ��壬��Ԫ����ɫ�����ֱ߿�
		font4 = new WritableFont(WritableFont.ARIAL, 9, WritableFont.NO_BOLD,
				false);
		floatFormat = new WritableCellFormat(font4, NumberFormats.FLOAT);
		// floatFormat.setColour.LIGHT_GREEN);
		floatFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		// Arial���壬9�ţ��Ǵ��壬��Ԫ����ɫ�����ֱ߿�
		font4 = new WritableFont(WritableFont.ARIAL, 9, WritableFont.NO_BOLD,
				false);
		intFormat = new WritableCellFormat(font4, NumberFormats.INTEGER);
		// intFormat.setColour.LIGHT_GREEN);
		intFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

		init = true;

}

	public static void createLogsExcelFile(List<TbauditInfo> logsList, File destFile)
			throws WriteException, IOException {
		if (init == false)
			init();
		int index, row;
		WritableSheet sheet = null;
		WritableWorkbook book = null;
		book = Workbook.createWorkbook(destFile);
		//����sheet����
		sheet = book.createSheet("�û�������", 0);
		//���õ�0�п��Ϊ15
		sheet.setColumnView(0 , 8);
		sheet.setColumnView(1 , 33);
		sheet.setColumnView(2 , 8);
		sheet.setColumnView(3 , 30);
		sheet.setColumnView(4 , 13);
		sheet.setColumnView(5 , 35);
		sheet.setColumnView(6 , 18);
		sheet.setColumnView(7 , 18);
		sheet.setColumnView(8 , 18);
		sheet.setColumnView(9 , 13);
		sheet.setColumnView(10, 33);
		sheet.setColumnView(11, 35);
		sheet.setColumnView(12, 13);
		sheet.setColumnView(13, 15);
		// �ֶ���
		index = 0;
		//��0�У���0���б�������ΪIAUDITID
		sheet.addCell(new Label(index++, 0, "IAUDITID", titleFormat));
		sheet.addCell(new Label(index++, 0, "COPERATORSN", titleFormat));
		sheet.addCell(new Label(index++, 0, "IOPTYPE", titleFormat));
		sheet.addCell(new Label(index++, 0, "COPCONTENT", titleFormat));
		sheet.addCell(new Label(index++, 0, "IEVENTRESULT", titleFormat));
		sheet.addCell(new Label(index++, 0, "COPERSIGNATURE", titleFormat));
		sheet.addCell(new Label(index++, 0, "DOPSTART", titleFormat));
		sheet.addCell(new Label(index++, 0, "DOPEND", titleFormat));
		sheet.addCell(new Label(index++, 0, "DAUDITTIME", titleFormat));
		sheet.addCell(new Label(index++, 0, "IAUDITRESULT", titleFormat));
		sheet.addCell(new Label(index++, 0, "CAUDITOPERSN", titleFormat));
		sheet.addCell(new Label(index++, 0, "CAUDITOPERSIGN", titleFormat));
		sheet.addCell(new Label(index++, 0, "COPERNAME", titleFormat));
		sheet.addCell(new Label(index++, 0, "CAUDITOPTION", titleFormat));

		row = 1;
//		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (TbauditInfo logs : logsList) {
			if (logs == null)
				continue;
			index = 0;
			sheet.addCell(new Label(index++, row, Long.toString(logs.getIauditid()), 	bodyFormat));
			sheet.addCell(new Label(index++, row, logs.getCoperatorsn(),				bodyFormat));
			sheet.addCell(new Label(index++, row, Integer.toString(logs.getIoptype()),	bodyFormat));
			sheet.addCell(new Label(index++, row, logs.getCopcontent(), 				bodyFormat));
			sheet.addCell(new Label(index++, row, Integer.toString(logs.getIeventresult()),	bodyFormat));
			sheet.addCell(new Label(index++, row, logs.getCopersignature(), 				bodyFormat));
//			System.out.println(format1.format(logs.getDopstart()));
			if(logs.getDopstart()!=null){
				sheet.addCell(new Label(index++, row, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(logs.getDopstart()), bodyFormat));
			}else{
				sheet.addCell(new Label(index++, row, null, bodyFormat));
			}
			if(logs.getDopend()!=null){
				sheet.addCell(new Label(index++, row, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(logs.getDopend()), 	bodyFormat));
			}else{
				sheet.addCell(new Label(index++, row, null, bodyFormat));
			}
			if(logs.getDaudittime()!=null){
				sheet.addCell(new Label(index++, row, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(logs.getDaudittime()), bodyFormat));
			}else{
				sheet.addCell(new Label(index++, row, null, bodyFormat));
			}
			if(logs.getIauditresult()!=null){
				sheet.addCell(new Label(index++, row, Integer.toString(logs.getIauditresult()),	bodyFormat));
			}else{
				sheet.addCell(new Label(index++, row, null, bodyFormat));
			}
			sheet.addCell(new Label(index++, row, logs.getCauditopersn(), 				bodyFormat));
			sheet.addCell(new Label(index++, row, logs.getCauditopersign(), 				bodyFormat));
			sheet.addCell(new Label(index++, row, logs.getCopername(), 				bodyFormat));
			sheet.addCell(new Label(index++, row, logs.getCauditoption(), 				bodyFormat));
			row++;
		}
		book.write();
		if (book != null)
			book.close();

	}
}