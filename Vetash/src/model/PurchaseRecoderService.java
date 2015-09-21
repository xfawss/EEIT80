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
			map.put("RecordNo", bean.getRecordNo());
			map.put("Date", Parse.dateToString(bean.getDate()));
			map.put("Type", bean.getType());
			if(bean.getNotes() == null) {
				map.put("Notes", "");
			} else {
				map.put("Notes", bean.getNotes());
			}
			map.put("ProductId", bean.getProductId());
			map.put("Number", bean.getNumber());
			map.put("Prize", bean.getPrize());
			map.put("SupplierId", bean.getSupplierId());
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
