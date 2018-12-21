package package3;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class A {
	@Test
	public  void t1() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd_HHmm");
		String nowDateTime=sdf.format(new Date());
		System.out.println(nowDateTime);
	}
}
