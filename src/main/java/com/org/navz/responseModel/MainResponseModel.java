package com.org.navz.responseModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MainResponseModel {

	  @JsonProperty
	  private RestResponse RestResponse;
	  
	  @Id
	    @GeneratedValue
	    @Column(name = "CATEGORY_ID")
	  private Long id;
	  
	  
	  public RestResponse getRestResponse() {
	    return RestResponse;
	  }

	  public void setRestResponse(RestResponse restResponse) {
	    this.RestResponse = restResponse;
	  }

	  public MainResponseModel(){
	    
	  }
	  
	  @OneToMany(cascade = CascadeType.ALL)
	    @JoinTable(
	            name = "CATEGORY_ARTICLE",
	            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
	            inverseJoinColumns = @JoinColumn(name = "ARTICLE_ID")
	   )

	  @Override
	  public String toString() {
	    return "Response [RestResponse=" + RestResponse + "]";
	  }

	 
}
