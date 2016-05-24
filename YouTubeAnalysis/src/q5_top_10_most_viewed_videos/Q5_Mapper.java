package q5_top_10_most_viewed_videos;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q5_Mapper extends Mapper<LongWritable,Text,Q5_Custom,Text>{

	Q5_Custom obj;
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		
		String line[] = value.toString().split("\t");
		try
		{
		obj.setID(new Text(line[0]));
		obj.setCategeory(new Text(line[3]));
		obj.setViews(new LongWritable(Long.parseLong(line[5])));
		context.write(obj, new Text(""));
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	

}