package pack;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reducer1 extends Reducer<Text,Text,Text,Text>{

	@Override
	protected void reduce(Text arg0, Iterable<Text> arg1,Context context)
			throws IOException, InterruptedException {
		
		
		int sum=0;
		
		for(Text val:arg1)
		{
			sum = sum + Integer.parseInt(val.toString());
		}
		
		context.write(arg0, new Text(sum+""));
	}

	
}
