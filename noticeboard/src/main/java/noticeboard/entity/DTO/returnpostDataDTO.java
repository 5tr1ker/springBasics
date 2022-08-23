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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
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
	
	
}
