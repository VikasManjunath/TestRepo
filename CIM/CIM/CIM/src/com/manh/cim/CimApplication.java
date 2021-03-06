/*
 * Copyright 2014 IBM Corp. All Rights Reserved
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.manh.cim;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import com.ibm.mobile.services.core.IBMBaaS;
import com.ibm.mobile.services.data.IBMData;

@SuppressLint("NewApi")
public final class CimApplication extends Application {
	private static final String APP_ID = "applicationID";
	private static final String PROPS_FILE = "CIM.properties";
	public static final int EDIT_ACTIVITY_RC = 1;
	private static final String CLASS_NAME = CimApplication.class
			.getSimpleName();
	List<Employee> itemList;

	@SuppressLint("NewApi")
	public CimApplication() {
		registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
			@Override
			public void onActivityCreated(Activity activity,
					Bundle savedInstanceState) {
				Log.d(CLASS_NAME,
						"Activity created: " + activity.getLocalClassName());
			}

			@Override
			public void onActivityStarted(Activity activity) {
				Log.d(CLASS_NAME,
						"Activity started: " + activity.getLocalClassName());
			}

			@Override
			public void onActivityResumed(Activity activity) {
				Log.d(CLASS_NAME,
						"Activity resumed: " + activity.getLocalClassName());
			}

			@Override
			public void onActivitySaveInstanceState(Activity activity,
					Bundle outState) {
				Log.d(CLASS_NAME,
						"Activity saved instance state: "
								+ activity.getLocalClassName());
			}

			@Override
			public void onActivityPaused(Activity activity) {
				Log.d(CLASS_NAME,
						"Activity paused: " + activity.getLocalClassName());
			}

			@Override
			public void onActivityStopped(Activity activity) {
				Log.d(CLASS_NAME,
						"Activity stopped: " + activity.getLocalClassName());
			}

			@Override
			public void onActivityDestroyed(Activity activity) {
				Log.d(CLASS_NAME,
						"Activity destroyed: " + activity.getLocalClassName());
			}
		});
	}

	@Override
	public void onCreate() {
		super.onCreate();
		itemList = new ArrayList<Employee>();
		// Read from properties file
		Properties props = new java.util.Properties();
		Context context = getApplicationContext();
		try {
			AssetManager assetManager = context.getAssets();
			props.load(assetManager.open(PROPS_FILE));
			Log.i(CLASS_NAME, "Found configuration file: " + PROPS_FILE);
		} catch (FileNotFoundException e) {
			Log.e(CLASS_NAME, "The bluelist.properties file was not found.", e);
		} catch (IOException e) {
			Log.e(CLASS_NAME,
					"The bluelist.properties file could not be read properly.", e);
		}
		// initialize the IBM core backend-as-a-service
		IBMBaaS.initializeSDK(this, props.getProperty(APP_ID));
		// initialize the IBM Data Service
		IBMData.initializeService();
		// register the Item Specialization
		Employee.registerSpecialization(Employee.class);
	}

	/**
	 * returns the itemList, an array of Item objects.
	 * 
	 * @return itemList
	 */
	public List<Employee> getItemList() {
		return itemList;
	}
}