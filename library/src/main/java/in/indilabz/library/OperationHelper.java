package in.indilabz.library;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OperationHelper implements Data{

    private static List<File> files = new ArrayList<>();

    public static String getPackageName(String pack){

        return "package "+pack;
    }

    public static File getFilePathFroClass(String PACKAGE){

        return new File(getAbsolutePath()+PACKAGE.replace(".","/")+"/"+MASTERCLASS_FILE);
    }

    public static File getPreferenceFilePath( String PACKAGE){

        return new File(getAbsolutePath()+PACKAGE.replace(".","/")+"/helper/"+PREFERENCES_FILE);
    }

    public static File getConstantsFilePath(String PACKAGE){

        return new File(getAbsolutePath()+PACKAGE.replace(".","/")+"/utils/"+CONSTANTS_FILE);
    }

    public static String getAbsolutePath(){

        Path currentRelativePath = Paths.get("");
        return currentRelativePath.toAbsolutePath().toString()+"/app/src/main/java/";
    }

    public static void createPreferences(String PACKAGE, File file){

        String complete = getPackageName(PACKAGE)+".helper;\n\n"+ Data.PREFERENCES;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(complete.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createConstants(String PACKAGE, String APP_NAME, File file){

        String complete = getPackageName(PACKAGE)+".utils;\n\n"+ Data.CONSTANTS+APP_NAME+";"+"\n"+"}";
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(complete.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeMasterData(String PACKAGE, File file){

        String complete = getPackageName(PACKAGE)+";\n\n"+ Data.APP_MASTER;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(complete.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final File appFolder(String path, String PACKAGE){

        return new File(path+PACKAGE.replace(".","/")+"/app/");
    }

    public static final File helperFolder(String path, String PACKAGE){

        return new File(path+PACKAGE.replace(".","/")+"/helper/");
    }

    public static final File utilsFolder(String path, String PACKAGE){

        return new File(path+PACKAGE.replace(".","/")+"/utils/");
    }

    public static void execute(String PACKAGE, String APP_NAME){

        files.add(appFolder(getAbsolutePath(), PACKAGE));
        files.add(helperFolder(getAbsolutePath(), PACKAGE));
        files.add(utilsFolder(getAbsolutePath(), PACKAGE));

        try{

            for(File f: files){

                if(f.mkdir()){

                    System.out.println(true);
                }
                else {
                    System.out.println(false);
                }
            }
        }
        catch (Exception e){

            System.out.println(""+e.toString());
        }

        writeMasterData(PACKAGE, getFilePathFroClass(PACKAGE));
        createConstants(PACKAGE, APP_NAME, getConstantsFilePath(PACKAGE));
        createPreferences(PACKAGE, getPreferenceFilePath(PACKAGE));
    }
}
