package com.wfc.app.base;

import com.opensymphony.xwork2.ActionSupport;
import com.wfc.app.util.Constants;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/6/27.
 */

public class BaseAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {
    protected HttpServletRequest request;
    /** Response 对象 **/
    protected HttpServletResponse response;
    /** Session 对象 **/
    protected Map<String,Object> session;

    /** 
     * 设置Request对象 
     */
    final public void setServletRequest(HttpServletRequest request){this.request=request;}
    /** 
     * 设置Session对象 
     */
    final public void setSession(Map<String,Object> session){this.session=session;}
    /** 
     * 设置Response对象 
     */
    final public void setServletResponse(HttpServletResponse response){this.response=response;}

    public Map<String,Object> map = new HashMap<String,Object>();

    protected String SORT = "sort";
}
