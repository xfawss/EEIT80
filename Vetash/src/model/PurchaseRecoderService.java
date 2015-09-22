package model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import misc.Parse;

@Component(value="PurchaseRecoderService")
public class PurchaseRecoderService {
	
	@Autowired
	private PurchaseRecoderDAO dao;
	
	private List<Map<String, Object>> jfomat(List<PurchaseRecordBean> beans){
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		for(PurchaseRecordBean bean : beans) {
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("recordNo", bean.getRecordNo());
			map.put("date", Parse.dateToString(bean.getDate()));
			map.put("type", bean.getType());
			if(bean.getNotes() == null) {
				map.put("notes", "");
			} else {
				map.put("notes", bean.getNotes());
			}
			map.put("productId", bean.getProductId());
			map.put("number", bean.getNumber());
			map.put("prize", bean.getPrize());
			map.put("supplierId", bean.getSupplierId());
			result.add(map);
		}
		return result;
	}
	
	public List<Map<String, Object>> select(){
		return this.jfomat(dao.select());
	}
	
	public List<Map<String, Object>> selectByDate(Date date){
		return this.jfomat(dao.selectByDate(date));
	}
	
	public List<Map<String, Object>> selectByType(String type){
		return this.jfomat(dao.selectByType(type));
	}
	
	public List<Map<String, Object>> selectByProductId(String productId){
		return this.jfomat(dao.selectByProductId(productId));
	}
	
	public List<Map<String, Object>> selectBySupplierId(int supplierId){
		return this.jfomat(dao.selectBySupplierId(supplierId));
	}
	
	public PurchaseRecordBean insert(PurchaseRecordBean bean){
		return (PurchaseRecordBean)dao.insert(bean);
	}
	
}
