
package ca.uhn.fhir.model.dev.valueset;

import ca.uhn.fhir.model.api.*;
import java.util.HashMap;
import java.util.Map;

public enum MaritalStatusCodesEnum {

	/**
	 * Display: <b>unmarried</b><br/>
	 * Code Value: <b>U</b>
	 *
	 * The person is not presently married. The marital history is not known or stated
	 */
	UNMARRIED("U", "http://hl7.org/fhir/marital-status"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * http://hl7.org/fhir/vs/marital-status
	 */
	public static final String VALUESET_IDENTIFIER = "http://hl7.org/fhir/vs/marital-status";

	/**
	 * Name for this Value Set:
	 * Marital Status Codes
	 */
	public static final String VALUESET_NAME = "Marital Status Codes";

	private static Map<String, MaritalStatusCodesEnum> CODE_TO_ENUM = new HashMap<String, MaritalStatusCodesEnum>();
	private static Map<String, Map<String, MaritalStatusCodesEnum>> SYSTEM_TO_CODE_TO_ENUM = new HashMap<String, Map<String, MaritalStatusCodesEnum>>();
	
	private final String myCode;
	private final String mySystem;
	
	static {
		for (MaritalStatusCodesEnum next : MaritalStatusCodesEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
			
			if (!SYSTEM_TO_CODE_TO_ENUM.containsKey(next.getSystem())) {
				SYSTEM_TO_CODE_TO_ENUM.put(next.getSystem(), new HashMap<String, MaritalStatusCodesEnum>());
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
	public MaritalStatusCodesEnum forCode(String theCode) {
		MaritalStatusCodesEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<MaritalStatusCodesEnum> VALUESET_BINDER = new IValueSetEnumBinder<MaritalStatusCodesEnum>() {
		@Override
		public String toCodeString(MaritalStatusCodesEnum theEnum) {
			return theEnum.getCode();
		}

		@Override
		public String toSystemString(MaritalStatusCodesEnum theEnum) {
			return theEnum.getSystem();
		}
		
		@Override
		public MaritalStatusCodesEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
		
		@Override
		public MaritalStatusCodesEnum fromCodeString(String theCodeString, String theSystemString) {
			Map<String, MaritalStatusCodesEnum> map = SYSTEM_TO_CODE_TO_ENUM.get(theSystemString);
			if (map == null) {
				return null;
			}
			return map.get(theCodeString);
		}
		
	};
	
	/** 
	 * Constructor
	 */
	MaritalStatusCodesEnum(String theCode, String theSystem) {
		myCode = theCode;
		mySystem = theSystem;
	}

	
}
