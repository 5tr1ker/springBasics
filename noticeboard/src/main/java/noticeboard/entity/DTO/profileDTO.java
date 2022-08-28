package noticeboard.entity.DTO;

public class profileDTO {
	private String idstatus;
	private input_profiledata input_profiledata;
	
	public class input_profiledata {
		private String userid;
		private String email;
		private String phone;
		private Integer option1;
		private Integer option2;
		
		
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public Integer getOption1() {
			return option1;
		}
		public void setOption1(Integer option1) {
			this.option1 = option1;
		}
		public Integer getOption2() {
			return option2;
		}
		public void setOption2(Integer option2) {
			this.option2 = option2;
		}
	}

	public String getIdstatus() {
		return idstatus;
	}

	public void setIdstatus(String idstatus) {
		this.idstatus = idstatus;
	}

	public input_profiledata getInput_profiledata() {
		return input_profiledata;
	}

	public void setInput_profiledata(input_profiledata input_profiledata) {
		this.input_profiledata = input_profiledata;
	}
	
} 
