package map_join_try;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Flight_Mapper extends Mapper<LongWritable, Text, Flight, Text> {
	
	Flight obj = new Flight();
	public void map(LongWritable ikey, Text ivalue, Context context)
			throws IOException, InterruptedException {
		String s1="";
		String arr[]=ivalue.toString().split(",");
		try
		{
		int year=Integer.parseInt(arr[0]);
		int month=Integer.parseInt(arr[1]);
		int date=Integer.parseInt(arr[2]);
		//int arrDelay = Integer.parseInt(arr[14]);
		int arrDelay = Integer.parseInt(arr[8]);
		System.out.println(year+""+month+""+date+""+arrDelay);
		
		obj.setYear(new IntWritable(year));
		obj.setMonth(new IntWritable(month));
		obj.setDate(new IntWritable(date));
		obj.setDelay(new IntWritable(arrDelay));
		context.write(obj, new Text(arrDelay+""));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}

