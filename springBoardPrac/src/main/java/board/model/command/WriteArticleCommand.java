package board.model.command;

public class WriteArticleCommand {
	private String id;
	private String title;
	private String content;
	private int board_idx;
	
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
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	
	@Override
	public String toString() {
		return "WriteArticleCommand [id=" + id + ", title=" + title + ", content=" + content + ", board_idx="
				+ board_idx + "]";
	}

}
