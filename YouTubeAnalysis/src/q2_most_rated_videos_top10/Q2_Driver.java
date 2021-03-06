package q2_most_rated_videos_top10;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

import q1_youtube_analysis.Mapper1;



public class Q2_Driver {

	public static void main(String[] args) throws Exception
	{
		Job job = new Job();
		
		Configuration conf = job.getConfiguration();
		BasicConfigurator.configure();
		job.setJarByClass(Q2_Driver.class);
		job.setMapperClass(q2_most_rated_videos_top10.Q2_Mapper.class);
		job.setReducerClass(q2_most_rated_videos_top10.Q2_Reducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);
		
		FileInputFormat.addInputPath(job, new Path("hdfs://localhost:9000/youtube/0.txt"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/youtube/youtube-analysis-top-10-ratings"));
		
		if(!job.waitForCompletion(true))
		{
			return;
		}
	}

}
