package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PogrammerId implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer pid;
	private Integer projID;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getProjID() {
		return projID;
	}
	public void setProjID(Integer projID) {
		this.projID = projID;
	}
	@Override
	public String toString() {
		return "PogrammerId [pid=" + pid + ", projID=" + projID + "]";
	}
	
	
}
