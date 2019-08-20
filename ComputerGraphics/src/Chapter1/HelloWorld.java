package Chapter1;

import javax.media.opengl.*;
public class HelloWorld {

    public static void main(String args[]) {
        try {
            //check for native library
            System.loadLibrary("jogl");
            System.out.println("Hello World! (The native libraries are installed.)");
            //check for jogl jar
            GLCapabilities caps = new GLCapabilities();
            System.out.println("Hello JOGL! (The jar appears to be available.)");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
