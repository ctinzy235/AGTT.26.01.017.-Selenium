package Common;

import java.util.UUID;


public class Random {

	public static String getRandomPassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
	
	public static String getRandomEmail() {
		return "test" + UUID.randomUUID().toString().substring(0, 4) + "@gmail.com";
	}
	
	public static String getRandomString(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }
	
}
