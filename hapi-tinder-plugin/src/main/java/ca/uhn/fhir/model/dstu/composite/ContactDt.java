















package ca.uhn.fhir.model.dstu.composite;

import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import java.util.*;
import ca.uhn.fhir.model.api.*;
import ca.uhn.fhir.model.primitive.*;
import ca.uhn.fhir.model.api.annotation.*;
import ca.uhn.fhir.model.base.composite.*;

import ca.uhn.fhir.model.dstu.valueset.AddressUseEnum;
import ca.uhn.fhir.model.dstu.composite.CodingDt;
import ca.uhn.fhir.model.dstu.valueset.ContactSystemEnum;
import ca.uhn.fhir.model.dstu.valueset.ContactUseEnum;
import ca.uhn.fhir.model.dstu.valueset.EventTimingEnum;
import ca.uhn.fhir.model.dstu.valueset.IdentifierUseEnum;
import ca.uhn.fhir.model.dstu.valueset.NameUseEnum;
import ca.uhn.fhir.model.dstu.resource.Organization;
import ca.uhn.fhir.model.dstu.composite.PeriodDt;
import ca.uhn.fhir.model.dstu.valueset.QuantityCompararatorEnum;
import ca.uhn.fhir.model.dstu.composite.QuantityDt;
import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.model.dstu.valueset.UnitsOfTimeEnum;
import ca.uhn.fhir.model.dstu.resource.ValueSet;
import ca.uhn.fhir.model.dstu.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.primitive.Base64BinaryDt;
import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.BoundCodeDt;
import ca.uhn.fhir.model.primitive.CodeDt;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.model.primitive.DecimalDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.model.primitive.UriDt;

/**
 * HAPI/FHIR <b>ContactDt</b> Datatype
 * (Technology mediated contact details (phone, fax, email, etc))
 *
 * <p>
 * <b>Definition:</b>
 * All kinds of technology mediated contact details for a person or organization, including telephone, email, etc.
 * </p> 
 *
 * <p>
 * <b>Requirements:</b>
 * Need to track phone, fax, mobile, sms numbers, email addresses, twitter tags, etc.
 * </p> 
 */
@DatatypeDef(name="ContactDt") 
public class ContactDt
        extends  BaseIdentifiableElement         implements ICompositeDatatype
{

	/**
	 * Constructor
	 */
	public ContactDt() {
		// nothing
	}

	/**
	 * Constructor
	 */
	@SimpleSetter
	public ContactDt(@SimpleSetter.Parameter(name="theValue") String theValue) {
		setValue(theValue);
	}
	
	/**
	 * Constructor
	 */
	@SimpleSetter
	public ContactDt(@SimpleSetter.Parameter(name="theContactUse") ContactUseEnum theContactUse, @SimpleSetter.Parameter(name="theValue") String theValue) {
		setUse(theContactUse);
		setValue(theValue);
	}	

	@Child(name="system", type=CodeDt.class, order=0, min=0, max=1)	
	@Description(
		shortDefinition="phone | fax | email | url",
		formalDefinition="Telecommunications form for contact - what communications system is required to make use of the contact"
	)
	private BoundCodeDt<ContactSystemEnum> mySystem;
	
	@Child(name="value", type=StringDt.class, order=1, min=0, max=1)	
	@Description(
		shortDefinition="The actual contact details",
		formalDefinition="The actual contact details, in a form that is meaningful to the designated communication system (i.e. phone number or email address)."
	)
	private StringDt myValue;
	
	@Child(name="use", type=CodeDt.class, order=2, min=0, max=1)	
	@Description(
		shortDefinition="home | work | temp | old | mobile - purpose of this address",
		formalDefinition="Identifies the purpose for the address"
	)
	private BoundCodeDt<ContactUseEnum> myUse;
	
	@Child(name="period", type=PeriodDt.class, order=3, min=0, max=1)	
	@Description(
		shortDefinition="Time period when the contact was/is in use",
		formalDefinition="Time period when the contact was/is in use"
	)
	private PeriodDt myPeriod;
	

	@Override
	public boolean isEmpty() {
		return super.isBaseEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(  mySystem,  myValue,  myUse,  myPeriod);
	}
	
	@Override
	public <T extends IElement> List<T> getAllPopulatedChildElementsOfType(Class<T> theType) {
		return ca.uhn.fhir.util.ElementUtil.allPopulatedChildElements(theType, mySystem, myValue, myUse, myPeriod);
	}

	/**
	 * Gets the value(s) for <b>system</b> (phone | fax | email | url).
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * Telecommunications form for contact - what communications system is required to make use of the contact
     * </p> 
	 */
	public BoundCodeDt<ContactSystemEnum> getSystem() {  
		if (mySystem == null) {
			mySystem = new BoundCodeDt<ContactSystemEnum>(ContactSystemEnum.VALUESET_BINDER);
		}
		return mySystem;
	}


	/**
	 * Gets the value(s) for <b>system</b> (phone | fax | email | url).
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * Telecommunications form for contact - what communications system is required to make use of the contact
     * </p> 
	 */
	public BoundCodeDt<ContactSystemEnum> getSystemElement() {  
		if (mySystem == null) {
			mySystem = new BoundCodeDt<ContactSystemEnum>(ContactSystemEnum.VALUESET_BINDER);
		}
		return mySystem;
	}


	/**
	 * Sets the value(s) for <b>system</b> (phone | fax | email | url)
	 *
     * <p>
     * <b>Definition:</b>
     * Telecommunications form for contact - what communications system is required to make use of the contact
     * </p> 
	 */
	public ContactDt setSystem(BoundCodeDt<ContactSystemEnum> theValue) {
		mySystem = theValue;
		return this;
	}

	/**
	 * Sets the value(s) for <b>system</b> (phone | fax | email | url)
	 *
     * <p>
     * <b>Definition:</b>
     * Telecommunications form for contact - what communications system is required to make use of the contact
     * </p> 
	 */
	public ContactDt setSystem(ContactSystemEnum theValue) {
		getSystem().setValueAsEnum(theValue);
		return this;
	}

  
	/**
	 * Gets the value(s) for <b>value</b> (The actual contact details).
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The actual contact details, in a form that is meaningful to the designated communication system (i.e. phone number or email address).
     * </p> 
	 */
	public StringDt getValue() {  
		if (myValue == null) {
			myValue = new StringDt();
		}
		return myValue;
	}


	/**
	 * Gets the value(s) for <b>value</b> (The actual contact details).
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The actual contact details, in a form that is meaningful to the designated communication system (i.e. phone number or email address).
     * </p> 
	 */
	public StringDt getValueElement() {  
		if (myValue == null) {
			myValue = new StringDt();
		}
		return myValue;
	}


	/**
	 * Sets the value(s) for <b>value</b> (The actual contact details)
	 *
     * <p>
     * <b>Definition:</b>
     * The actual contact details, in a form that is meaningful to the designated communication system (i.e. phone number or email address).
     * </p> 
	 */
	public ContactDt setValue(StringDt theValue) {
		myValue = theValue;
		return this;
	}

 	/**
	 * Sets the value for <b>value</b> (The actual contact details)
	 *
     * <p>
     * <b>Definition:</b>
     * The actual contact details, in a form that is meaningful to the designated communication system (i.e. phone number or email address).
     * </p> 
	 */
	public ContactDt setValue( String theString) {
		myValue = new StringDt(theString); 
		return this; 
	}

 
	/**
	 * Gets the value(s) for <b>use</b> (home | work | temp | old | mobile - purpose of this address).
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * Identifies the purpose for the address
     * </p> 
	 */
	public BoundCodeDt<ContactUseEnum> getUse() {  
		if (myUse == null) {
			myUse = new BoundCodeDt<ContactUseEnum>(ContactUseEnum.VALUESET_BINDER);
		}
		return myUse;
	}


	/**
	 * Gets the value(s) for <b>use</b> (home | work | temp | old | mobile - purpose of this address).
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * Identifies the purpose for the address
     * </p> 
	 */
	public BoundCodeDt<ContactUseEnum> getUseElement() {  
		if (myUse == null) {
			myUse = new BoundCodeDt<ContactUseEnum>(ContactUseEnum.VALUESET_BINDER);
		}
		return myUse;
	}


	/**
	 * Sets the value(s) for <b>use</b> (home | work | temp | old | mobile - purpose of this address)
	 *
     * <p>
     * <b>Definition:</b>
     * Identifies the purpose for the address
     * </p> 
	 */
	public ContactDt setUse(BoundCodeDt<ContactUseEnum> theValue) {
		myUse = theValue;
		return this;
	}

	/**
	 * Sets the value(s) for <b>use</b> (home | work | temp | old | mobile - purpose of this address)
	 *
     * <p>
     * <b>Definition:</b>
     * Identifies the purpose for the address
     * </p> 
	 */
	public ContactDt setUse(ContactUseEnum theValue) {
		getUse().setValueAsEnum(theValue);
		return this;
	}

  
	/**
	 * Gets the value(s) for <b>period</b> (Time period when the contact was/is in use).
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * Time period when the contact was/is in use
     * </p> 
	 */
	public PeriodDt getPeriod() {  
		if (myPeriod == null) {
			myPeriod = new PeriodDt();
		}
		return myPeriod;
	}


	/**
	 * Gets the value(s) for <b>period</b> (Time period when the contact was/is in use).
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * Time period when the contact was/is in use
     * </p> 
	 */
	public PeriodDt getPeriodElement() {  
		if (myPeriod == null) {
			myPeriod = new PeriodDt();
		}
		return myPeriod;
	}


	/**
	 * Sets the value(s) for <b>period</b> (Time period when the contact was/is in use)
	 *
     * <p>
     * <b>Definition:</b>
     * Time period when the contact was/is in use
     * </p> 
	 */
	public ContactDt setPeriod(PeriodDt theValue) {
		myPeriod = theValue;
		return this;
	}

  


}