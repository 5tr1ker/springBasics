package noticeboard.entity.DTO;

public class postdataDTO {
	private String idstatus; // 사용자
	private String[] labeldata; // 태그 데이터
	private String postwritemode; // 작성된 포스트
	private postoption postoption;	// 글 옵션
	private postcontent postcontent; // 글 내용
	private String[] deletedfilelist; // 삭제된 파일
	
	public class postoption {
		private boolean blockcomm;
		private boolean privates;
		public boolean isBlockcomm() {
			return blockcomm;
		}
		public void setBlockcomm(boolean blockcomm) {
			this.blockcomm = blockcomm;
		}
		public boolean isPrivates() {
			return privates;
		}
		public void setPrivates(boolean privates) {
			this.privates = privates;
		}
		public postoption() {}
		
	}
	
	public class postcontent {
		private String title;
		private String content;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		public postcontent() {}
	}

	public String getIdstatus() {
		return idstatus;
	}

	public void setIdstatus(String idstatus) {
		this.idstatus = idstatus;
	}

	public String[] getLabeldata() {
		return labeldata;
	}

	public void setLabeldata(String[] labeldata) {
		this.labeldata = labeldata;
	}

	public String getPostwritemode() {
		return postwritemode;
	}

	public void setPostwritemode(String postwritemode) {
		this.postwritemode = postwritemode;
	}

	public postoption getPostoption() {
		return postoption;
	}

	public void setPostoption(postoption postoption) {
		this.postoption = postoption;
	}

	public postcontent getPostcontent() {
		return postcontent;
	}

	public void setPostcontent(postcontent postcontent) {
		this.postcontent = postcontent;
	}

	public String[] getDeletedfilelist() {
		return deletedfilelist;
	}

	public void setDeletedfilelist(String[] deletedfilelist) {
		this.deletedfilelist = deletedfilelist;
	}
	
	
}
