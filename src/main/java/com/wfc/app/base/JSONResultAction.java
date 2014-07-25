package com.wfc.app.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/7/2.
 */
public class JSONResultAction extends BaseAction {

    public static final String JR_STATE = "state";
    public static final String JR_MESSAGE = "message";
    public static final String JR_DATA = "data";
    public static final String JR_COUNT = "count";
    public static final String JSON_RESULT = "json_result";

    protected Map<String,Object> jsonResult;

    public Map<String, Object> getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(Map<String, Object> jsonResult) {
        this.jsonResult = jsonResult;
    }

    public JSONResultAction(){
        super();
        jsonResult = new HashMap<String, Object>();

    }

    public void resetJsonResult(){
        jsonResult.put(JR_STATE,null);
        jsonResult.put(JR_MESSAGE,null);
        jsonResult.put(JR_DATA,null);
    }
}
