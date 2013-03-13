package controllers;

import java.util.List;

import models.Exam;

public class CSVHandler {

	
//	public List<Exam> readFromCSV(){
//		
//	}
	
//	public static void main(String[] args) {
//		String str=Play.configuration.getProperty("application.mode");
//		System.out.println(str);
//	}
	/**
	private static ResourceBundle resourceBundle;

	static {
		resourceBundle = ResourceBundle.getBundle("resources/system");
	}

	public static void main(String[] args) {
		try {
			String path = resourceBundle.getString("csvFile");
			System.out.println(path);
			// File file = Play.applicationPath;

			File csv = new File(
					"D:/play-1.2.4/play-1.2.4/onlineExam/conf/examBank.csv"); // CSV数据文件

			BufferedReader br = new BufferedReader(new FileReader(csv));
			// 要阅读的最后一行
			while (br.ready()) {
				String line = br.readLine();
				// 数据元素分为一行
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens()) {
					// 每个元素都显示在一个制表符分隔的线
					System.out.print(st.nextToken() + "\t");
				}
				System.out.println();
			}
			br.close();

		} catch (FileNotFoundException e) {
			// File对象的创建过程中的异常捕获
			e.printStackTrace();
		} catch (IOException e) {
			// BufferedReader在关闭对象捕捉异常
			e.printStackTrace();
		}
	}**/
}
