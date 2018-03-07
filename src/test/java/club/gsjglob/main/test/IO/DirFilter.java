package club.gsjglob.main.test.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
/**
 *  目录过滤器
 * @author gengzi
 *
 */
public class DirFilter implements FilenameFilter {

	private Pattern pattern ;
	
	public DirFilter(String regex) {
		super();
		pattern = Pattern.compile(regex);
	}
	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}

}
