# AppMaster

AppMaster is a laibray for android which helps in creating some of the required files and folder without any hustle.

You can easiy create shared preferences and store data like ArrayList, float, int, string and etc.
And to get the instance of a value which always remains constant try to declare them in the Constants.java.

## Usage

First, create a new module by right clicking on app folder.
Then, select 'Android Library' and name the module 'generator'.
After the module is created create a 'Java' file name 'FileGenerator.java'.

Add this line to root folder of your build.gradle.

```sh
allprojects {
    repositories {      
        maven { url 'https://jitpack.io' }
    }
}
```
Then add this line to module level build,gradle

```diff
implementation 'com.github.Mritunjay10:AppMaster:v1.0'
```

The completing `sync` add the following code in 'FileGenerator.java':

```sh
   public static void main(String[] args) {

        String PACKAGE = "YOUR_PACKAGE_NAME"; //present in manifest or build.gradle file
        String APP_NAME = " \"YOUR_APP_NAME\" ";

        OperationHelper.execute(PACKAGE, APP_NAME);
    }
```

After adding the above lines click on the `FileGenerator.java` and press `Ctrl+Shift+F10`.

If the code finished with `exit code 0` voila you have just create the following files:


```sh
|───app  
│
|───helper
│     |───INDIPreferences.java
│   
|───utils
│     |───Constants.java
|
|───INDIMaster.java
```
Make sure after creating the folders you refract all the activity inside the `app` folder.

And change the appliction name to `.INDIMaster` in `manifest` file as shown below:

```sh
 <application
        android:name=".INDIMaster"
        ...
```
## How it works

The function of `Constants.java` file is to store static String, float, int, array values, for e.g:
```sh
String APP_URL = 'http://www.your_url.com'; /// String is defined in Constants.java
```
And, to access the reference just add `implements Constants to any class`.

Here, `INDIMaster` is a Application class which defines the overall properties of the application.
In, `INDIMaster.java` I have already defined a function `getInstance()` which allows you to access the application context in
the entire application just type `INDIMaster.getInstance()` and it will return you the application context.

But, make sure to change the appliction name to `.INDIMaster` in `manifest` file as shown below:

```sh
 <application
        android:name=".INDIMaster"
        ...
```
else, it will throw an error and application will keep crashing.

Now, for `INDIPreferences.java` which is a handler class for shared preferences.
It will help you to access shared preferences without long and pathetic code.
Look at the examples below:

```
//// Add following lines to store and retrive boolean

   public static void saveBoolean(boolean b, String key) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(key, b);   /// Always change key while creating other funtion to store boolean
        editor.commit();
    }

    public static boolean getBoolean(String key) {
        SharedPreferences mSharedPreferences = getPreferences();
        return mSharedPreferences.getBoolean(key, false);
    }
    
 //// Add following lines to store and retrive String
 
    public static void saveString(String value, String key) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(key, value);  /// Always change key while creating other funtion to store string
        editor.commit();
    }

    public static String getString(String key) {
        SharedPreferences mSharedPreferences = getPreferences();
        return mSharedPreferences.getString(key, "");
    }
    
 //// Add following lines to store and retrive int
 
    public static void saveInt(int value, String key) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(key, value);  /// Always change key while creating other funtion to store int
        editor.commit();
    }

    public static String getInt(String key) {
        SharedPreferences mSharedPreferences = getPreferences();
        return mSharedPreferences.getString(key, 0);
    }   
    
```
Now, to save a String, int and boolean value you have to call the below functions:
```s
  INDIPreferences.saveString("Your value", "UNIQUE_STRING_KEY_TO_RETRIVE");
  INDIPreferences.saveInt(0, "UNIQUE_INT_KEY_TO_RETRIVE");
  INDIPreferences.saveBoolean(true, "UNIQUE_BOOLEAN_KEY_TO_RETRIVE");

```
And, to get stored data
```s
  INDIPreferences.getString("UNIQUE_STRING_KEY_TO_RETRIVE");
  INDIPreferences.getInt("UNIQUE_INT_KEY_TO_RETRIVE");
  INDIPreferences.getBoolean("UNIQUE_BOOLEAN_KEY_TO_RETRIVE");

```
For, better understanding of `'UNIQUE_STRING_KEY_TO_RETRIVE'` read shared preferences docs.

Like, the above example you can save float, int, string as per your need.


## Storing array list

In order to save ArrayList<String>, ArrayList<~> or any list, you have to add the following lines in app level `build.gradle`:

```S
implementation 'com.google.code.gson:gson:2.8.5'
```

Then add following function to store ArrayList<String>:
  
```S 
public static void saveArrayListStrings(ArrayList<String> strings, String key) {
    SharedPreferences.Editor editor = getPreferences().edit();
    Gson gson = new Gson();
    String jsonStrings = gson.toJson(strings);
    editor.putString(key, jsonStrings);
    editor.commit();
 }
```
To, get ArrayList<String>:
  
```S 
public static ArrayList<String> getArrayListString(String key) {

    SharedPreferences settings = getPreferences();
    List<String> strings;

    if (settings.contains(key)) {
        String jsonSt = settings.getString(key, null);
        Gson gson = new Gson();
        String[] st = gson.fromJson(jsonSt,
                String[].class);

        strings = Arrays.asList(st);
        strings = new ArrayList<String>(strings);
        
        } else
            return null;

        return (ArrayList<String>) strings;
    }
```
To, access the reference 

To save data : `INDIPreferences.saveArrayListStrings(customs, "UNIQUE_STRING_KEY_TO_RETRIVE_STRING_ARRAY_DATA");` </br>
To get data : `INDIPreferences.getArrayListString("UNIQUE_STRING_KEY_TO_RETRIVE_STRING_ARRAY_DATA");`

For, storing your custom model ArrayList:

```S 
public static void saveCustomArrayList(ArrayList<Custom> customs, String key) {
    SharedPreferences.Editor editor = getPreferences().edit();
    Gson gson = new Gson();
    String jsonStrings = gson.toJson(customs);
    editor.putString(key, jsonStrings);
    editor.commit();
 }
```

To, get custom model ArrayList:

```S 
public static ArrayList<Custom> getCustomArrayList(String key) {

   SharedPreferences settings = getPreferences();
   List<Custom> strings;

    if (settings.contains(key)) {
            String jsonSt = settings.getString(key, null);
            Gson gson = new Gson();
            Custom[] st = gson.fromJson(jsonSt,
                    Custom[].class);

            strings = Arrays.asList(st);
            strings = new ArrayList<Custom>(strings);
        } else
            return null;

        return (ArrayList<Custom>) strings;
 }
```

To, access the reference 

To save data : `INDIPreferences.saveCustomArrayList(customs, "UNIQUE_STRING_KEY_TO_RETRIVE_DATA");` </br>
To get data : `INDIPreferences.getCustomArrayList("UNIQUE_STRING_KEY_TO_RETRIVE_DATA");`

### License

Gson is released under the [Apache 2.0 license](LICENSE).

```
Copyright 2008 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

### Disclaimer

This is developed by Mritunjay (httP://indilabz.in).
