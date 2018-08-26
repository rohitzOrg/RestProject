package com.org.navz.responseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MainResponseModel {

	  @JsonProperty
	  private RestResponse RestResponse;
	  
	  public RestResponse getRestResponse() {
	    return RestResponse;
	  }

	  public void setRestResponse(RestResponse restResponse) {
	    this.RestResponse = restResponse;
	  }

	  public MainResponseModel(){
	    
	  }

	  @Override
	  public String toString() {
	    return "Response [RestResponse=" + RestResponse + "]";
	  }

}
