package com.mercury.finalProject.serviceHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mercury.finalProject.bean.ShelvesProduct;
import com.mercury.finalProject.bean.VisitHistory;
import com.mercury.finalProject.dao.VisitHistoryDao;

@Component
@Scope("prototype")
public class ProductHelper {
	@Autowired
	private VisitHistoryDao vhd;
	
	public List<ShelvesProduct> visitHistoryAndShelvesSort(List<ShelvesProduct> spl) { 
		if (spl == null) return null;
		List<VisitHistory> vhls = vhd.findAll();
		List<ShelvesProduct> result = new ArrayList();
		List<Map.Entry<Integer, Integer>> sortList = new ArrayList<Map.Entry<Integer, Integer>>();
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		Iterator<VisitHistory> i = vhls.iterator();
		while (i.hasNext()) {
			VisitHistory vh = i.next();
			map.put(vh.getProductId(),map.getOrDefault(vh.getProductId(), 0) + 1);
		}
		sortList.addAll(map.entrySet());
		Collections.sort(sortList,(e1, e2) -> {
			return e2.getValue() - e1.getValue();
		});
		for (Map.Entry<Integer, Integer> m: sortList) {
			for (int index = 0; index < spl.size();index ++) {
				if (spl.get(index).getProductId() == m.getKey()) {
					result.add(spl.get(index));
					spl.remove(index --);
					break;
				}
			}
		}
		Collections.sort(spl, (s1,s2) -> {
			return s2.getId() - s1.getId();
		});
		result.addAll(spl);
		return result;
	}
}
