package net.Commons;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class FileUtils {

    public static File waitForNewFileInDirectory(String directoryPath, int timeout, int pollInterval) throws InterruptedException {
        Path dir = Paths.get(directoryPath);
        long endTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(timeout);

        while (System.currentTimeMillis() < endTime) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path entry : stream) {
                    if (Files.isRegularFile(entry)) {
                        return entry.toFile();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(pollInterval);
        }

        return null; // No new file found within the timeout period
    }
    
    public static void main(String[] args) {
        try {
            File newFile = waitForNewFileInDirectory("/path/to/directory", 30, 1000);
            if (newFile != null) {
                System.out.println("New file found: " + newFile.getName());
            } else {
                System.out.println("No new file found within the timeout period.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

