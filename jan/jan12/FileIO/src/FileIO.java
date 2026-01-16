import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) {
        String inputPath = "src/io/file.in";
        String outputPath = "src/io/file.out";

        // InputStream is used for gathering a stream of bytes as input
        // OutputStream is used for writing bytes as output.
        // Uses default system path.
        try {
            InputStream inStream = new FileInputStream(inputPath);
            OutputStream outStream = new FileOutputStream(outputPath);

            int byteData;

            while ((byteData = inStream.read()) != -1) {
                outStream.write(byteData);
            } 

            // Alternatively, use InputStream.readAllBytes()

            // Close to let go of resources.
            inStream.close();
            outStream.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        // ClassLoader is used for project resource handling by searching the project tree for
        // resources instead of the entire system - must use relative path.
        try {
            String inPath = "io/file.in";
            InputStream inStream = FileIO.class.getClassLoader().getResourceAsStream(inPath);
            
            if (inStream != null) {
                int byteData = inStream.read();
    
                while (byteData != -1) {
                    System.out.print((char) byteData);
                    byteData = inStream.read();
                }

                System.out.println();

                inStream.close();
            } else {
                System.out.println("Nothing found.");
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        // Try with resources is the analog to the the Python
        // with open() - automatically frees up resources after scope ends
        // Resource needs to implement the AutoClosable interface
        
        try (InputStream inStream = new FileInputStream(outputPath)) {
            if (inStream != null) {
                for (byte data : inStream.readAllBytes()) {
                    System.out.print((char) data);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
