
public class MNTEntry {
	String name;
	int pp,kp,kpdtp,mdtp;
	
	public MNTEntry() {
		// TODO Auto-generated constructor stub
	}
	public MNTEntry(String name,int pp, int kp, int mdtp, int kpdtp){
		super();
		this.name = name;
		this.pp =pp;
		this.kp =kp;
		this.kpdtp =kpdtp;
		this.mdtp =mdtp;
	}
	public int getKp() {
		return kp;
	}public void setKp(int kp) {
		this.kp = kp;
	}public void setPp(int pp) {
		this.pp = pp;
	}public void setName(String name) {
		this.name = name;
	}public void setMdtp(int mdtp) {
		this.mdtp = mdtp;
	}public void setKpdtp(int kpdtp) {
		this.kpdtp = kpdtp;
	}public int getPp() {
		return pp;
	}public int getKpdtp() {
		return kpdtp;
	}public int getMdtp() {
		return mdtp;
	}public String getName() {
		return name;
	}
	
	
}
