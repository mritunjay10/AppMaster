package in.indilabz.library;

public interface Data {

    String APP_MASTER =
            "import android.app.Application;\n" +
            "import android.content.Context;\n" +
            "import android.support.v7.app.AppCompatDelegate;\n"+
            "\npublic class INDIMaster extends Application implements Constants{\n" +
                    "\n" +
                    "    public static Context applicationContext = null;\n" +
                    "    private static INDIMaster indiMaster;\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void onCreate() {\n" +
                    "        super.onCreate();\n" +
                    "        indiMaster = this;\n" +
                    "\n" +
                    "        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);\n" +
                    "        applicationContext = getApplicationContext();\n" +
                    "\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "    public static synchronized INDIMaster getInstance() {\n" +
                    "        return indiMaster;\n" +
                    "    }\n" +
                    "\n" +
                    "}\n";

    String CONSTANTS =
            "public interface Constants {\n" +
                    "\n" +
                    "    String APP_NAME = ";

    String PREFERENCES =
                    "import android.app.Activity;\n" +
                    "import android.content.SharedPreferences;\n" +
                    "\n" +
                    "import java.util.Date;\n" +
                    "\n" +
                    "\n"+
                    "public class INDIPreferences implements Constants{\n" +
                            "private static SharedPreferences getPreferences() {\n" +
                            "        return INDIMaster.applicationContext.getSharedPreferences(APP_NAME, Activity.MODE_PRIVATE);\n" +
                            "    }\n" +
                            "\n" +
                            "    //// Add following lines to store and retrive boolean\n" +
                            "\n" +
                            "    public static void saveBoolean(boolean b, String key) {\n" +
                            "        SharedPreferences.Editor editor = getPreferences().edit();\n" +
                            "        editor.putBoolean(key, b);   /// Always change key while creating other funtion to store boolean\n" +
                            "        editor.commit();\n" +
                            "    }\n" +
                            "\n" +
                            "    public static boolean getBoolean(String key) {\n" +
                            "        SharedPreferences mSharedPreferences = getPreferences();\n" +
                            "        return mSharedPreferences.getBoolean(key, false);\n" +
                            "    }\n" +
                            "\n" +
                            "    //// Add following lines to store and retrive String\n" +
                            "\n" +
                            "    public static void saveString(String value, String key) {\n" +
                            "        SharedPreferences.Editor editor = getPreferences().edit();\n" +
                            "        editor.putString(key, value);  /// Always change key while creating other funtion to store string\n" +
                            "        editor.commit();\n" +
                            "    }\n" +
                            "\n" +
                            "    public static String getString(String key) {\n" +
                            "        SharedPreferences mSharedPreferences = getPreferences();\n" +
                            "        return mSharedPreferences.getString(key, \"\");\n" +
                            "    }\n" +
                            "\n" +
                            "    //// Add following lines to store and retrive int\n" +
                            "\n" +
                            "    public static void saveInt(int value, String key) {\n" +
                            "        SharedPreferences.Editor editor = getPreferences().edit();\n" +
                            "        editor.putInt(key, value);  /// Always change key while creating other funtion to store int\n" +
                            "        editor.commit();\n" +
                            "    }\n" +
                            "\n" +
                            "    public static int getInt(String key) {\n" +
                            "        SharedPreferences mSharedPreferences = getPreferences();\n" +
                            "        return mSharedPreferences.getInt(key, 0);\n" +
                            "    }\n" +
                            "\n" +
                            "    //// Add following lines to store and retrive int\n" +
                            "\n" +
                            "    public static void saveFloat(Float value, String key) {\n" +
                            "        SharedPreferences.Editor editor = getPreferences().edit();\n" +
                            "        editor.putFloat(key, value);  /// Always change key while creating other funtion to store int\n" +
                            "        editor.commit();\n" +
                            "    }\n" +
                            "\n" +
                            "    public static Float getFloat(String key) {\n" +
                            "        SharedPreferences mSharedPreferences = getPreferences();\n" +
                            "        return mSharedPreferences.getFloat(key, 0);\n" +
                            "    }\n" +
                            "}";

    String MASTERCLASS_FILE = "INDIMaster.java";

    String CONSTANTS_FILE = "Constants.java";

    String PREFERENCES_FILE = "INDIPreferences.java";
}
