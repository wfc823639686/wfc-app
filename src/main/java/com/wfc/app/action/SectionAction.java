package com.wfc.app.action;

import com.wfc.app.base.JSONResultAction;
import com.wfc.app.po.Section;
import com.wfc.app.po.User;
import com.wfc.app.service.SectionService;
import com.wfc.app.service.UserService;
import com.wfc.app.util.Constants;
import com.wfc.app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/7/3.
 */
@Controller
public class SectionAction extends JSONResultAction {

    private Integer id;

    private Section section;

    private Integer p;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Section getSection() {
        return section;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    @Autowired
    private SectionService sectionService;

    public void setSectionService(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    public String find(){
        Section section = sectionService.findSectionById(id);
        if(section!=null&&section.getId()!=null){
            jsonResult.put(JR_STATE,1);
            jsonResult.put(JR_DATA,section);
        }else{
            jsonResult.put(JR_STATE,0);
        }
        return JSON_RESULT;
    }

    public String add() throws Exception {
        section.setCreateTime(""+ Utils.getNowUnix());
        int rs = sectionService.addSection(section);
        if(rs==0){
            jsonResult.put(JR_STATE,0);
        }else{
            jsonResult.put(JR_STATE,1);
        }
        jsonResult.put(JR_DATA,rs);
        return JSON_RESULT;
    }

    /**
     * action:section_list
     * params:p
     * @return
     */
    public String list(){
        List<Section> sectionList = sectionService.paging(map,p,10);
        if(sectionList!=null&&sectionList.size()>0){
            jsonResult.put(JR_DATA,sectionList);
            jsonResult.put(JR_STATE,1);
            jsonResult.put(JR_COUNT,sectionList.size());
        }else{
            jsonResult.put(JR_STATE,0);
        }
        return JSON_RESULT;
    }

}
