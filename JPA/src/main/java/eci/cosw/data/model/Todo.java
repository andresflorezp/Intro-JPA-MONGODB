package eci.cosw.data.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Todo {
	@Id
	private ObjectId TodoId;
	private String description;
	private Integer priority;
	private Date dueDate;
	private String responsible;
	private String status;
	
	
	public Todo() {
		super();
	}
	public Todo(String description, Integer priority, Date dueDate, String responsible, String status) {
		super();
		this.description = description;
		this.priority = priority;
		this.dueDate = dueDate;
		this.responsible = responsible;
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Todo [TodoId=" + TodoId + ", description=" + description + ", priority=" + priority + ", dueDate="
				+ dueDate + ", responsible=" + responsible + ", status=" + status + "]";
	}
	
	
	
}
