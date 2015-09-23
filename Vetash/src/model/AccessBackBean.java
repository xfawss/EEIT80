package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="AccessBackground")
public class AccessBackBean {

	@Id
	@Column(name="BigWave")
	private String bigWave;
	
	@Column(name="PassKey")
	private byte[] passKey;

	public String getBigWave() {
		return bigWave;
	}

	public void setBigWave(String bigWave) {
		this.bigWave = bigWave;
	}

	public byte[] getPassKey() {
		return passKey;
	}

	public void setPassKey(byte[] passKey) {
		this.passKey = passKey;
	}
	
	
}
