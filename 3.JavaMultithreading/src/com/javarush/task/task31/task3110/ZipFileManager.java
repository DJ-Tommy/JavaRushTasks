package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
        InputStream inputStream = Files.newInputStream(source)){
            String s = source.getFileName().toString();
            ZipEntry zipEntry = new ZipEntry(s);
            zipOutputStream.putNextEntry(zipEntry);
            while (true) {
                if (inputStream.available() <= 0) {
                    break;
                }
                zipOutputStream.write(inputStream.read());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "  " + e.getCause());
        }
    }
}
