package com.wfc.app.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.wfc.app.base.BaseAction;
import com.wfc.app.base.JSONResultAction;

/**
 * Created by Administrator on 2014/7/3.
 */
public class ResetEmptyInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        BaseAction baseAction = (BaseAction) actionInvocation.getAction();
        baseAction.map.clear();
        if(baseAction instanceof JSONResultAction){
            JSONResultAction jrAction = (JSONResultAction)baseAction;
            jrAction.resetJsonResult();
        }
        return actionInvocation.invoke();
    }
}
