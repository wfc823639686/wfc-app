package com.wfc.app.service;

import com.wfc.app.base.BaseService;
import com.wfc.app.dao.SectionMapper;
import com.wfc.app.po.Section;
import com.wfc.app.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/7/3.
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SectionService extends BaseService<Section> implements SectionMapper {
    @Autowired
   private SectionMapper sectionMapper;

    public void setSectionMapper(SectionMapper sectionMapper) {
        this.sectionMapper = sectionMapper;
    }

    @Override
    public Section findSectionById(@Param("id") int id) {
        return sectionMapper.findSectionById(id);
    }

    @Override
    public int addSection(@Param("user") Section section) throws Exception{
        return sectionMapper.addSection(section);
    }

    @Override
    public List<Section> paging(@Param("map") Map<String, Object> map,
                                @Param("startPos") int startPos,
                                @Param("pageSize") int pageSize) {
        return sectionMapper.paging(map,startPos,pageSize);
    }
}
