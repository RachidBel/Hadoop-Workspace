/**
 * Dataset -- > NYSE_2014 
 * 
 use the NYSE dataset with following attributes:
stockTicker � stock name or symbol   0
tradeDate   1
openingPrice  2
highPrice 3
lowPrice 4
closingPrice 5
volume  6

1.	Find the average stock volume per each month

 * 
 * 
 * 
 * 
 */
package day6_Q1;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q1Mapper extends Mapper<LongWritable, Text, Text, Text> {

	public void map(LongWritable ikey, Text ivalue, Context context)
			throws IOException, InterruptedException {

		String line[]=ivalue.toString().split(",");
		String date = line [1];
		String month = date.substring(3, 6);
		String vol = line[6];
		System.out.println(vol);
		context.write(new Text(month), new Text(vol));
	}

}
