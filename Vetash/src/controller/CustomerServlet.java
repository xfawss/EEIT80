package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import model.CustomerBean;
import model.CustomerService;





@WebServlet(urlPatterns={"/Customers"})
public class CustomerServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;
    private  CustomerService service;
    @Override
    public void init() throws ServletException {
        service = new CustomerService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 //定義存放錯誤訊息的Collection物件
        Map<String, String> errMsgs = new HashMap<String, String>();
       
   
        //回傳值
        List<CustomerBean> result = null;
        //Bean
        CustomerBean bean = new CustomerBean();
        //錯誤訊息 start
        String msg = null;
        //錯誤訊息 end
        //放Customers的Json
        JSONObject jsonErr = new JSONObject();
        JSONObject jsonMsg = new JSONObject();        
        request.setAttribute("errMsg", errMsgs);  //顯示錯誤訊息      
        //設定輸入資料的編碼
        request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼 
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        //接收資料        
          String cust = request.getParameter( "cust" );           
          String tel = request.getParameter("customerTel");
          String line =request.getParameter("customerLine");
          String fb =request.getParameter("customerFb");
          String mail =request.getParameter("customerMail");
          String name =request.getParameter("customerName");
          String addr =request.getParameter("customerAddr");
          String note =request.getParameter("customerNote");
        //塞進Bean
          bean.setCustomerAddr(addr);
          bean.setCustomerTel(tel);
          bean.setCustomerLine(line); 
          bean.setCustomerFb(fb); 
          bean.setCustomerMail(mail); 
          bean.setCustomerName(name); 
          bean.setCustomerNote(note); 
      //如果欄位不為空值 則做下列程式判斷
        if(cust!=null){ 
        	switch(cust){
        	case "customerTel":
        try{
        	//   JSONObject jsonErr = new JSONObject();
            //JSONObject jsonMsg = new JSONObject();   
            //V1錯誤訊息 start
            if(tel == null){
                jsonErr.put( "errMsg", "請輸入電話號碼查詢" );
                out.print( jsonErr );                
            } else {            	                  
                result = service.select(bean);
                //基本寫法使用writeJSONString start
                JSONArray  customers = new JSONArray();
                JSONObject customer = new JSONObject();
                for(int i = 0; i< result.size(); i++){
                    customer = bean.writeJSONString( result.get( i ) );
                    customers.put( customer );
                }
                jsonMsg.put( "customers", customers );
                System.out.println( "writeJSONString方法:" + jsonMsg.toString() );
                out.print( jsonMsg.toString() );
                //基本寫法使用writeJSONString end      
        }
            } catch ( JSONException e ) {
            e.printStackTrace();
        }
        break;
        	case "customerName" :
        		  try {
					if(name == null){
					  	jsonErr.put( "errMsg", "請輸入姓名查詢" );
					      out.print( jsonErr );
					  }else{
					  	result=service.selectLikeName(bean);            	
					       JSONArray  customers = new JSONArray();
					       JSONObject customer = new JSONObject();
					       for(int i = 0; i< result.size(); i++){
					           customer = bean.writeJSONString( result.get( i ) );
					           customers.put( customer );
					       }
					       jsonMsg.put( "customers", customers );
					       System.out.println( "writeJSONString方法:" + jsonMsg.toString() );
					       out.print( jsonMsg.toString() );
					  }
				} catch (JSONException e) {					
					e.printStackTrace();
				}  
        		
        		break;
        
        	case "customerLine":
        		  try {
  					if(line == null){
  					  	jsonErr.put( "errMsg", "請輸入Line查詢" );
  					      out.print( jsonErr );
  					  }else{
  					  	result=service.selectLikeLine(bean);            	
  					       JSONArray  customers = new JSONArray();
  					       JSONObject customer = new JSONObject();
  					       for(int i = 0; i< result.size(); i++){
  					           customer = bean.writeJSONString( result.get( i ) );
  					           customers.put( customer );
  					       }
  					       jsonMsg.put( "customers", customers );
  					       System.out.println( "writeJSONString方法:" + jsonMsg.toString() );
  					       out.print( jsonMsg.toString() );
  					  }
  				} catch (JSONException e) {					
  					e.printStackTrace();
  				}  
        
        			break;
        	case "customerFb":
        		  try {
  					if(fb == null){
  					  	jsonErr.put( "errMsg", "請輸入Fb查詢" );
  					      out.print( jsonErr );
  					  }else{
  					  	result=service.selectLikeFb(bean);            	
  					       JSONArray  customers = new JSONArray();
  					       JSONObject customer = new JSONObject();
  					       for(int i = 0; i< result.size(); i++){
  					           customer = bean.writeJSONString( result.get( i ) );
  					           customers.put( customer );
  					       }
  					       jsonMsg.put( "customers", customers );
  					       System.out.println( "writeJSONString方法:" + jsonMsg.toString() );
  					       out.print( jsonMsg.toString() );
  					  }
  				} catch (JSONException e) {					
  					e.printStackTrace();
  				}  
                
        			break;
        	case "customerMail":
                
        		  try {
  					if(mail == null){
  					  	jsonErr.put( "errMsg", "請輸入Mail查詢" );
  					      out.print( jsonErr );
  					  }else{
  					  	result=service.selectLikeMail(bean);            	
  					       JSONArray  customers = new JSONArray();
  					       JSONObject customer = new JSONObject();
  					       for(int i = 0; i< result.size(); i++){
  					           customer = bean.writeJSONString( result.get( i ) );
  					           customers.put( customer );
  					       }
  					       jsonMsg.put( "customers", customers );
  					       System.out.println( "writeJSONString方法:" + jsonMsg.toString() );
  					       out.print( jsonMsg.toString() );
  					  }
  				} catch (JSONException e) {					
  					e.printStackTrace();
  				}  
    			break;
        	
        	case "customerNote":
        		  try {
  					if(note == null){
  					  	jsonErr.put( "errMsg", "請輸入Note查詢" );
  					      out.print( jsonErr );
  					  }else{
  					  	result=service.selectLikeNote(bean);            	
  					       JSONArray  customers = new JSONArray();
  					       JSONObject customer = new JSONObject();
  					       for(int i = 0; i< result.size(); i++){
  					           customer = bean.writeJSONString( result.get( i ) );
  					           customers.put( customer );
  					       }
  					       jsonMsg.put( "customers", customers );
  					       System.out.println( "writeJSONString方法:" + jsonMsg.toString() );
  					       out.print( jsonMsg.toString() );
  					  }
  				} catch (JSONException e) {					
  					e.printStackTrace();
  				}  
        		break;   
        	}
        }        
        out.flush();
        out.close();  
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	
    	//設定輸入資料的編碼
        request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼 
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
      //接收資料        
       // String cust = request.getParameter( "cust" );           
        String tel = request.getParameter("customerTel");
        String line =request.getParameter("customerLine");
        String fb =request.getParameter("customerFb");
        String mail =request.getParameter("customerMail");
        String name =request.getParameter("customerName");
        String note =request.getParameter("customerNote");
        String addr =request.getParameter("customerAddr");
        String action = request.getParameter("action");
        //驗證資料
        //定義存放錯誤訊息的Collection物件   1  
        Map<String, String> errors = new HashMap<String, String>();
    	request.setAttribute("errMsgs", errors);
    	//存放錯誤訊息的json物件2
 	   JSONObject jsonErr = new JSONObject();
        JSONObject jsonMsg = new JSONObject(); 
        if(action != null){
        	if(action.equals("Insert") || action.equals("Update")){
        		if(name==null || name.length() ==0){
//        			try {
        				errors.put("customerName", "新增或修改顧客名為必填欄位");
//						jsonErr.put("customerName"," 新增或修改顧客名為必填欄位");
//						out.print( jsonErr );
//					} catch (JSONException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
        		}
        		if(tel==null || tel.length()==0){
//        			try {
        				errors.put("customerTel", "新增或修改顧客名為必填欄位");
//						jsonErr.put("customerTel", "新增或修改顧客名為必填欄位");
//						out.print( jsonErr );
//					} catch (JSONException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
        		}
        		if(addr==null || addr.length()==0){
//        			try {
        				errors.put("customerAddr", "新增或修改顧客名為必填欄位");
//						jsonErr.put("customerAddr", "新增或修改顧客名為必填欄位");
//						out.print( jsonErr );
//					} catch (JSONException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
        		}
        	}
        	if(action.equals("Delete")){
        		if(tel==null || tel.length()==0){
//        			try {
       				errors.put("customerTel", "新增或修改顧客名為必填欄位"); 
//						jsonErr.put("customerTel", "新增或修改顧客名為必填欄位");
//						out.print( jsonErr );
//					} catch (JSONException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} 
        		}
        	}
        	
        }
        //錯誤訊息轉交至指定頁面
        if (errors != null && !errors.isEmpty()) {
        	request.getRequestDispatcher("/Index.jsp").forward(request, response);
			return;
		}
        
        //呼叫model
        //塞進Bean    
    	CustomerBean bean = new CustomerBean();
        bean.setCustomerAddr(addr);
        bean.setCustomerTel(tel);
        bean.setCustomerLine(line); 
        bean.setCustomerFb(fb); 
        bean.setCustomerMail(mail); 
        bean.setCustomerName(name); 
        bean.setCustomerNote(note);
        request.setAttribute("beans", bean);
//根據model執行結果導向View
        if(action!=null && action.equals("Insert")){
        	int result=service.insert(bean);
        	if(result==0){        	
        		try {
        			errors.put("result", "新增失敗");
					jsonErr.put("result", "新增失敗");
					out.print( jsonErr );
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	}else{
        		try {
					request.setAttribute("Insert", result);
					errors.put("result", "新增1筆成功");
					jsonErr.put("result", "新增1筆成功");
					out.print( jsonErr );
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	}
        //	request.getRequestDispatcher("/Insert.jsp").forward(request, response);
        }else if(action !=null&& action.equals("Update")){
        	int result=service.update(bean);
        	if(result==0){
        		try {
					errors.put("result", "修改失敗");
					jsonErr.put("result", "修改失敗");
					out.print( jsonErr );
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	}else{
        		try {
					request.setAttribute("Update", result);
					errors.put("result", "修改1筆成功");
					jsonErr.put("result", "修改1筆成功");
					out.print( jsonErr );
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	}
        //	request.getRequestDispatcher("/Update.jsp").forward(request, response);
        }else if(action!=null &&action.equals("Delete")){
        	int result=service.delete(bean);
        	if(result==0){
        		try {
					errors.put("result", "刪除錯誤");
					jsonErr.put("result", "刪除錯誤");
					out.print( jsonErr );
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	}else{
        		try {
					request.setAttribute("Delete",result );
					errors.put("result", "刪除一筆成功"); 
					jsonErr.put("result", "刪除一筆成功");
					out.print( jsonErr );
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	}
   //    	request.getRequestDispatcher("/Delete.jsp").forward(request, response);
        
        }
        
        
//		
//        if(action!=null && action.equals("Insert")) {
//		if(name ==null || tel==null || addr== null){
//		System.out.println("為必填欄位");	
//			}else{
//			CustomerBean result1insert=service.insert(bean);
//			
//			if(result1insert == null){
//				errors.put("result", "Insert fail");
//				request.setAttribute("Insert", 0);
//			}else{
//				
//				request.setAttribute("Insert", result1insert);
//			}	
//			
//		}
//	}else if(action!=null && action.equals("Update")) {
//		if(name ==null || tel==null || addr== null){
//		System.out.println("為必填欄位");	
//			}else{
//			CustomerBean result1Update=service.update(bean);
//			
//			if(result1Update == null){
//				errors.put("result", "Update fail");
//				request.setAttribute("Update", 0);
//			}else{
//				
//				request.setAttribute("Update", 1);
//				}	
//			
//			}
//		}else if(action!=null && action.equals("Delete")) {
//			boolean resultDelete1 = service.delete(bean);
//			if(!resultDelete1 && tel !=null) {
//				errors.put("result", "刪除0筆成功");
//			} else {
//				
//				request.setAttribute("delete", resultDelete1);
//				errors.put("result", "刪除1筆成功");
//				
//			}
//			
//		} else  {
//			errors.put("action", "Unknown Action:"+action);
//					}
        }    
    }
    
