package com.sap.cc;

import java.util.List;

import com.sap.cc.handsoff.*;

public class Hackathon implements DeveloperEvent{
	
	public String codeTogether(List<CodeCreator> codeCreators) {
		
		StringBuilder result = new StringBuilder();
		
		for(CodeCreator codeCreator : codeCreators) {
			try {
				result.append(codeCreator.code()).append("\n");
				codeCreator.code();
			} catch (UnsupportedDevelopmentLanguageException e) {
				result.append(e.getMessage()).append("\n");
			}
		}
		return result.toString();
	}
}
