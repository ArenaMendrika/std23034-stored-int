package com.hei.school.endpoint.rest.controller;

import com.hei.school.service.StoredIntService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StoredIntController {

  private final StoredIntService storedIntService;

  @GetMapping("/stored-int")
  public int getStoredInt() {
    return storedIntService.getOrCreateStoredInt();
  }
}
