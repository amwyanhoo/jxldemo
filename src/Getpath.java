
public class Getpath {
	 public static String getAppPath(Class cls){  
	       //����û�����Ĳ����Ƿ�Ϊ�� cls:class com.util.PropertiesUtil  
	       if(cls==null) {  
	         throw new java.lang.IllegalArgumentException("��������Ϊ�գ�");  
	       }  
	         
	       ClassLoader loader=cls.getClassLoader();  
	       //������ȫ������������ //com.util.PropertiesUtil.class  
	       String clsName=cls.getName()+".class";  
	       //��ô���������ڵİ� package com.util  
	       Package pack=cls.getPackage();  
	       String path="";//�������Ӧ·��  
	       //���������������������ת��Ϊ·��  
	       if(pack!=null){  
	           String packName=pack.getName();//com.util  
	           //�˴����ж��Ƿ���Java������⣬��ֹ�û�����JDK���õ����  
	           if(packName.startsWith("java.")||packName.startsWith("javax.")){  
	           throw new java.lang.IllegalArgumentException("�벻Ҫ����ϵͳ�����࣡");  
	           }  
	             
	           //����������У�ȥ�������Ĳ��֣��������ļ��� PropertiesUtil.class  
	           clsName=clsName.substring(packName.length()+1);  
	           //�ж������Ƿ��Ǽ򵥰���������ǣ���ֱ�ӽ�����ת��Ϊ·��  
	           if(packName.indexOf(".")<0){  
	            path=packName+"/";  
	           }  
	           else{//�����հ�������ɲ��֣�������ת��Ϊ·��  
	               int start=0,end=0;  
	               end=packName.indexOf(".");  
	               while(end!=-1){  
	                   path=path+packName.substring(start,end)+"/";  
	                   start=end+1;  
	                   end=packName.indexOf(".",start);  
	               }  
	               path=path+packName.substring(start)+"/"; //com/util/  
	           }  
	       }  
	       //����ClassLoader��getResource�������������·����Ϣ�����ļ���  
	       //file:/D:/Workspaces/springjdbc/bin/com/util/PropertiesUtil.class  
	       java.net.URL url =loader.getResource(path+clsName);  
	       //��URL�����л�ȡ·����Ϣ  
	       //   /D:/Workspaces/springjdbc/bin/com/util/PropertiesUtil.class  
	       String realPath=url.getPath();  
	       //ȥ��·����Ϣ�е�Э����"file:"  
	       int pos=realPath.indexOf("file:");  
	       if(pos>-1){  
	        realPath=realPath.substring(pos+5);  
	       }  
	       //ȥ��·����Ϣ���������ļ���Ϣ�Ĳ��֣��õ������ڵ�·��  
	       pos=realPath.indexOf(path+clsName);  
	       realPath=realPath.substring(0,pos-1);//  /D:/Workspaces/springjdbc/bin  
	       //������ļ��������JAR���ļ���ʱ��ȥ����Ӧ��JAR�ȴ���ļ���  
	       if(realPath.endsWith("!")){  
	        realPath=realPath.substring(0,realPath.lastIndexOf("/"));  
	       }  
	             
	     /*------------------------------------------------------------ 
	      ClassLoader��getResource����ʹ����utf-8��·����Ϣ�����˱��룬��·�� 
	                   �д������ĺͿո�ʱ���������Щ�ַ�����ת�����������õ�����������������Ҫ 
	                    ����ʵ·�����ڴˣ�������URLDecoder��decode�������н��룬�Ա�õ�ԭʼ�� 
	                    ���ļ��ո�·�� 
	     -------------------------------------------------------------*/  
	      try{  
	         realPath=java.net.URLDecoder.decode(realPath,"utf-8");  
	      }catch(Exception e){  
	       throw new RuntimeException(e);  
	      }  
	        
	      return realPath;  
	   }  

}