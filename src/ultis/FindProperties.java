package ultis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FindProperties {
	
	public static String locateProperty(String key) throws IOException {
		
		FileInputStream f = new FileInputStream("./Properties/configuration.properties");
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key).toString();
		
	}
	
	
}
