package model;

public interface AccessBackDAO {

	public abstract AccessBackBean getAcess(String bigWave);
	
	public abstract AccessBackBean changePass(String bigWave, byte[] newPassKey);
	
	public abstract AccessBackBean insert(String bigWave, byte[] passKey);
	
}
