package app;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * https://www.baeldung.com/spring-classpath-file-access
 */
@Controller
@RequestMapping("/files")
@Log4j2
public class FileDownloadController {

  /**
   * http://localhost:8080/files/file_x.txt
   */
  @GetMapping("{filename:.+}")
  public ResponseEntity<Resource> get(@PathVariable String filename) {
    log.info(filename);

    Resource file = new ClassPathResource(filename);
    if (!file.exists()) return ResponseEntity.notFound().build();

    return ResponseEntity.ok()
        .header(
            HttpHeaders.CONTENT_DISPOSITION,
            String.format( "attachment; filename=\"%s\"", UUID.randomUUID()))
        .body(file);
  }

  @ResponseBody
  @GetMapping(value = "/v2/{filename:.+}")
  public byte[] get2(@PathVariable String filename) throws IOException {
    InputStream is = getClass().getResourceAsStream(filename);
    byte[] bytes = IOUtils.toByteArray(is);
    return bytes;
  }

}
