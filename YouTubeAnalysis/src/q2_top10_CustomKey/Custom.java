package q2_top10_CustomKey;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class Custom implements WritableComparable<Custom> {

	public FloatWritable rating = new FloatWritable();
	public Text id = new Text();
	
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		rating.readFields(arg0);
		id.readFields(arg0);
	}

	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		rating.write(arg0);
		id.write(arg0);
	}

	public int compareTo(Custom arg0) {
		// TODO Auto-generated method stub
		int cv = -1*this.rating.compareTo(arg0.rating);
		return cv;
	}
	public void setId(String i)
	{
		this.id.set(i);
	}
	public void setRating(float r)
	{
		this.rating.set(r);
	}

}
