
package ca.uhn.fhir.model.dstu2.valueset;

import ca.uhn.fhir.model.api.*;
import java.util.HashMap;
import java.util.Map;

public enum IssueSeverityEnum {

	/**
	 * Code Value: <b>fatal</b>
	 *
	 * The issue caused the action to fail, and no further checking could be performed.
	 */
	FATAL("fatal", "http://hl7.org/fhir/issue-severity"),
	
	/**
	 * Code Value: <b>error</b>
	 *
	 * The issue is sufficiently important to cause the action to fail.
	 */
	ERROR("error", "http://hl7.org/fhir/issue-severity"),
	
	/**
	 * Code Value: <b>warning</b>
	 *
	 * The issue is not important enough to cause the action to fail, but may cause it to be performed suboptimally or in a way that is not as desired.
	 */
	WARNING("warning", "http://hl7.org/fhir/issue-severity"),
	
	/**
	 * Code Value: <b>information</b>
	 *
	 * The issue has no relation to the degree of success of the action.
	 */
	INFORMATION("information", "http://hl7.org/fhir/issue-severity"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * http://hl7.org/fhir/vs/issue-severity
	 */
	public static final String VALUESET_IDENTIFIER = "http://hl7.org/fhir/vs/issue-severity";

	/**
	 * Name for this Value Set:
	 * IssueSeverity
	 */
	public static final String VALUESET_NAME = "IssueSeverity";

	private static Map<String, IssueSeverityEnum> CODE_TO_ENUM = new HashMap<String, IssueSeverityEnum>();
	private static Map<String, Map<String, IssueSeverityEnum>> SYSTEM_TO_CODE_TO_ENUM = new HashMap<String, Map<String, IssueSeverityEnum>>();
	
	private final String myCode;
	private final String mySystem;
	
	static {
		for (IssueSeverityEnum next : IssueSeverityEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
			
			if (!SYSTEM_TO_CODE_TO_ENUM.containsKey(next.getSystem())) {
				SYSTEM_TO_CODE_TO_ENUM.put(next.getSystem(), new HashMap<String, IssueSeverityEnum>());
			}
			SYSTEM_TO_CODE_TO_ENUM.get(next.getSystem()).put(next.getCode(), next);			
		}
	}
	
	/**
	 * Returns the code associated with this enumerated value
	 */
	public String getCode() {
		return myCode;
	}
	
	/**
	 * Returns the code system associated with this enumerated value
	 */
	public String getSystem() {
		return mySystem;
	}
	
	/**
	 * Returns the enumerated value associated with this code
	 */
	public IssueSeverityEnum forCode(String theCode) {
		IssueSeverityEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<IssueSeverityEnum> VALUESET_BINDER = new IValueSetEnumBinder<IssueSeverityEnum>() {
		@Override
		public String toCodeString(IssueSeverityEnum theEnum) {
			return theEnum.getCode();
		}

		@Override
		public String toSystemString(IssueSeverityEnum theEnum) {
			return theEnum.getSystem();
		}
		
		@Override
		public IssueSeverityEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
		
		@Override
		public IssueSeverityEnum fromCodeString(String theCodeString, String theSystemString) {
			Map<String, IssueSeverityEnum> map = SYSTEM_TO_CODE_TO_ENUM.get(theSystemString);
			if (map == null) {
				return null;
			}
			return map.get(theCodeString);
		}
		
	};
	
	/** 
	 * Constructor
	 */
	IssueSeverityEnum(String theCode, String theSystem) {
		myCode = theCode;
		mySystem = theSystem;
	}

	
}
