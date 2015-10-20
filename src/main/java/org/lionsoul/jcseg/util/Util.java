package org.lionsoul.jcseg.util;

import java.io.File;

/**
 * static method for jcseg.
 * 
 * @author	chenxin<chenxin619315@gmail.com>
 */
public class Util {
	
	/**
	 * get the absolute parent path for the jar file. 
	 * 
	 * @param o
	 * @return String
	 */
	public static String getJarHome(Object o) {
		String path = o.getClass().getProtectionDomain()
					.getCodeSource().getLocation().getFile();
		File jarFile = new File(path);
		return jarFile.getParentFile().getAbsolutePath();
	}
	
	public static File getFilefromClasspath(String fpath){
		File f =null;
		String tmp_path[] = fpath.split("classpath\\s*:");
		if( tmp_path.length> 1 ){
			if(tmp_path[1].trim().startsWith("/")){
				f = new File(Util.class.getResource(tmp_path[1].trim()).getPath());
			}else{
				f = new File(Util.class.getClassLoader().getResource(tmp_path[1].trim()).getPath());
			}
		}else{
			f = new File(fpath);
		}
		return f;
	}
}
