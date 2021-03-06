package q2_most_rated_videos_top10;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Q2_Reducer extends Reducer<Text,FloatWritable , Text, FloatWritable>{

	private Map<String,Float> map = new HashMap<String,Float>();
	@Override
	protected void cleanup(Context context)
			throws IOException, InterruptedException {
		
		Map < String , Float > sortedMap = sortValues(map); 
		int i=1;
		
		for(String s: sortedMap.keySet())
		{
			if(i<=10)
			{
				context.write(new Text(s), new FloatWritable(sortedMap.get(s)));
				i++;
			}
			else
			{
				break;
			}
		}
		
	}

	private Map<String, Float> sortValues(Map<String, Float> map2) {
		// TODO Auto-generated method stub
	
		Map <String ,Float > sorted = new LinkedHashMap<String,Float>();
		List<Map.Entry<String, Float>>  entries = new LinkedList<Map.Entry<String,Float>>(map2.entrySet());
		
		Collections.sort(entries, new Comparator<Map.Entry<String, Float>>(){

			public int compare(Entry<String, Float> arg0,
					Entry<String, Float> arg1) {
				// TODO Auto-generated method stub
				return -1*arg0.getValue().compareTo(arg1.getValue());
			}
			
		});
		
		
		for(Map.Entry<String, Float> e : entries)
		{
			sorted.put(e.getKey(), e.getValue());
		}
		return sorted;
		
	}

	@Override
	protected void reduce(Text arg0, Iterable<FloatWritable> arg1,Context arg2)
			throws IOException, InterruptedException {
		
		float sum = 0 ;
		for(FloatWritable val : arg1)
		{
			sum = sum + val.get();
		}
		map.put(arg0.toString(), sum);
	}

}
