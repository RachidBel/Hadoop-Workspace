package q2_top10_CustomKey;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapper1 extends Mapper <LongWritable,Text,Custom,Text>{

	Custom obj;
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		// 0 id
		// 6 Rating
		obj = new Custom();
        String line[] = value.toString().split("\t");
        System.out.println(line[0]+"  "+line[6]);
		try
		{
			obj.setId(line[0]);
			obj.setRating(Float.parseFloat(line[6]));
		    context.write(obj,new Text("") );
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
}
