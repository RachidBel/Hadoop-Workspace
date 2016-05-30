package q5_top10_CustomKey;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Grouping extends WritableComparator{

	public Grouping()
	{
		super(CustomKey.class,true);
	}
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		// TODO Auto-generated method stub
		
		CustomKey obj1 = (CustomKey)a;
		CustomKey obj2 = (CustomKey)b; 	
		return obj1.categeory.compareTo(obj2.categeory);
	}

}
