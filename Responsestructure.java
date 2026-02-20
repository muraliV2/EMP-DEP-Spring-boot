package com.jspiders.util;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseStructure<T>
{
	private T data;
	private LocalDateTime timeStamp;
	private String message;
	private int StatusCode;
	
	

}
