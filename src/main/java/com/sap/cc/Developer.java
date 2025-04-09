package com.sap.cc;

import com.sap.cc.handsoff.*;

public class Developer extends CodeCreator{
	
	private String name;
	private String language;

	public Developer(String name, String language) {
		setName(name);
		setLanguage(language);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLanguage() {
		return this.language;
	}
	
	@Override
	public String code() throws UnsupportedDevelopmentLanguageException {
		switch (this.language.toLowerCase()) {
		case "go": return "fmt.Println(\"Hello, "+this.name+"!\")";
		case "nodejs": return "console.log(\"Hello, "+this.name+"!\")";
		case "python": return "print(\"Hello, "+this.name+"!\")";
		default:
			throw new UnsupportedDevelopmentLanguageException(this.language);
		}
	}
}
