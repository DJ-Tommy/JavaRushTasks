package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) {
        if (!Files.exists(zipFile.getParent())) {
            try {
                Files.createDirectory(zipFile.getParent());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            if (Files.isRegularFile(source)) {
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path newPath : fileNames) {
                    addNewZipEntry(zipOutputStream, Paths.get(source.toString(), newPath.getParent().toString()), newPath.getFileName());
                }
            } else {
                throw new PathIsNotFoundException();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "  " + e.getCause());
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath.toString(), fileName.toString()))) {
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);
            copyData(inputStream, zipOutputStream);
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        while (true) {
            if (in.available() <= 0) {
                break;
            }
            out.write(in.read());
        }
    }
}
