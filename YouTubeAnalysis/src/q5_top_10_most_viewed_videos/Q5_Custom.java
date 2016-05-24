package q5_top_10_most_viewed_videos;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class Q5_Custom implements WritableComparable<Q5_Custom> {
	
	public Text id = new Text();
	public Text categeory = new Text();
	public LongWritable views = new LongWritable();
	


	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		id.readFields(arg0);
		categeory.readFields(arg0);
		views.readFields(arg0);
	}

	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		id.write(arg0);
		categeory.write(arg0);
		views.write(arg0);
	}

	public int compareTo(Q5_Custom arg0) {
		// TODO Auto-generated method stub
		int cv = this.id.compareTo(arg0.id);
		if(cv==0)
		{
			cv=this.categeory.compareTo(arg0.categeory);
		}
		if(cv==0)
		{
			cv = -1*this.views.compareTo(arg0.views);
		}
		return cv;
	}
	
	public void setID(Text i)
	{
		this.id=i;
	}
	
	public void setCategeory(Text c)
	{
		this.categeory=c;
	}
	
	public void setViews(LongWritable v)
	{
		this.views=v;
	}
}