
package ca.uhn.fhir.model.dev.valueset;

import ca.uhn.fhir.model.api.*;
import java.util.HashMap;
import java.util.Map;

public enum LocationStatusEnum {

	/**
	 * Code Value: <b>active</b>
	 *
	 * The location is operational.
	 */
	ACTIVE("active", "http://hl7.org/fhir/location-status"),
	
	/**
	 * Code Value: <b>suspended</b>
	 *
	 * The location is temporarily closed.
	 */
	SUSPENDED("suspended", "http://hl7.org/fhir/location-status"),
	
	/**
	 * Code Value: <b>inactive</b>
	 *
	 * The location is no longer used.
	 */
	INACTIVE("inactive", "http://hl7.org/fhir/location-status"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * http://hl7.org/fhir/vs/location-status
	 */
	public static final String VALUESET_IDENTIFIER = "http://hl7.org/fhir/vs/location-status";

	/**
	 * Name for this Value Set:
	 * LocationStatus
	 */
	public static final String VALUESET_NAME = "LocationStatus";

	private static Map<String, LocationStatusEnum> CODE_TO_ENUM = new HashMap<String, LocationStatusEnum>();
	private static Map<String, Map<String, LocationStatusEnum>> SYSTEM_TO_CODE_TO_ENUM = new HashMap<String, Map<String, LocationStatusEnum>>();
	
	private final String myCode;
	private final String mySystem;
	
	static {
		for (LocationStatusEnum next : LocationStatusEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
			
			if (!SYSTEM_TO_CODE_TO_ENUM.containsKey(next.getSystem())) {
				SYSTEM_TO_CODE_TO_ENUM.put(next.getSystem(), new HashMap<String, LocationStatusEnum>());
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
	public LocationStatusEnum forCode(String theCode) {
		LocationStatusEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<LocationStatusEnum> VALUESET_BINDER = new IValueSetEnumBinder<LocationStatusEnum>() {
		@Override
		public String toCodeString(LocationStatusEnum theEnum) {
			return theEnum.getCode();
		}

		@Override
		public String toSystemString(LocationStatusEnum theEnum) {
			return theEnum.getSystem();
		}
		
		@Override
		public LocationStatusEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
		
		@Override
		public LocationStatusEnum fromCodeString(String theCodeString, String theSystemString) {
			Map<String, LocationStatusEnum> map = SYSTEM_TO_CODE_TO_ENUM.get(theSystemString);
			if (map == null) {
				return null;
			}
			return map.get(theCodeString);
		}
		
	};
	
	/** 
	 * Constructor
	 */
	LocationStatusEnum(String theCode, String theSystem) {
		myCode = theCode;
		mySystem = theSystem;
	}

	
}
