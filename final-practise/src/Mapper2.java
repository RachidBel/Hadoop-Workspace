import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class Mapper2 extends Mapper<LongWritable,Text,CustomKey,Text>{

	CustomKey obj;
	@Override
	protected void map(LongWritable key, Text value,
			org.apache.hadoop.mapreduce.Mapper.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		// date ascending 
		// ArrDelay 
		
		obj = new CustomKey();
		String a[]=value.toString().split(",");
		
		int year = Integer.parseInt(a[0]);
		int month = Integer.parseInt(a[1]);
		int date= Integer.parseInt(a[2]);
		int arrDelay = Integer.parseInt(a[8]);
		
		obj.setYear(new IntWritable(year));
		obj.setMonth(new IntWritable(month));
		obj.setDate(new IntWritable(date));
		obj.setArrDelay(new IntWritable(arrDelay));
		context.write(obj, value);
	}
	
	

}