package com.bar3.dao;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bar3.basedao.KindDao;
import com.bar3.domain.Kind;

public class KindDaoImpTest {
    private static KindDao kindDao=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	    kindDao=KindDaoImp.getInstance();
	}

	@Test
	public void testGetAllKinds() {
		Map<Kind, List<Kind>> kindsMap=kindDao.getAllKinds();
		for(Map.Entry<Kind, List<Kind>> entry:kindsMap.entrySet()){
			System.out.print(entry.getKey().getKindName()+":");
			for(Kind kind:entry.getValue()){
				System.out.print(kind.getKindName()+" / ");
			}
			System.out.println();
		}
	}

}
