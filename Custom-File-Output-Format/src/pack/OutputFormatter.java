package pack;

import java.io.IOException;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class OutputFormatter extends FileOutputFormat<Text, Text>{

	@Override
	public RecordWriter<Text, Text> getRecordWriter(TaskAttemptContext arg0)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		Path path = FileOutputFormat.getOutputPath(arg0);
		Path fullPath = new Path(path,"results.xml");
		FileSystem fs = path.getFileSystem(arg0.getConfiguration());
		FSDataOutputStream fileout = fs.create(fullPath,arg0);
		
		return new CustomRecordWriter(fileout);
	}

}
