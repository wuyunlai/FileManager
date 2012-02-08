/**
 * 
 */
package com.wyl.env.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author wuyl
 *
 */
public class SpringContext implements ApplicationContextAware {

	protected static ApplicationContext context;

	/**
	 * 
	 */
	public SpringContext() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		// TODO Auto-generated method stub
		context = ctx;
	}

	public ApplicationContext getApplicationContext() {
		return context;
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static Object getBean(String name) {
		return getContext().getBean(name);
	}

	public ApplicationContext getApplicateContext(String method,
			String parameter) {
		ApplicationContext ctx = null;
		if (method.toLowerCase().trim().startsWith("file"))
			ctx = new FileSystemXmlApplicationContext(parameter);//"/WEB-INF/applicationContext-hibernate.xml"
		else if (method.toLowerCase().trim().startsWith("class"))
			ctx = new ClassPathXmlApplicationContext(parameter);//"applicationContext-hibernate.xml"
		;
		return ctx;
	}
}
