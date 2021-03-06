package us_elections;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class US_Reducer extends Reducer<US_ELECTIONS, LongWritable, Text, LongWritable> {

	private long totalVotes = 0;
	public void reduce(US_ELECTIONS _key, Iterable<LongWritable> values, Context context)
			throws IOException, InterruptedException {
		// process values
		
		long partyVotes = 0 ;
		for (LongWritable val : values) {
			partyVotes = partyVotes + val.get();
		}
		totalVotes = totalVotes + partyVotes ;
		context.write(new Text(_key.state+" "+_key.party), new LongWritable(partyVotes));
	}

	@Override
	protected void cleanup(org.apache.hadoop.mapreduce.Reducer.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		context.write(new Text("Total votes "), new LongWritable (totalVotes));
	}

	
}
