package ca.uhn.fhir.osgi;
 
import static org.junit.Assert.*;
import static org.ops4j.pax.exam.CoreOptions.*;
 
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerMethod;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
  
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerMethod.class)
public class BundleResolutionIT {

    @Inject
    private BundleContext bundleContext;
 
    @Configuration
    public Option[] config() {
 
        return options(
            bundle("file:target/hapi-fhir-osgi-0.9-SNAPSHOT.jar"),
            mavenBundle("javax.json", "javax.json-api", "1.0"),
            mavenBundle("org.glassfish", "javax.json", "1.0.4"),
            mavenBundle("org.apache.commons", "commons-lang3", "3.3.2"),
            mavenBundle("commons-codec", "commons-codec", "1.10"),
            mavenBundle("commons-io", "commons-io", "2.4"),
            mavenBundle("org.slf4j", "slf4j-api", "1.7.9"),
	    mavenBundle("org.slf4j", "slf4j-simple", "1.7.9").noStart(),
            mavenBundle("org.apache.httpcomponents", "httpcore-osgi", "4.3.3"),
            mavenBundle("org.apache.httpcomponents", "httpclient-osgi", "4.3.6"),
            mavenBundle("org.codehaus.woodstox", "stax2-api", "3.1.4"),
            mavenBundle("org.apache.felix", "org.apache.felix.http.servlet-api", "1.0.0"),
            junitBundles()
            );
    }

    @Before
    public void setup() {
        for (Bundle bundle: this.bundleContext.getBundles()) {
            System.out.println(bundle.getLocation());
        }
    }
 
    @Test
    public void testBundleAvailable() {
        final FhirContext context = new FhirContext();
	final IParser parser = context.newXmlParser();
        assertNotNull(parser);
    }
}
