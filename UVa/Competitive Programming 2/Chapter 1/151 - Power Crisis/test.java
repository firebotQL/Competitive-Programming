import java.io.*;
class test
{
	public static void main(String[] args) throws Exception{
		FileWriter fstream = new FileWriter("out.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		for(int i = 13; i <= 100; ++i)
			out.write(i + "" + '\n');
		out.close();
	}
}
