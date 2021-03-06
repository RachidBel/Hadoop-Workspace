package day_7_Q1;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class CustomKey implements WritableComparable<CustomKey>{

	public Text date = new Text();
	public Text stock = new Text();
	public Text volume = new Text();
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		date.readFields(arg0);
		stock.readFields(arg0);
		volume.readFields(arg0);
	}

	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		date.write(arg0);
		stock.write(arg0);
		volume.write(arg0);
	}

	public int compareTo(CustomKey arg0) {
		// TODO Auto-generated method stub
		int cv = this.date.compareTo(arg0.date);
		if(cv==0)
			cv=-1*this.volume.compareTo(arg0.volume);
		return cv;
	}
	public void setDate(Text t)
	{
		this.date = t;
	}
	public void setStock(Text t)
	{
		this.stock = t;
	}
	public void setVolume(Text t)
	{
		this.volume = t;
	}

}
