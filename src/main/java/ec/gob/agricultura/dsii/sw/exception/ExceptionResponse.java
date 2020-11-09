package ec.gob.agricultura.dsii.sw.exception;

import java.util.Date;

public class ExceptionResponse {
	private long status;
	private Date timestamp;
	private String message;
	private String details;
	private String detailsJson;
	
	
	
	public ExceptionResponse(long status, Date timestamp, String message, String details, String detailsJson) {

		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.detailsJson = detailsJson;
	}


	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public String getDetailsJson() {
		return detailsJson;
	}


	public void setDetailsJson(String detailsJson) {
		this.detailsJson = detailsJson;
	}


	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
