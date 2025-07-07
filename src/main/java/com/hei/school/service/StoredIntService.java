package com.hei.school.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class StoredIntService {

  private static final Path FILE_PATH = Path.of("/tmp/stored-int.txt");

  public int getOrCreateStoredInt() {
    try {
      if (Files.exists(FILE_PATH)) {
        String content = Files.readString(FILE_PATH).trim();
        return Integer.parseInt(content);
      } else {
        int randomInt = new Random().nextInt(1000);
        Files.writeString(FILE_PATH, String.valueOf(randomInt));
        return randomInt;
      }
    } catch (IOException | NumberFormatException e) {
      throw new RuntimeException("Erreur lors de la lecture/écriture du fichier stored-int.txt", e);
    }
  }
}
