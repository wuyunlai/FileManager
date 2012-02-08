/**
 * 
 */
package com.wyl.env;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author wuyl
 *
 */
public class Constant {
	
	public static WebApplicationContext wact;
	
	public static String JndiName;
	
	public static final String HTTP_CONTENT_TYPE_GB2312 = "text/html; charset=gb2312";
	
	public static final String CHARACTER_ENCODING_GB2312 = "gb2312";
	
	public static DataSource DATASOURCE = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
