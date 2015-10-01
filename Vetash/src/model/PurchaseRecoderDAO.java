package model;

import java.util.List;

public interface PurchaseRecoderDAO {
	
	public abstract PurchaseRecordBean insert(PurchaseRecordBean bean);
	
	public abstract List<PurchaseRecordBean> select();
	
	public abstract List<PurchaseRecordBean> selectByDate(String date);
	
	public abstract List<PurchaseRecordBean> selectByType(String type);
	
	public abstract List<PurchaseRecordBean> selectByProductId(String productId);
	
}
