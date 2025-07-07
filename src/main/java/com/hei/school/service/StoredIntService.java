package com.hei.school.service;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class StoredIntService {

  private static final String FILE_NAME = "/tmp/stored-int.txt";

  public int getOrCreateStoredInt() throws Exception {
    File file = new File(FILE_NAME);

    if (file.exists()) {
      String content = Files.readString(file.toPath()).trim();
      return Integer.parseInt(content);
    } else {
      int value = new Random().nextInt(100) + 1;
      try (FileWriter writer = new FileWriter(file)) {
        writer.write(String.valueOf(value));
      }
      return value;
    }
  }
}
