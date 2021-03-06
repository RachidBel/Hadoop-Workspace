package q5_top10_CustomKey;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapper1 extends Mapper<LongWritable,Text,CustomKey,Text>{
	// line [3] categeory
			// line [0] id
			// line [5] views
	CustomKey obj ;//= new CustomKey();
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		obj = new CustomKey();
		String line[]=value.toString().split("\t");
		try
		{
		obj.setCategeory(new Text(line[3]));
		obj.setId(new Text(line[0]));
		obj.setViews(new LongWritable(Long.parseLong(line[5])));
		
		System.out.println(line[3]+" "+line[0]+" "+line[5]);
		context.write(obj, new Text(""));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}
	
	

}
