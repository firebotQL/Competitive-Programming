import java.lang.Long;

public class Test
{
	public static void main(String[] args) {
		long test = new Long(args[0]).longValue() >> 1;
		System.out.println(test);
	}
}
