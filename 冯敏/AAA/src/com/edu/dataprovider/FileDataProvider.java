package com.edu.dataprovider;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileDataProvider {


	public Object[][] getTestDataByTxt(String fileName) {
		File file = new File(fileName);
		Object[][] data = null;
		FileInputStream fis = null;
		InputStreamReader isreader = null;
		BufferedReader breader = null;
		String record;
		try {
			fis = new FileInputStream(file);
			isreader = new InputStreamReader(fis, "UTF-8");
			// �趨utf-8,ʹ�ô����������ַ�������BufferedReader��ȡ�ļ�����
			breader = new BufferedReader(isreader);
			int cols = 0;
			// ���Ե�һ��
			record = breader.readLine();
			if (null == record) {
				return null;
			} else {
				cols = record.split("\t").length;
			}
			List<String> datalist = new ArrayList<String>();
			while ((record = breader.readLine()) != null) {
				datalist.add(record);
			}
			data = new Object[datalist.size()][cols];
			String[] strs;
			for (int i = 0; i < datalist.size(); i++) {
				strs = datalist.get(i).split("\t");
				for (int j = 0; j < cols; j++) {
					data[i][j] = strs[j];
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	
 

}
