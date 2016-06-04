package com.shl.javabeans.tools;

import java.util.Comparator;

import com.shl.javabeans.entity.Kind;

public class KindComparator implements Comparator<Kind>{

	@Override
	public int compare(Kind o1, Kind o2) {
		return o1.getKindid()-o2.getKindid();
	}
}
