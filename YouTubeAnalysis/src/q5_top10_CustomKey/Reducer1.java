package q5_top10_CustomKey;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reducer1 extends Reducer <CustomKey,Text,Text,Text>{

	@Override
	protected void reduce(CustomKey key, Iterable<Text> values,Context context)
			throws IOException, InterruptedException {
				int i = 0 ;

for(Text s:values)
{
	
if(i++<10)
			context.write(new Text(key.categeory+" "+key.id+" "+key.views), new Text(""));
		
}
	}

}
