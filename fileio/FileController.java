package springboot.fileio;

import com.ecommerce.project.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/write-file")
    public void writeFile(@RequestBody String content) throws IOException, URISyntaxException {
        fileService.writeToFile("/src/main/resources/data.txt", content);
    }
    @GetMapping("/read-file")
    public String readFile() throws IOException {
        return fileService.readFileContent("classpath:/data.txt");
    }
}
