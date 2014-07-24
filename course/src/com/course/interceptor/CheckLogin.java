package com.course.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckLogin implements Interceptor {

	@Override
	public void destroy() {
		System.out.println("------CheckLogin.destroy------");
	}

	@Override
	public void init() {
		System.out.println("------CheckLogin.init------");

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		System.out.println("------CheckLogin.intercept------");
		
		Map session=ActionContext.getContext().getSession();
		//Map userinfo=arg0.getInvocationContext().getParameters();
		
		//String username=session.get("user.name").toString();

		//String[] loginUsername=(String[])parameters.get("user.name");
		
		if(session.get("user.name")!=null)
		{
			return arg0.invoke();
		}
		
		return "checkLoginFail";
	}

}

