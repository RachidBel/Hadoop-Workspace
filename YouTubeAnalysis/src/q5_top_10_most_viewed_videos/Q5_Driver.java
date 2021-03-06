package q5_top_10_most_viewed_videos;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

public class Q5_Driver {

	public static void main(String []args) throws Exception
	{
		Job job = new Job();
		Configuration conf = job.getConfiguration();
		BasicConfigurator.configure();
		job.setJarByClass(q5_top_10_most_viewed_videos.Q5_Driver.class);
		job.setMapperClass(q5_top_10_most_viewed_videos.Q5_Mapper.class);
		job.setReducerClass(q5_top_10_most_viewed_videos.Q5_Reducer.class);
		job.setGroupingComparatorClass(q5_top10_CustomKey.Grouping.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileInputFormat.setInputPaths(job, new Path("hdfs://localhost:9000/youtube/0.txt"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/youtube/top-10-rated-by-Categeory"));
		
		if(!job.waitForCompletion(true))
			return;
	}

}
