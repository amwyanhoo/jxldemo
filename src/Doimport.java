import java.io.*;
import java.util.List;

import bb.Tbaudit;

public class Doimport {

	public static void main(String args[]) throws Exception {
//		String excelPath = "D:\\TBAUDITINFO_2017-01-06 190750.xls";
//		InputStream fis = new FileInputStream(excelPath);
//		// �õ�����Excel��ʵ�弯��
//		List<TbauditInfo> infos = ImportEmployee.importEmployee(fis);
//
//		// ��������Excel��ʵ�弯��
//		for (TbauditInfo info : infos) {
//
//			System.out.println(info.getIauditid());
//		}
//		// �ر���
//		fis.close();
		
		
//		String cmdText = "ping  127.0.0.1"; 
//        Runtime run = Runtime.getRuntime();
//        try {
//            // run.exec("cmd /k shutdown -s -t 3600");
//            Process process = run.exec("cmd.exe /k start /b" + cmdText);
//            InputStream in = process.getInputStream();
//            while (in.read() != -1) {
//                System.out.println(in.read());
//            }
//            in.close();
//            process.waitFor();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
		
		Getpath.getAppPath(Tbaudit.class);
		String path = System.getProperty("user.dir").replace("bin", "webapps");
		System.out.println(path);
		
	}
}
