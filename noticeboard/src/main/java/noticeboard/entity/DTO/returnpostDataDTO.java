package noticeboard.entity.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class returnpostDataDTO {
	private long numbers;
	private String title;
	private String writer;
	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd" , timezone = "Asia/Seoul")
	private Date posttime;
	private int likes;
	private int view;
	/*
	 * POSTVIEW 전용
	 */
	private String content;
	private boolean blockcomm;
	private boolean privates;
	
	public returnpostDataDTO(long numbers, String title, String writer, Date posttime, int likes, int view,
			String content, boolean blockcomm, boolean privates) {
		super();
		this.numbers = numbers;
		this.title = title;
		this.writer = writer;
		this.posttime = posttime;
		this.likes = likes;
		this.view = view;
		this.content = content;
		this.blockcomm = blockcomm;
		this.privates = privates;
	}

	public returnpostDataDTO(long numbers, String title, String writer, Date posttime, int likes, int view) {
		this.numbers = numbers;
		this.title = title;
		this.writer = writer;
		this.posttime = posttime;
		this.likes = likes;
		this.view = view;
	}
	
	public long getNumbers() {
		return numbers;
	}
	public void setNumbers(long numbers) {
		this.numbers = numbers;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getwriter() {
		return writer;
	}
	public void setwriter(String writer) {
		this.writer = writer;
	}
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
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
}
