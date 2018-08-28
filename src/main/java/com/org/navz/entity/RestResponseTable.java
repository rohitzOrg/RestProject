package com.org.navz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "RestResponseTable")
public class RestResponseTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RestResponseId", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "messages")
	private String messages;
	
	@ManyToOne
	@JoinColumn(name="MainResponseId")
	private MainResponseTable mainResponseTable;

	public MainResponseTable getMainResponseTable() {
		return mainResponseTable;
	}

	public void setMainResponseTable(MainResponseTable mainResponseTable) {
		this.mainResponseTable = mainResponseTable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}
}
