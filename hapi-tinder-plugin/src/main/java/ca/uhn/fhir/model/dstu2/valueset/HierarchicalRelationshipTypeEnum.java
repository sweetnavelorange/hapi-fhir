
package ca.uhn.fhir.model.dstu2.valueset;

import ca.uhn.fhir.model.api.*;
import java.util.HashMap;
import java.util.Map;

public enum HierarchicalRelationshipTypeEnum {

	/**
	 * Display: <b>Parent</b><br>
	 * Code Value: <b>parent</b>
	 *
	 * The target resource is the parent of the focal specimen resource.
	 */
	PARENT("parent", "http://hl7.org/fhir/hierarchical-relationship-type"),
	
	/**
	 * Display: <b>Child</b><br>
	 * Code Value: <b>child</b>
	 *
	 * The target resource is the child of the focal specimen resource.
	 */
	CHILD("child", "http://hl7.org/fhir/hierarchical-relationship-type"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * http://hl7.org/fhir/vs/hierarchical-relationship-type
	 */
	public static final String VALUESET_IDENTIFIER = "http://hl7.org/fhir/vs/hierarchical-relationship-type";

	/**
	 * Name for this Value Set:
	 * HierarchicalRelationshipType
	 */
	public static final String VALUESET_NAME = "HierarchicalRelationshipType";

	private static Map<String, HierarchicalRelationshipTypeEnum> CODE_TO_ENUM = new HashMap<String, HierarchicalRelationshipTypeEnum>();
	private static Map<String, Map<String, HierarchicalRelationshipTypeEnum>> SYSTEM_TO_CODE_TO_ENUM = new HashMap<String, Map<String, HierarchicalRelationshipTypeEnum>>();
	
	private final String myCode;
	private final String mySystem;
	
	static {
		for (HierarchicalRelationshipTypeEnum next : HierarchicalRelationshipTypeEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
			
			if (!SYSTEM_TO_CODE_TO_ENUM.containsKey(next.getSystem())) {
				SYSTEM_TO_CODE_TO_ENUM.put(next.getSystem(), new HashMap<String, HierarchicalRelationshipTypeEnum>());
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
	public HierarchicalRelationshipTypeEnum forCode(String theCode) {
		HierarchicalRelationshipTypeEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<HierarchicalRelationshipTypeEnum> VALUESET_BINDER = new IValueSetEnumBinder<HierarchicalRelationshipTypeEnum>() {
		@Override
		public String toCodeString(HierarchicalRelationshipTypeEnum theEnum) {
			return theEnum.getCode();
		}

		@Override
		public String toSystemString(HierarchicalRelationshipTypeEnum theEnum) {
			return theEnum.getSystem();
		}
		
		@Override
		public HierarchicalRelationshipTypeEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
		
		@Override
		public HierarchicalRelationshipTypeEnum fromCodeString(String theCodeString, String theSystemString) {
			Map<String, HierarchicalRelationshipTypeEnum> map = SYSTEM_TO_CODE_TO_ENUM.get(theSystemString);
			if (map == null) {
				return null;
			}
			return map.get(theCodeString);
		}
		
	};
	
	/** 
	 * Constructor
	 */
	HierarchicalRelationshipTypeEnum(String theCode, String theSystem) {
		myCode = theCode;
		mySystem = theSystem;
	}

	
}
