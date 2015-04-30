package com.manh.cim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.view.ActionMode;
import android.support.v4.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;
import android.provider.SyncStateContract.Constants;

public class DisplaySearchResultsActivity extends ListActivity {
	public ArrayList<Employee> lvArrayAdapter = new ArrayList<Employee>();
	ArrayList<String> namesList = new ArrayList<String>(); 
	Map<String,Employee> employeeMap = new HashMap<String,Employee>();
	
	protected static final String USER_MESSAGE = "com.manh.cim.MESSAGE";
	ActionMode mActionMode = null;
	int listItemPosition;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
	 
		final ListView listview ;//= (ListView) findViewById(R.id.searchResultsDisplayView);
		 final ArrayList<String> list = new ArrayList<String>();
		 
		 
		 
		 
		 
		 
		  list.add(message.toString());
		  list.add("hardcoded");
		  CreateEmployeeList();
		   final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, namesList);	   
		    setListAdapter(adapter);
		  //  listview.setAdapter(adapter);	
		   // listview.setOnClickListener(null);
		    
		    listview =  this.getListView();
		    
		    listview.setOnItemClickListener(new OnItemClickListener() {
		    	 
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                   int position, long id) {
                  
                 // ListView Clicked item index
                 int itemPosition     = position;
                 
                 // ListView Clicked item value
                 String  itemValue    = (String) listview.getItemAtPosition(position);
                 
                 
                 
                 
                 
                 
                    
                  // Show Alert 
                  Toast.makeText(getApplicationContext(),
                    "  Details of : " +itemValue , Toast.LENGTH_LONG)
                    .show();
                  
                  Employee emp = employeeMap.get(itemValue);
                    	LoadSearchResults(emp);
               
                }
  
           }); 
		    
	}
	
	//----------------------------------
	
	
	
	public void CreateEmployeeList()
    {
       ArrayList<String> reviewList = new ArrayList<String>();
       reviewList.add("OFM General|5");
       reviewList.add("OFM Run Queueing|5");
       reviewList.add("OFM Load Balancing|5");
       reviewList.add("HDRP Run Failure|5");
       reviewList.add("HDRP Consolidation|5");
       reviewList.add("HDRP Time Feasibility|5");
       reviewList.add("HDRP Orphaned Orders|5");
       reviewList.add("HDRP Static Routes|5");
       reviewList.add("PFLT Run Failure|2");
       reviewList.add("PFLT Orphaned Orders|2");
      reviewList.add("PFLT Consolidation|2");
       reviewList.add("PFLT Time Feasibility|2");
       reviewList.add("PFLT Cross-docking|2");
       reviewList.add("PFLT L4 Splitting|2");
       reviewList.add("PFLT Static Routes|2");
       reviewList.add("Cons 4.0 Consolidation|2");
       reviewList.add("Cons 4.0 Orphaned Orders|3");
       reviewList.add("Cons 4.0 Costs|2");
       reviewList.add("Cons 4.0 Cross-Docking|2");
       reviewList.add("Cons 4.0 Time Feasibility|3");
       reviewList.add("TP General|3");
       reviewList.add("TP Cost|3");
       reviewList.add("TP Infeasibility|3");
       reviewList.add("TP Load Constraints|2");
       Employee empVikas = new Employee("Vikas Manjunath","vmanjunath@manh.com","4837","Karthikeyan Subramanian",2015,reviewList);
       employeeMap.put(empVikas.getEmployeeName(),empVikas);
       lvArrayAdapter.add(empVikas);
       namesList.add(empVikas.getEmployeeName().toString());

       
       reviewList.clear();
       reviewList.add("OFM General|2");
       reviewList.add("OFM Run Queueing|2");
       reviewList.add("OFM Load Balancing|2");
       reviewList.add("HDRP Run Failure|2");
       reviewList.add("HDRP Consolidation|2");
       reviewList.add("HDRP Time Feasibility|2");
       reviewList.add("HDRP Orphaned Orders|2");
       reviewList.add("HDRP Static Routes|2");
       reviewList.add("PFLT Run Failure|5");
       reviewList.add("PFLT Orphaned Orders|5");
       reviewList.add("PFLT Consolidation|4");
       reviewList.add("PFLT Time Feasibility|5");
       reviewList.add("PFLT Cross-docking|4");
       reviewList.add("PFLT L4 Splitting|4");
       reviewList.add("PFLT Static Routes|5");
       reviewList.add("Cons 4.0 Consolidation|2");
       reviewList.add("Cons 4.0 Orphaned Orders|2");
       reviewList.add("Cons 4.0 Costs|2");
       reviewList.add("Cons 4.0 Cross-Docking|2");
       reviewList.add("Cons 4.0 Time Feasibility|2");
       reviewList.add("TP General|2");
       reviewList.add("TP Cost|2");
       reviewList.add("TP Infeasibility|2");
       reviewList.add("TP Load Constraints|2");
       Employee empRajeev = new Employee("Rajeev K Chaubey","rchaubey@manh.com","4665","Karthikeyan Subramanian",157,reviewList);       
       employeeMap.put(empRajeev.getEmployeeName(),empRajeev);
       lvArrayAdapter.add(empRajeev);
       namesList.add(empRajeev.getEmployeeName());
       
       reviewList.clear();
       reviewList.add("OFM General|2");
       reviewList.add("OFM Run Queueing|2");
       reviewList.add("OFM Load Balancing|2");
       reviewList.add("HDRP Run Failure|2");
       reviewList.add("HDRP Consolidation|2");
       reviewList.add("HDRP Time Feasibility|2");
       reviewList.add("HDRP Orphaned Orders|2");
       reviewList.add("HDRP Static Routes|2");
       reviewList.add("PFLT Run Failure|2");
       reviewList.add("PFLT Orphaned Orders|2");
      reviewList.add("PFLT Consolidation|2");
       reviewList.add("PFLT Time Feasibility|2");
       reviewList.add("PFLT Cross-docking|2");
       reviewList.add("PFLT L4 Splitting|2");
       reviewList.add("PFLT Static Routes|2");
       reviewList.add("Cons 4.0 Consolidation|4");
       reviewList.add("Cons 4.0 Orphaned Orders|4");
       reviewList.add("Cons 4.0 Costs|4");
       reviewList.add("Cons 4.0 Cross-Docking|4");
       reviewList.add("Cons 4.0 Time Feasibility|4");
       reviewList.add("TP General|5");
       reviewList.add("TP Cost|5");
       reviewList.add("TP Infeasibility|5");
       reviewList.add("TP Load Constraints|5");
       Employee empSandeep = new Employee("Sandeep Sreyas","ssreyas@manh.com","4665","Chandrasekhar",157,reviewList);
       employeeMap.put(empSandeep.getEmployeeName(),empSandeep);
       lvArrayAdapter.add(empSandeep);
       namesList.add(empSandeep.getEmployeeName());

       reviewList.clear();
       reviewList.add("OFM General|2");
       reviewList.add("OFM Run Queueing|2");
       reviewList.add("OFM Load Balancing|2");
       reviewList.add("HDRP Run Failure|2");
       reviewList.add("HDRP Consolidation|2");
       reviewList.add("HDRP Time Feasibility|2");
       reviewList.add("HDRP Orphaned Orders|2");
       reviewList.add("HDRP Static Routes|2");
       reviewList.add("PFLT Run Failure|2");
       reviewList.add("PFLT Orphaned Orders|2");
       reviewList.add("PFLT Consolidation|2");
       reviewList.add("PFLT Time Feasibility|2");
       reviewList.add("PFLT Cross-docking|2");
       reviewList.add("PFLT L4 Splitting|2");
       reviewList.add("PFLT Static Routes|2");
       reviewList.add("Cons 4.0 Consolidation|5");
       reviewList.add("Cons 4.0 Orphaned Orders|5");
       reviewList.add("Cons 4.0 Costs|5");
       reviewList.add("Cons 4.0 Cross-Docking|5");
       reviewList.add("Cons 4.0 Time Feasibility|5");
       reviewList.add("TP General|2");
       reviewList.add("TP Cost|2");
       reviewList.add("TP Infeasibility|2");
       reviewList.add("TP Load Constraints|2");
       Employee empApoorva = new Employee("Apoorva Nagaraju","anagaraju@manh.com","4665","Karthikeyan",2016,reviewList);
       employeeMap.put(empApoorva.getEmployeeName(),empApoorva);
       lvArrayAdapter.add(empApoorva);
       namesList.add(empApoorva.getEmployeeName());
       
       
       
       
       reviewList.clear();
       reviewList.add("OFM General|3");
       reviewList.add("OFM Run Queueing|2");
       reviewList.add("OFM Load Balancing|2");
       reviewList.add("HDRP Run Failure|2");
       reviewList.add("HDRP Consolidation|2");
       reviewList.add("HDRP Time Feasibility|2");
       reviewList.add("HDRP Orphaned Orders|3");
       reviewList.add("HDRP Static Routes|3");
       reviewList.add("PFLT Run Failure|4");
       reviewList.add("PFLT Orphaned Orders|5");
      reviewList.add("PFLT Consolidation|5");
       reviewList.add("PFLT Time Feasibility|4");
       reviewList.add("PFLT Cross-docking|5");
       reviewList.add("PFLT L4 Splitting|5");
       reviewList.add("PFLT Static Routes|4");
       reviewList.add("Cons 4.0 Consolidation|4");
       reviewList.add("Cons 4.0 Orphaned Orders|4");
       reviewList.add("Cons 4.0 Costs|4");
       reviewList.add("Cons 4.0 Cross-Docking|3");
       reviewList.add("Cons 4.0 Time Feasibility|3");
       reviewList.add("TP General|2");
       reviewList.add("TP Cost|2");
       reviewList.add("TP Infeasibility|2");
       reviewList.add("TP Load Constraints|2");
       Employee empKarthik = new Employee("Karthik Srinivasan","ksrinivasan@manh.com","4012","Karthikeyan",2567,reviewList);
       employeeMap.put(empKarthik.getEmployeeName(),empKarthik);
       lvArrayAdapter.add(empKarthik);
       namesList.add(empKarthik.getEmployeeName());
       
       reviewList.clear();
       reviewList.add("OFM General|2");
       reviewList.add("OFM Run Queueing|2");
       reviewList.add("OFM Load Balancing|2");
       reviewList.add("HDRP Run Failure|2");
       reviewList.add("HDRP Consolidation|2");
       reviewList.add("HDRP Time Feasibility|2");
       reviewList.add("HDRP Orphaned Orders|2");
       reviewList.add("HDRP Static Routes|2");
       reviewList.add("PFLT Run Failure|5");
       reviewList.add("PFLT Orphaned Orders|4");
       reviewList.add("PFLT Consolidation|4");
       reviewList.add("PFLT Time Feasibility|5");
       reviewList.add("PFLT Cross-docking|5");
       reviewList.add("PFLT L4 Splitting|4");
       reviewList.add("PFLT Static Routes|4");
       reviewList.add("Cons 4.0 Consolidation|2");
       reviewList.add("Cons 4.0 Orphaned Orders|2");
       reviewList.add("Cons 4.0 Costs|2");
       reviewList.add("Cons 4.0 Cross-Docking|2");
       reviewList.add("Cons 4.0 Time Feasibility|2");
       reviewList.add("TP General|2");
       reviewList.add("TP Cost|2");
       reviewList.add("TP Infeasibility|2");
       reviewList.add("TP Load Constraints|2");
       Employee empSatya= new Employee("Satya Sameer","ssameer@manh.com","4758","Karthikeyan",2098,reviewList);
       
       employeeMap.put(empSatya.getEmployeeName(),empKarthik);
       lvArrayAdapter.add(empSatya);
       namesList.add(empSatya.getEmployeeName());
}
//Dummy --------------------------------

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_search_results, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_display_search_results, container, false);
			return rootView;
		}
	}

	
	 public void LoadSearchResults(Employee User){
	    //	Intent intent = new Intent(this, DisplayUserActivity.class);
		 Intent intent = new Intent(this, DisplayUserActivity.class);
	    	intent.putExtra(USER_MESSAGE, User);
	    	startActivity(intent);	   
	    }
	
	
}
