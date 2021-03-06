package pack;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Example_Mapper extends Mapper<LongWritable, Text, Text, LongWritable> {

	public void map(LongWritable ikey, Text ivalue, Context context)
			throws IOException, InterruptedException {

		// 15 delay
		// 16 Origin
		
		String line[]=ivalue.toString().split(",");
		
		try
		{
			context.write(new Text(line[16]), new LongWritable(Long.parseLong(line[15])));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
