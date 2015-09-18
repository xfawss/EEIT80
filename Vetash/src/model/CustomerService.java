package model;

import java.util.ArrayList;
import java.util.List;

import model.dao.CustomerDAOJdbc;

public class CustomerService {
    private CustomerDAO customerDao = new CustomerDAOJdbc();
    public List<CustomerBean> selectLikeName( CustomerBean bean) {
    	List<CustomerBean> result =null;    	
    	//customerName有值
		result = customerDao.selectLikeName(bean.getCustomerName());
		return result;
    }  
    public List<CustomerBean> selectLikeLine( CustomerBean bean) {
    	List<CustomerBean> result =null;    	
    	//CustomerLine有值
		result = customerDao.selectLikeLine(bean.getCustomerLine());
		return result;
    }  
    public List<CustomerBean> selectLikeFb( CustomerBean bean) {
    	List<CustomerBean> result =null;    	
    	//CustomerFb有值
		result = customerDao.selectLikeFb(bean.getCustomerFb());
		return result;
    }  
    public List<CustomerBean> selectLikeMail( CustomerBean bean) {
    	List<CustomerBean> result =null;    	
    	//CustomerMail有值
		result = customerDao.selectLikeMail(bean.getCustomerMail());
		return result;
    }  

    public List<CustomerBean> selectLikeNote( CustomerBean bean) {
    	List<CustomerBean> result =null;    	
    	//customerName有值
		result = customerDao.selectLikeNote(bean.getCustomerNote());
		return result;
    }   
    public List<CustomerBean> select( CustomerBean bean )
    {
        List<CustomerBean> result = null;
        if ( bean != null && bean.getCustomerTel() != "" )
        {
            //customerTel有值
            CustomerBean temp = customerDao.select(bean.getCustomerTel());
            if ( temp != null )
            {
                result = new ArrayList<CustomerBean>();
                result.add( temp );
            }
        } 
        else
        {
          //customerTel不輸入時查詢全部
            result = customerDao.select();
        }
        return result;
    }

    public int insert( CustomerBean bean )
    {
       int result = 0;
        if ( bean != null )
        {
            result = customerDao.insert( bean );
        }
        return result;
    }

    public int update( CustomerBean bean )
    {
        int result = 0;
        if ( bean != null )
        {
            result = customerDao.update( bean.getCustomerName(), bean.getCustomerLine(), bean.getCustomerFb(), bean.getCustomerMail(), bean.getCustomerAddr(), bean.getCustomerNote(), bean.getCustomerTel() );
        }
        return result;
    }

    public int delete( CustomerBean bean )
    {
        int result = 0;
        if ( bean != null )
        {
            result = customerDao.delete( bean.getCustomerTel() );
        }
        return result;
    }
    
    
}
