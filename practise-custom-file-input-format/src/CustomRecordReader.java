import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;


public class CustomRecordReader extends RecordReader<LongWritable, CustomEmp> {

	LineRecordReader line;
	CustomEmp obj;
	
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

		line.close();
	}

	@Override
	public LongWritable getCurrentKey() throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		return line.getCurrentKey();
	}

	@Override
	public CustomEmp getCurrentValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return obj;
	}

	@Override
	public float getProgress() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return line.getProgress();
	}

	@Override
	public void initialize(InputSplit arg0, TaskAttemptContext arg1)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		line = new LineRecordReader();
		line.initialize(arg0, arg1);
	}

	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		if(!line.nextKeyValue())
		{
		return false;
		}
		String a[]=line.getCurrentValue().toString().split(",");		
		//  a[0] sal
		//  a[1] category
		obj = new CustomEmp();
		obj.set(a[0],a[1]);
		return true;
		
	}

}
