import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;


public class CustomRecordReader extends
		RecordReader<LongWritable, FlightCustom> {

	LineRecordReader l;
	FlightCustom fl;
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

		l.close();
	}

	@Override
	public LongWritable getCurrentKey() throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		return l.getCurrentKey();
	}

	@Override
	public FlightCustom getCurrentValue() throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		return fl;
	}

	@Override
	public float getProgress() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return l.getProgress();
	}

	@Override
	public void initialize(InputSplit arg0, TaskAttemptContext arg1)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		l = new LineRecordReader();
		l.initialize(arg0, arg1);
	}

	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		if(!l.nextKeyValue())
		return false;
		String s[]=l.getCurrentValue().toString().split(",");
		fl = new FlightCustom();
		fl.set();
		return true;
	}

}
