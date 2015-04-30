package com.manh.cim;

import com.ibm.mobile.services.data.IBMDataException;
import com.ibm.mobile.services.data.IBMObjectResult;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.view.ActionMode;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	private ProgressDialog progress;
	 public final static String EXTRA_MESSAGE = "com.manh.cim.MESSAGE";
	protected static final String CLASS_NAME = "MainActivity";
	CimApplication cimApplication;
	ArrayAdapter<Employee> lvArrayAdapter;
	ActionMode mActionMode = null;
	int listItemPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        progress = new ProgressDialog(this);
		
		open();
        
        
        setContentView(R.layout.activity_main);
        
        
        cimApplication = (CimApplication) getApplication();
        Button searchButton = (Button)findViewById(R.id.searchButton);
        
        
   /*     searchButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	startActivity(new Intent(MainActivity.this, LayoutDemo.class));                                
            }
    });
            }*/
         
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    
    
    public void open(){    	
	      progress.setMessage("Initializing.. Please Wait ");
	      progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	      progress.setIndeterminate(true);
	      progress.show();

	   final int totalProgressTime = 100;
	   int jumpTime = 0;
	      while(jumpTime < totalProgressTime){
	      
	            jumpTime += 5;
	            progress.setProgress(jumpTime);   

	      }
    }
    
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;                       
        }
    }
    
    
    // loads search results page
    public void LoadSearchResults(View view){
    	Intent intent = new Intent(this, DisplaySearchResultsActivity.class);
    	EditText editText = (EditText) findViewById(R.id.searchTextBox);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
    public void saveEmployee(Employee employee) {
    	employee.saveInBackground(new IBMObjectResult<Employee>() {
				/**
				 * If the result succeeds, onResult gets called with the object that was created.
				 */
				public void onResult(Employee object) {
					if (!isFinishing()) {
						// saved successfully
					}
				}
				/**
				 * If the result failed, onError is called with an exception that describes the error.
				 */
				public void onError(IBMDataException error) {
					Log.e(CLASS_NAME, "Exception : " + error.getMessage());
				}
			});
			//set text field back to empty after item added			
		}
}
