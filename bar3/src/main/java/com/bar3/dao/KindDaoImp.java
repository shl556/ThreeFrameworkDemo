package com.bar3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;

import com.bar3.basedao.KindDao;
import com.bar3.domain.Kind;
import com.bar3.util.HibernateUtil;
import com.bar3.util.LogInit;

public class KindDaoImp implements KindDao{
	private Logger log=LogInit.getlog(getClass());
	@SuppressWarnings("unchecked")
	@Override
	public List<Kind> getChildKinds(Long kindId,Session session) {
		String hql="from Kind kind where kind.parentKindId=?";
		List<Kind> kinds=null;
		kinds=session.createQuery(hql)
				.setLong(0, kindId)
				.list();
		return kinds;
	}

	@Override
	public Map<Kind, List<Kind>> getAllKinds() {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
		Map<Kind, List<Kind>> kindsMap=new HashMap<Kind, List<Kind>>();
		try{
		transaction.begin();
		List<Kind> kinds=getChildKinds(new Long(0), session);
		if (kinds!=null) {
		   for(Kind kind:kinds){
			   List<Kind> childKinds=getChildKinds(kind.getId(), session);
			   kindsMap.put(kind, childKinds);
		   }
		}
		}catch(RuntimeException e){
			log.error("查找所有版块信息失败",e);
			throw new RuntimeException(e);
		}
		if (!kindsMap.isEmpty()) {
			log.info("查找所有版块信息成功");
		}
		return kindsMap;
	}
    public static KindDao getInstance(){
    	return new KindDaoImp();
    }
}
