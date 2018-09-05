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
                            "    \n" +
                            "    private static SharedPreferences getPreferences() {\n" +
                            "        return INDIMaster.applicationContext.getSharedPreferences(APP_NAME, Activity.MODE_PRIVATE);\n" +
                            "    }\n" +
                            "}";

    String MASTERCLASS_FILE = "INDIMaster.java";

    String CONSTANTS_FILE = "Constants.java";

    String PREFERENCES_FILE = "INDIPreferences.java";
}
