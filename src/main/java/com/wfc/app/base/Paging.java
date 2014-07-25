package com.wfc.app.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/7/3.
 */
public interface Paging <T>{
    List<T> paging(@Param("map") Map<String, Object> map, @Param("startPos") int startPos, @Param("pageSize") int pageSize);
}
