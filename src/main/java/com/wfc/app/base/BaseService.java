package com.wfc.app.base;

import java.util.List;
import java.util.Map;

public abstract class BaseService<T> implements Paging<T>{
    public List<T> pagingByPage(Map<String,Object> map,int p,int pageSize){
        int startPos = p * pageSize;
        return paging(map,startPos,pageSize);
    }
}
