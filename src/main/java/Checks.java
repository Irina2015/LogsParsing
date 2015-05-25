import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by asus on 24.05.2015.
 */
public class Checks {


    public static void checkFile(Path path) {

        // Verify a path is valid
        // Path must be absolute and must exist.

        if (!path.isAbsolute()) {
            System.out.format("%s must be an absolute path to a file.", path);
            System.exit(0);
        } else if (!Files.exists(path)) {
            System.out.format("%s does not exist.", path);
            System.exit(0);
        }

        // Verify that the path references a file
        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            if (!attr.isRegularFile()) {
                System.out.format("%s is not a file.", path);
                System.exit(0);
            }
        } catch (IOException e) {
            System.err.println("I/O error: " + e);
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void checkExtension(Path path, String extension) {
        String ext = FilenameUtils.getExtension(String.valueOf(path));
        if (!ext.equals(extension)) {
            System.out.format("%s is not a valid extension. File should have " + extension + " extension", ext);
            System.exit(0);
        }
    }

}
