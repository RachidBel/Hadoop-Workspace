package q1_youtube_analysis;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;



public class Q1_Driver {

	
	public static void main (String []args) throws Exception
	{
		Job job = new Job();
		Configuration conf = job.getConfiguration();
		BasicConfigurator.configure();
		job.setJarByClass(q1_youtube_analysis.Q1_Driver.class);
		job.setMapperClass(q1_youtube_analysis.Mapper1.class);
		job.setReducerClass(q1_youtube_analysis.Reducer1.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path("hdfs://localhost:9000/youtube/0.txt"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/youtube/youtube-analysis-Q1-GitHub-highToLow"));
		
		if(!job.waitForCompletion(true))
		{
			return;
		}
		
	}
}
