package eci.cosw.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Todo {
	
	private String description;
	private Integer priority;
	private String dueDate;
	private String responsible;
	private String status;
	
	
	public Todo() {
		super();
	}
	public Todo(String description, Integer priority, String dueDate, String responsible, String status) {
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
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
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
	
	
}
