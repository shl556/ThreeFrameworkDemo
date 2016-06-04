package com.bar3.basedao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.bar3.domain.Kind;

public interface KindDao {
    /**
    * @Description: 根据版块id查找该版块下的所有子版块
    * @param parentKindId
    * @return     
    */
    public List<Kind> getChildKinds(Long kindId,Session session);
    /**
    * @Description: 查找所有的版块信息
    * @return  Map<Kind, Kind>，键为父版块,值为该版块下的子版块。
    */
    public Map<Kind,List<Kind>> getAllKinds();
}
