package model;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import misc.Parse;

@Component(value="AccessBackService")
public class AccessBackService {
	
	@Autowired
	private AccessBackDAO dao;
	
	public boolean login(String bigWave, String passKey){
		boolean result = false;
		if(bigWave!=null && bigWave.length()!=0 && passKey!=null && passKey.length()!=0){
			AccessBackBean bean = dao.getAcess(bigWave);
			if(bean != null){
				byte[] key = bean.getPassKey();
				byte[] temp = Parse.encodeMD5(passKey);
				if(Arrays.equals(key, temp)){
					result = true;
				}
			}
		}
		return result;
	}

	public boolean changePassKey(String bigWave, String passKey, String newpassKey){
		boolean result = false;
		if(bigWave!=null && bigWave.length()!=0 && passKey!=null && passKey.length()!=0 && newpassKey!=null && newpassKey.length()!=0){
			if(this.login(bigWave, passKey)){
				byte[] temp = Parse.encodeMD5(newpassKey);
				dao.changePass(bigWave, temp);
				result = true;
			}
		}
		return result;
	}
	
	public void insert(String bigWave, String passKey) {
		dao.insert(bigWave, Parse.encodeMD5(passKey));
		return;
	}
	
}
