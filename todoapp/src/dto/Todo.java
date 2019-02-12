package dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Todo {
	private int id;
	private String title;
	private String task;
	private Timestamp limitDate;
	private Timestamp lastUpDate;
	private int status;
	private String label;
	private String inputLimitDate;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Timestamp getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(Timestamp limitDate) {
		this.limitDate = limitDate;
	}
	public Timestamp getLastUpDate() {
		return lastUpDate;
	}
	public void setLastUpDate(Timestamp lastUpDate) {
		this.lastUpDate = lastUpDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getInputLimitDate() {
		return inputLimitDate;
	}
	public void setInputLimitDate(String inputLimitDate) {
		this.inputLimitDate = inputLimitDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TodoValueObject [id=");
		builder.append(id);
		builder.append(",");
		if(title != null) {
			builder.append("title=");
			builder.append(title);
			builder.append(",");
		}
		if(task != null) {
			builder.append("task=");
			builder.append(task);
			builder.append(",");
		}if(limitDate != null) {
			builder.append("limitDate=");
			builder.append(limitDate);
			builder.append(",");
		}if(lastUpDate != null) {
			builder.append("lastUpDate=");
			builder.append(lastUpDate);
			builder.append(",");
		}
		builder.append("status=");
		builder.append(status);
		builder.append(",");
		if(label != null) {
			builder.append("label=");
			builder.append(label);
			builder.append(",");
		}if(inputLimitDate != null) {
			builder.append("inputLimitDate=");
			builder.append(inputLimitDate);
			builder.append(",");
		}
		builder.append("]");
		return builder.toString();
	}
	public boolean valueCheck() {
		errorMsgs = new ArrayList<String>();
		if(id < 0) {
			errorMsgs.add("不正な入力値です。");
		}
		if(title == null || title.isEmpty()) {
			errorMsgs.add("タイトルを入力してください。");
		} else if(title.length() > 256) {
			errorMsgs.add("タイトルが長すぎます。");
		}
		if(inputLimitDate == null || inputLimitDate.isEmpty()) {
			errorMsgs.add("タスク期限を入力してください。");
		} else if(!inputLimitDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
			errorMsgs.add("正しくタスク期限を入力してください。");
		}
		if(status < 0 || status > 3) {
			errorMsgs.add("入力したステータスの値が不正です。");
		}

		return (errorMsgs.size() == 0);
	}

	private List<String> errorMsgs;

	public List<String> getErrorMsgs() {
		return errorMsgs;
	}
	public void setErrorMsg(List<String> errorMsgs) {
		this.errorMsgs = errorMsgs;
	}




}