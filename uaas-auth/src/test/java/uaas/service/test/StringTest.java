package uaas.service.test;

import org.junit.Test;

public class StringTest {
	@Test
	public void testReplace() {
		String path = "/aa/bb/aa/cc";
		path = path.replaceFirst("/aa", "/dd");
		System.out.println(path);
	}
}
