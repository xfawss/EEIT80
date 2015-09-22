package model;

import java.util.List;

public interface CustomerDAO {
	public abstract CustomerBean selectByTel(String customerTel);

	public abstract List<CustomerBean> selectAll();

	public abstract int insert(CustomerBean bean);

	public abstract int update(String customerName, String customerTel,String customerLine,
			String customerFb, String customerMail,String customerAddr,String customerNote);

	public abstract int delete(String customerTel);
	
	public abstract List<CustomerBean> selectLikeName(String customerName);
	public abstract List<CustomerBean> selectLikeLine(String customerLine);
	public abstract List<CustomerBean> selectLikeFb(String customerFb);
	public abstract List<CustomerBean> selectLikeMail(String customerMail);
	public abstract List<CustomerBean> selectLikeNote(String customerNote);

}
