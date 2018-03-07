package club.gsjglob.main.test.IO;

import java.io.File;
import java.util.Arrays;

import org.junit.Test;

/**
 * 文件I/O
 * 
 * @author gengzi
 *
 */
public class DirList {

	@Test
	public void fun01() {

		File file = new File("G:\\A_传智播客javaweb视频\\08、第八阶段web service(2天)\\webservice\\webservice\\jar");
		String[] list;
		if (file.length() == 0) {
			list = file.list();
		} else {
			DirFilter dirFilter = new DirFilter("([\\s\\S]*?).zip");
			list = file.list(dirFilter);
			Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
			for (String dirname : list) {
				System.out.println(dirname);
			}
		}
	}

}
