package com.java.hcl.ig.Exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionId=2L;
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
