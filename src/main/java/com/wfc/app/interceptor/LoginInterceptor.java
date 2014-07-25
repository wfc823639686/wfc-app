package com.wfc.app.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.wfc.app.util.Constants;

import java.util.Map;

/**
 * Created by Administrator on 2014/6/27.
 */
public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext ctx = actionInvocation.getInvocationContext();
        Map session = ctx.getSession();

        Object user = session.get(Constants.USER_INFO);
        if(user != null){
            return actionInvocation.invoke();
        }
        ctx.put(Constants.MSG, "您还没有登录，请登录...");
        return Constants.LOGIN;
    }
}
