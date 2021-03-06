package day_7_Q1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

public class Q1_Driver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "JobName");
		BasicConfigurator.configure();
		job.setJarByClass(day_7_Q1.Q1_Driver.class);
		job.setMapperClass(day_7_Q1.Q1_Mapper.class);
		job.setReducerClass(day_7_Q1.Q1_Reducer.class);

		// TODO: specify output types
		job.setOutputKeyClass(CustomKey.class);
		job.setOutputValueClass(Text.class);
		
		job.setGroupingComparatorClass(day_7_Q1.Grouping.class);
	
		job.setPartitionerClass(day_7_Q1.MonthPartitioner.class);
		
		job.setNumReduceTasks(12);
		// TODO: specify input and output DIRECTORIES (not files)
		FileInputFormat.setInputPaths(job, new Path("nyse_2009.csv"));
		FileOutputFormat.setOutputPath(job, new Path("Q1-output"));

		if (!job.waitForCompletion(true))
			return;
	}

}
