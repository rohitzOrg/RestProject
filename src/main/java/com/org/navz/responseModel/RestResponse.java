package com.org.navz.responseModel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RestResponse {

	private List<String> messages;
	  private Result result;
	  
	  public RestResponse(){    
	  }
	  
	  public List<String> getMessages() {
	    return messages;
	  }
	  public void setMessages(List<String> messages) {
	    this.messages = messages;
	  }
	  public Result getResult() {
	    return result;
	  }
	  public void setResult(Result result) {
	    this.result = result;
	  }

	  @Override
	  public String toString() {
	    return "RestResponse [messages=" + messages + ", result=" + result + "]";
	  }

}
