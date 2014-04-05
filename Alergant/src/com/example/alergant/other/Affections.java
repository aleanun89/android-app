package com.example.alergant.other;

public class Affections {

	private String code = null;
	private String affection = null;
	private boolean selected = false;

	public Affections(String code, String affection, boolean selected) {
		
		super();
		this.code = code;
		this.affection = affection;
		this.selected = selected;
		
	}

	public String getCode() {
		
		return code;
	
	}

	public void setCode(String code) {
		
		this.code = code;
	
	}

	public String getAffection() {
		
		return affection;
	
	}

	public void setAffection(String affection) {
		
		this.affection = affection;
	
	}

	public boolean isSelected() {
		
		return selected;
	
	}

	public void setSelected(boolean selected) {
		
		this.selected = selected;
	
	}
}