package de.reserveddomain.addressbook.model;

public enum Gender {
	
	Male("Male"),
	
	Female("Female");
	
	private String genderValue;
	
	private Gender(String genderValue){
		this.genderValue = genderValue;
	}
	
	public static Gender convert(String value){
		
		for(Gender g : Gender.values()){
			if(g.getGenderValue().equalsIgnoreCase(value)){
				return g;
			}			
		}
		throw new IllegalArgumentException("Argument could not be found");
	}
	
	public String getGenderValue() {
		return genderValue;
	}
	
	
	

}
