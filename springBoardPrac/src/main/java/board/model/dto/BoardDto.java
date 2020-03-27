package board.model.dto;

import java.time.LocalDateTime;

public class BoardDto {
	private int board_idx;
	private String id;
	private String title;
	private String content;
	private int view_count;
	private LocalDateTime reg_date;
	private String del_yn;
	
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public LocalDateTime getReg_date() {
		return reg_date;
	}
	public void setReg_date(LocalDateTime reg_date) {
		this.reg_date = reg_date;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	
	@Override
	public String toString() {
		return "BoardDto [board_idx=" + board_idx + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", view_count=" + view_count + ", reg_date=" + reg_date + ", del_yn=" + del_yn + "]";
	}

}
