package com.hei.school.endpoint.rest.controller;

import com.hei.school.service.StoredIntService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class StoredIntController {

  private final StoredIntService service;

  @GetMapping("/stored-int")
  public int storedInt() throws Exception {
    return service.getOrCreateStoredInt();
  }
}
