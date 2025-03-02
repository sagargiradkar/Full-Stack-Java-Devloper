package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InsurancePolicy implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	private String PolicyNAme;
	private String policyType;
	private String company;
	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", PolicyNAme=" + PolicyNAme + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public String getPolicyNAme() {
		return PolicyNAme;
	}
	public void setPolicyNAme(String policyNAme) {
		PolicyNAme = policyNAme;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	private Integer tenure;
	
}
