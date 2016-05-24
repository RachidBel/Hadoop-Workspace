package q5_top_10_most_viewed_videos;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Q5_Reducer extends Reducer <Q5_Custom,Text,Text,Text>{

	@Override
	protected void reduce(Q5_Custom arg0, Iterable<Text> arg1,Context arg2)
			throws IOException, InterruptedException {
		int i=0;
		for(Text t:arg1)
		{
			if(i<=10)
			{
				arg2.write(new Text(arg0.id+" "+arg0.categeory), t);
			}
		}
		
	}

}