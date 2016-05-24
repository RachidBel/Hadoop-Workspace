package q1_youtube_analysis;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapper1 extends Mapper <LongWritable,Text,Text,IntWritable> {

	@Override
	protected void map(LongWritable key, Text value,
			Context context)
			throws IOException, InterruptedException {
		
		String line[] = value.toString().split("\t");
		try
		{
			System.out.println(line[3]);
		context.write(new Text(line[3]), new IntWritable(1));
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	

}