package com.csc340.backend.csc340;

public class NullContract extends AbstractContract{
	
	public NullContract(){
		
	}
	@Override
	public String toString() {
		return "Null Contract";
	}
	
	public boolean isNull() {
		return true;
	}
}
