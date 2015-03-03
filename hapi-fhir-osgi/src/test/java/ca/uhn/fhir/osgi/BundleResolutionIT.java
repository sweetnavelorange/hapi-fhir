package ca.uhn.fhir.osgi;
 
import static org.junit.Assert.*;
import static org.ops4j.pax.exam.CoreOptions.*;
 
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
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
    public Option[] config() throws IOException {
        final List<Option> options = new ArrayList<Option>();
	options.add(junitBundles());
	final DirectoryStream<Path> hapiBundleDirectory = Files.newDirectoryStream(Paths.get("target"), "hapi-fhir-osgi-*.jar");
	// Should match a single file
	options.add(bundle("file:" + hapiBundleDirectory.iterator().next().toString()));
	final DirectoryStream<Path> depsDirectory = Files.newDirectoryStream(Paths.get("target/deps"));
	for (Path depPath: depsDirectory) {
		final String depName = depPath.toString();
		if (depName.contains("slf4j-simple")) {
			// This is a fragment bundle, which cannot be started
			options.add(bundle("file:" + depPath.toString()).noStart());
		} else {
			options.add(bundle("file:" + depPath.toString()));
		}
	}
        return options.toArray(new Option[options.size()]);
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
