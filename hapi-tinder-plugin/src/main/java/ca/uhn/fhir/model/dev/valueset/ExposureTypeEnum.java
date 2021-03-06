
package ca.uhn.fhir.model.dev.valueset;

import ca.uhn.fhir.model.api.*;
import java.util.HashMap;
import java.util.Map;

public enum ExposureTypeEnum {

	/**
	 * Code Value: <b>drugadmin</b>
	 *
	 * Drug Administration.
	 */
	DRUGADMIN("drugadmin", "http://hl7.org/fhir/exposureType"),
	
	/**
	 * Code Value: <b>immuniz</b>
	 *
	 * Immunization.
	 */
	IMMUNIZ("immuniz", "http://hl7.org/fhir/exposureType"),
	
	/**
	 * Code Value: <b>coincidental</b>
	 *
	 * In the same area as the substance.
	 */
	COINCIDENTAL("coincidental", "http://hl7.org/fhir/exposureType"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * http://hl7.org/fhir/vs/exposureType
	 */
	public static final String VALUESET_IDENTIFIER = "http://hl7.org/fhir/vs/exposureType";

	/**
	 * Name for this Value Set:
	 * ExposureType
	 */
	public static final String VALUESET_NAME = "ExposureType";

	private static Map<String, ExposureTypeEnum> CODE_TO_ENUM = new HashMap<String, ExposureTypeEnum>();
	private static Map<String, Map<String, ExposureTypeEnum>> SYSTEM_TO_CODE_TO_ENUM = new HashMap<String, Map<String, ExposureTypeEnum>>();
	
	private final String myCode;
	private final String mySystem;
	
	static {
		for (ExposureTypeEnum next : ExposureTypeEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
			
			if (!SYSTEM_TO_CODE_TO_ENUM.containsKey(next.getSystem())) {
				SYSTEM_TO_CODE_TO_ENUM.put(next.getSystem(), new HashMap<String, ExposureTypeEnum>());
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
	public ExposureTypeEnum forCode(String theCode) {
		ExposureTypeEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<ExposureTypeEnum> VALUESET_BINDER = new IValueSetEnumBinder<ExposureTypeEnum>() {
		@Override
		public String toCodeString(ExposureTypeEnum theEnum) {
			return theEnum.getCode();
		}

		@Override
		public String toSystemString(ExposureTypeEnum theEnum) {
			return theEnum.getSystem();
		}
		
		@Override
		public ExposureTypeEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
		
		@Override
		public ExposureTypeEnum fromCodeString(String theCodeString, String theSystemString) {
			Map<String, ExposureTypeEnum> map = SYSTEM_TO_CODE_TO_ENUM.get(theSystemString);
			if (map == null) {
				return null;
			}
			return map.get(theCodeString);
		}
		
	};
	
	/** 
	 * Constructor
	 */
	ExposureTypeEnum(String theCode, String theSystem) {
		myCode = theCode;
		mySystem = theSystem;
	}

	
}
