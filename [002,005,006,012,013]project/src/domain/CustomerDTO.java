package domain;

public class CustomerDTO {
	private String custId;
	private String custName;
	private String custPwd;
	private String address;
	
	public CustomerDTO() {
		super();
	}
		
	public CustomerDTO(String custId, String custPwd) {
		super();
		this.custId = custId;
		this.custPwd = custPwd;
	}

	public CustomerDTO(String custId, String custName, String custPwd, String address) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custPwd = custPwd;
		this.address = address;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPwd() {
		return custPwd;
	}

	public void setCustPwd(String custPwd) {
		this.custPwd = custPwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerBean [custId=");
		builder.append(custId);
		builder.append(", custName=");
		builder.append(custName);
		builder.append(", custPwd=");
		builder.append(custPwd);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
}
