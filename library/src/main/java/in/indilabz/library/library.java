package in.indilabz.library;

public class library implements Data{

    public static void main(String[] args) {

        String PACKAGE = "YOUR_PACKAGE_NAME_HERER"; //present in manifest or build.gradle file
        String APP_NAME = " \"YOUR_APP_NAME_HERE\" ";

        OperationHelper.execute(PACKAGE, APP_NAME);

    }

}
