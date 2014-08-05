package com.course.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckAdminPublic implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.out.println("------CheckRole.destroy------");
	}

	@Override
	public void init() {
		System.out.println("------CheckRole.init------");

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("------CheckRole.intercept------");
		Map session=ActionContext.getContext().getSession();

		if("admin".equals(session.get("user.role")) || "public".equals(session.get("user.role")) || "super".equals(session.get("user.role"))){
			return arg0.invoke();
		}
		
		return "checkRoleFail";
	}
}

