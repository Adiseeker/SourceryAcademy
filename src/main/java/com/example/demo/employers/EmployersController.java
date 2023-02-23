package com.example.demo.employers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping(path="api/v1/employers")
public class EmployersController{

private final EmployersService employersService;

public EmployersController(EmployersService employersService) {
    this.employersService = employersService;
}

@GetMapping
public List<Employers> getEmployers()
{
    return employersService.getEmployers();
}

@PostMapping
public void registerNewEmployers(@RequestBody Employers employers)
{
    employersService.addNewEmployers(employers);
}

@DeleteMapping(path ="{employerId}")
public void deleteEmployer(@PathVariable Integer employerId)
{
    employersService.deleteEmployer(employerId);
}

@PostMapping()
    public String ingestDataFile(@RequestParam("file") MultipartFile file,
RedirectAttributes redirectAttributes) {
     if (file.isEmpty()) {
                redirectAttributes.addFlashAttribute("message", "No File is Present");
                return "redirect:uploadStatus";
            }
             try {

                
                byte[] bytes = file.getBytes();
                Path path = Paths.get("FOLDER TO UPLOAD TO" + file.getOriginalFilename());
                Files.write(path, bytes);

                redirectAttributes.addFlashAttribute("message",
                        "File upload successful'" + file.getOriginalFilename() + "'");

            } catch (IOException e) {
                e.printStackTrace();
            }

            return "redirect:/uploadStatus";
    }
    @GetMapping("/uploadStatus")
        public String uploadStatus() {
            return "uploadStatus";
        }

}




