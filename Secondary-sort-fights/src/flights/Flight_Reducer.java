package flights;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Flight_Reducer extends Reducer<Flight, Text, Text, Text> {

	public void reduce(Flight _key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		// process values
		
		context.write(new Text(_key.year+"   "+_key.month+"   "+_key.date+"   "+_key.delay), null);
		
	}

}
