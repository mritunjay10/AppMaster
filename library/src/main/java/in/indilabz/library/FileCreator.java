package in.indilabz.library;


public class FileCreator implements Data{

    public static void main(String[] args) {

        String PACKAGE = "in.indilabz.apphelper"; //present in manifest or build.gradle file
        String APP_NAME = " \"AppHelper\" ";

        OperationHelper.execute(PACKAGE, APP_NAME);

        System.out.print(Data.PREFERENCES);

    }


}

