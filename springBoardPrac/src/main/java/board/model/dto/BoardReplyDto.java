package board.model.dto;

import java.time.LocalDateTime;

public class BoardReplyDto {
	private int board_reply_idx;
	private int board_idx;
	private String id;
	private String content;
	private LocalDateTime reg_date;
	private String del_yn;
	
	public int getBoard_reply_idx() {
		return board_reply_idx;
	}
	public void setBoard_reply_idx(int board_reply_idx) {
		this.board_reply_idx = board_reply_idx;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
		return "BoardReplyDto [board_reply_idx=" + board_reply_idx + ", board_idx=" + board_idx + ", id=" + id
				+ ", content=" + content + ", reg_date=" + reg_date + ", del_yn=" + del_yn + "]";
	}
}
