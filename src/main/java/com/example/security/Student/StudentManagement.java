package com.example.security.Student;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagement {



    private static final List<Student> students= Arrays.asList(
            new Student(1,"ruaa diab "),
            new Student(2,"maria meme"),
            new Student(3,"fahmi fhfh")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','ADMINTRAINEE')")
    public List<Student > getStudents(){
        return students;
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student std){
        System.out.println(std);

    }
    @DeleteMapping(path ={"{id}"})
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void deleteStudent(@PathVariable("id") Integer id){
        System.out.println(id);
    }
    @PutMapping(path="{id}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void updateStudent(@PathVariable("id") Integer id,@RequestBody Student std){
        System.out.println("updated");
    }
}
