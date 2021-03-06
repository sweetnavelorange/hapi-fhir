
package ca.uhn.fhir.model.dstu2.valueset;

import ca.uhn.fhir.model.api.*;
import java.util.HashMap;
import java.util.Map;

public enum SupplyDispenseStatusEnum {

	/**
	 * Display: <b>In Progress</b><br>
	 * Code Value: <b>in progress</b>
	 *
	 * Supply has been requested, but not dispensed.
	 */
	IN_PROGRESS("in progress", "http://hl7.org/fhir/valueset-supply-dispense-status"),
	
	/**
	 * Display: <b>Dispensed</b><br>
	 * Code Value: <b>dispensed</b>
	 *
	 * Supply is part of a pharmacy order and has been dispensed.
	 */
	DISPENSED("dispensed", "http://hl7.org/fhir/valueset-supply-dispense-status"),
	
	/**
	 * Display: <b>Abandoned</b><br>
	 * Code Value: <b>abandoned</b>
	 *
	 * Dispensing was not completed.
	 */
	ABANDONED("abandoned", "http://hl7.org/fhir/valueset-supply-dispense-status"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * http://hl7.org/fhir/vs/valueset-supply-dispense-status
	 */
	public static final String VALUESET_IDENTIFIER = "http://hl7.org/fhir/vs/valueset-supply-dispense-status";

	/**
	 * Name for this Value Set:
	 * SupplyDispenseStatus
	 */
	public static final String VALUESET_NAME = "SupplyDispenseStatus";

	private static Map<String, SupplyDispenseStatusEnum> CODE_TO_ENUM = new HashMap<String, SupplyDispenseStatusEnum>();
	private static Map<String, Map<String, SupplyDispenseStatusEnum>> SYSTEM_TO_CODE_TO_ENUM = new HashMap<String, Map<String, SupplyDispenseStatusEnum>>();
	
	private final String myCode;
	private final String mySystem;
	
	static {
		for (SupplyDispenseStatusEnum next : SupplyDispenseStatusEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
			
			if (!SYSTEM_TO_CODE_TO_ENUM.containsKey(next.getSystem())) {
				SYSTEM_TO_CODE_TO_ENUM.put(next.getSystem(), new HashMap<String, SupplyDispenseStatusEnum>());
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
	public SupplyDispenseStatusEnum forCode(String theCode) {
		SupplyDispenseStatusEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<SupplyDispenseStatusEnum> VALUESET_BINDER = new IValueSetEnumBinder<SupplyDispenseStatusEnum>() {
		@Override
		public String toCodeString(SupplyDispenseStatusEnum theEnum) {
			return theEnum.getCode();
		}

		@Override
		public String toSystemString(SupplyDispenseStatusEnum theEnum) {
			return theEnum.getSystem();
		}
		
		@Override
		public SupplyDispenseStatusEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
		
		@Override
		public SupplyDispenseStatusEnum fromCodeString(String theCodeString, String theSystemString) {
			Map<String, SupplyDispenseStatusEnum> map = SYSTEM_TO_CODE_TO_ENUM.get(theSystemString);
			if (map == null) {
				return null;
			}
			return map.get(theCodeString);
		}
		
	};
	
	/** 
	 * Constructor
	 */
	SupplyDispenseStatusEnum(String theCode, String theSystem) {
		myCode = theCode;
		mySystem = theSystem;
	}

	
}
