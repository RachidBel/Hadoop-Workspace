import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



//  arr-delay 14
// airport code 17
// flight num 9
// year 0
// month 1
// day 2
public class Mapper1 extends Mapper<LongWritable,Text,Text,Text>{

	@Override
	protected void map(LongWritable key, Text value,
			org.apache.hadoop.mapreduce.Mapper.Context context)
			throws IOException, InterruptedException {
		String split[]=value.toString().split(",");
		
			if(!split[0].equals("Year"))
			{
				if(!split[14].equals("NA"))
				{
					context.write(new Text(split[17]),new Text(split[14]+","+split[9]+","+split[0]+","+split[1]+","+split[2]) );
				}
			}
		

	}
	

}
