package ca.uhn.fhir.model.dstu2;

import java.util.Properties;

import org.junit.Test;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.RuntimeResourceDefinition;
import ca.uhn.fhir.model.api.IResource;

public class ModelInstantiationTest {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(ModelInstantiationTest.class);
	
	@SuppressWarnings("unchecked")
	@Test
	public void testInstantiateAllTypes() throws Exception {
		FhirContext ctx = FhirContext.forDstu2();
		
		Properties p = new Properties();
		p.load(ctx.getVersion().getFhirVersionPropertiesFile());
		
		for (Object next : p.keySet()) {
			String nextStr = (String)next;
			if (nextStr.startsWith("resource.")) {
				nextStr = nextStr.substring("resource.".length());
			} else {
				continue;
			}
			
			String className = p.getProperty((String) next);
			ourLog.info("Loading class: {}", className);
			Class<? extends IResource> clazz = (Class<? extends IResource>) Class.forName(className);
			
			RuntimeResourceDefinition def = ctx.getResourceDefinition(clazz);
			def.newInstance();
		}
		
	}
	
}
