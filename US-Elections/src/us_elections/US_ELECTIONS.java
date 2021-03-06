package us_elections;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class US_ELECTIONS implements WritableComparable<US_ELECTIONS> {

	
	public Text state = new Text();
	public Text party = new Text();
	public LongWritable votes = new LongWritable();
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		state.readFields(arg0);
		party.readFields(arg0);
		votes.readFields(arg0);
	}

	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		state.write(arg0);
		party.write(arg0);
		votes.write(arg0);
	}

	public int compareTo(US_ELECTIONS arg0) {
		// TODO Auto-generated method stub
		int compareValue = this.state.compareTo(arg0.state);
		if (compareValue == 0)
			compareValue = this.party.compareTo(arg0.party);
//		if (compareValue == 0)
//			compareValue = this.votes.compareTo(arg0.votes);
		return compareValue;
	}
	
	public void setState(String arg)
	{
		this.state = new Text(arg);
	}
	public void setParty(String arg)
	{
		this.party= new Text(arg);
	}
	public void setVotes(LongWritable arg)
	{
		this.votes= arg;
	}

}
