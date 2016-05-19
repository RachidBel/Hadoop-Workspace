package us_elections;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class US_State_Grouping extends WritableComparator{
	
	public US_State_Grouping()
	{
		super(US_ELECTIONS.class,true);
	}
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		// TODO Auto-generated method stub
		US_ELECTIONS object1 = (US_ELECTIONS)a;
		US_ELECTIONS object2 = (US_ELECTIONS)b;
		 int cv=object1.state.compareTo(object2.state);
		 return cv;
	}

}