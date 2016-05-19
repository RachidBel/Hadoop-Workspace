package reduce_join;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class EmpProcessorMap extends Mapper<Object, Text, Text, Text > {

	private String fileTag="EF";//this tag is to differentiate the input file data at reducer side.
	
	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {		
		
//		 //taking one line/record at a time and parsing them into key value pairs
//		String line = value.toString();
//		String splitarray[] = line.split(",");
//		int empNumber = Integer.parseInt(splitarray[0].trim());
//		String empName = splitarray[1].trim();
//		Float salary = Float.parseFloat(splitarray[3].trim());
//		int deptNumber= Integer.parseInt(splitarray[4].trim());
//		
//		context.write(new IntWritable(deptNumber),new Text(fileTag+','+empNumber+','+empName+','+salary.toString()));
		String s1="";
		String arr[]=value.toString().split(",");
		//System.out.println(ivalue);
		if(arr[17].equals("SFO"))
		{
		int year=Integer.parseInt(arr[0]);
		int month=Integer.parseInt(arr[1]);
		int date=Integer.parseInt(arr[2]);
		System.out.println(value+"fight-delay");
		context.write(new Text(year+""+month+""+date),value);
		}
	
	}
}
