package model;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table(name="Customer")
public class CustomerBean {

    @Column(name="CustomerName")
	private String customerName;
    
    @Id
    @Column(name="CustomerTel")
    private String customerTel;
    
    @Column(name="CustomerLine")
    private String customerLine;
    
    @Column(name="CustomerFb")
    private String customerFb;
    
    @Column(name="CustomerMail")
    private String customerMail;
    
    @Column(name="CustomerAddr")
    private String customerAddr;
    
    @Column(name="CustomerNote")
    private String customerNote;
    
    
    public CustomerBean(){
        
    }
    



    public String getCustomerName() {
        return customerName;
    }



    @Override
    public String toString() {
        JSONObject obj = new JSONObject();
        try{
            obj.put("customerName", customerName);
            obj.put("customerTel" , customerTel);
            obj.put("customerLine", customerLine);
            obj.put("customerFb"  , customerFb);
            obj.put("customerMail", customerMail);
            obj.put("customerAddr", customerAddr);
            obj.put("customerNote", customerNote);
        } catch ( JSONException e ) {
            e.printStackTrace();
        }
        
        return obj.toString();
    }
        
    public JSONObject writeJSONString (CustomerBean customer) throws IOException, JSONException{
        
        JSONObject obj = new JSONObject();
        
        obj.put("customerName", customer.getCustomerName());
        obj.put("customerTel", customer.getCustomerTel());
        obj.put("customerLine", customer.getCustomerLine());
        obj.put("customerFb", customer.getCustomerFb());
        obj.put("customerMail", customer.getCustomerMail());
        obj.put("customerAddr", customer.getCustomerAddr());
        obj.put("customerNote", customer.getCustomerNote());
        
        return obj;
   }




    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerTel() {
        return customerTel;
    }
    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }
    public String getCustomerLine() {
        return customerLine;
    }
    public void setCustomerLine(String customerLine) {
        this.customerLine = customerLine;
    }
    public String getCustomerFb() {
        return customerFb;
    }
    public void setCustomerFb(String customerFb) {
        this.customerFb = customerFb;
    }
    public String getCustomerMail() {
        return customerMail;
    }
    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }
    public String getCustomerAddr() {
        return customerAddr;
    }
    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr;
    }
    public String getCustomerNote() {
        return customerNote;
    }
    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }
    
    
    
}
