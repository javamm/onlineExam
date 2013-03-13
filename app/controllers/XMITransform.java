package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

/**
 * 从java对象转为xml，或从xml文件转为java对象
 * 
 * @author Beni
 */
public class XMITransform {

	private static final Logger logger = Logger.getLogger(XMITransform.class);

	/**
	 * 将bean生成对应的xml文件
	 * 
	 * @param filePath
	 * @param encoding
	 */
	public static void toFile(String filePath, String encoding, Class clazz,
			Object obj) {
		OutputStream outputStream = null;
		try {

			File file = new File(filePath);
			if (!file.exists()) {

				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				file.createNewFile();
			}

			outputStream = new FileOutputStream(filePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

			marshaller.marshal(obj, outputStream);
		} catch (FileNotFoundException e) {
			logger.error("this file not exist:" + filePath, e);
		} catch (IOException e) {
			logger.error("this file not exist:" + filePath, e);
		} catch (JAXBException e) {
			logger.error("fail to transform bean to xml:" + filePath, e);
		} finally {

			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				logger.error("fail to close outputStream", e);
			}
		}
	}

	/**
	 * 将xml文件生成bean对象
	 * 
	 * @param filePath
	 * @return
	 */
	public static Object loadFile(String filePath, Class clazz) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			InputStreamReader reader = new InputStreamReader(inputStream,
					"UTF-8");
			return unmarshaller.unmarshal(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error("this file not exist:" + filePath);
		} catch (JAXBException e) {
			e.printStackTrace();
			logger.error("fail to transform xml to bean:" + filePath);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("解压zip包的xml文件失败:" + filePath);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				logger.error("fail to close inputStream");
			}
		}

		return null;

	}
}
