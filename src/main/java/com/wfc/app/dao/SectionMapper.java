package com.wfc.app.dao;

import com.wfc.app.base.Paging;
import com.wfc.app.po.Section;
import com.wfc.app.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/7/3.
 */
public interface SectionMapper extends Paging<Section> {

    /**
     * findSectionById
     * @param id
     * @return
     */
    @Select("select * from section where id=#{id}")
    @ResultMap("section")
    Section findSectionById(@Param("id") int id);

    /**
     * addSection
     * @param section
     * @return
     */
    @Insert("insert into section(title,content,cover_url,create_time)"+
            " values(#{section.title},#{section.content},#{section.coverUrl},#{section.createTime})")
    int addSection(@Param("section") Section section) throws Exception;

    /**
     * paging
     * @param map
     * @param startPos
     * @param pageSize
     * @return
     */
    @Select("select * from section limit #{startPos},#{pageSize}")
    @ResultMap(value = "section")
    @Override
    List<Section> paging(@Param("map") Map<String, Object> map, @Param("startPos") int startPos, @Param("pageSize") int pageSize);
}
