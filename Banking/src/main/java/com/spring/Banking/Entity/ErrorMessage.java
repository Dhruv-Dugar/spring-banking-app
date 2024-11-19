package com.spring.Banking.Entity;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ErrorMessage {

	private HttpStatus status;
	private String message;
	private long unixTimeStampOfError;


	public ErrorMessage(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
		this.unixTimeStampOfError = Instant.now().getEpochSecond();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getUnixTimeStampOfError() {
		return unixTimeStampOfError;
	}

	public void setUnixTimeStampOfError(long unixTimeStampOfError) {
		this.unixTimeStampOfError = unixTimeStampOfError;
	}
}
