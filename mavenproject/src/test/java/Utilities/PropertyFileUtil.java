package Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class PropertyFileUtil
{
	public static String getValueForKey(String key) throws Throwable, Throwable
	{
		Properties configureproperties=new Properties();
		configureproperties.load(new FileInputStream(new File("./PropertiesFile/Environment.Properties")));
		return configureproperties.getProperty(key);	
	}
	

}
