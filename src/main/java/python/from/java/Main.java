package python.from.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class Main {

    private static File pyFile = new File("Main.py");

    {
        if(!pyFile.exists()) pyFile.delete();
        try { IOUtils.copy(Main.class.getResourceAsStream("Main.py"), new FileOutputStream(pyFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run() {
        ProcessBuilder pb = new ProcessBuilder("python", "Main.py");
        pb.inheritIO();
        pb.redirectErrorStream(true);
        try {
            Process process = pb.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
          e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("JAVA : START");
        new Main().run();
        System.out.println("JAVA : END");

//
//
//
//        pb.directory(new File(dir));
//        try {
//            logger.trace("Start process");
//            lock.lock();
//            process = pb.start();
//            cond.await();
//            lock.unlock();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
