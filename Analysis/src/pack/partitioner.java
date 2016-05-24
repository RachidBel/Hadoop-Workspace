package pack;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class partitioner extends Partitioner<Text,LongWritable>{

	@Override
	public int getPartition(Text arg0, LongWritable arg1, int arg2) {
		// TODO Auto-generated method stub
		
		String s = arg0.toString();
		char c = s.charAt(0);
		
		if(c>='A' && c<='M')
			return 1;
		else
		    return 0;
	}

}
