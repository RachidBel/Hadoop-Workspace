package loanDatasetPackage;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

public class Loan_Driver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "JobName");
		BasicConfigurator.configure();
		job.setJarByClass(loanDatasetPackage.Loan_Driver.class);
		job.setMapperClass(loanDatasetPackage.Loan_Mapper.class);

		job.setReducerClass(loanDatasetPackage.Loan_Reducer.class);

		// TODO: specify output types
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		// TODO: specify input and output DIRECTORIES (not files)
		FileInputFormat.setInputPaths(job, new Path("train.csv"));
		FileOutputFormat.setOutputPath(job, new Path("out"));

		if (!job.waitForCompletion(true))
			return;
	}

}
