package com.org.navz.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "MainResponseTable")
//@SecondaryTable(name = "RestResponseTable", pkJoinColumns = @PrimaryKeyJoinColumn(name = "RestResponseId", referencedColumnName = "MainResponseId"))
public class MainResponseTable {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MainResponseId", updatable = false, nullable = false)
	private Long id;
	
  /*  @OneToMany(targetEntity = RestResponseTable.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "MainResponseId",referencedColumnName="MainResponseId")
	private RestResponseTable restResponseTable;

	public RestResponseTable getRestResponseTable() {
		return restResponseTable;
	}

	public void setRestResponseTable(RestResponseTable restResponseTable) {
		this.restResponseTable = restResponseTable;
	}*/
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "MRT_RRT_RELTN", joinColumns = { @JoinColumn(name = "MainResponseId") }, inverseJoinColumns = { @JoinColumn(name = "RestResponseId") })
	private List<RestResponseTable> restResponseTable = new ArrayList<RestResponseTable>();

	public List<RestResponseTable> getRestResponseTable() {
		return restResponseTable;
	}

	public void setRestResponseTable(List<RestResponseTable> restResponseTable) {
		this.restResponseTable = restResponseTable;
	}
	public void addRestResponse(RestResponseTable rrTable)
	{
		rrTable.setMainResponseTable(this);
		restResponseTable.add(rrTable);
	}

}
