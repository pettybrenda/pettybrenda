//package com.access.control.controller;
//
//import com.access.control.models.Institution;
//import com.access.control.repository.InstitutionRepository;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class InstitutionController {
//  final   private In institutionRepository;
//    public InstitutionController(InstitutionRepository institutionRepository){
//        this.institutionRepository=institutionRepository;
//    }
//    @GetMapping("/institution")
//    public List<Institution> index(){
//        return institutionRepository.findAll();
//    }
//    @GetMapping("/institution/search")
//    public List<Institution>search (@RequestBody Map<String,String> body){
//        String searchTerm =body.get("text");
//                return institutionRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
//    }}
////    @PostMapping("/institution")
////    public Institution create(@RequestBody Map<List, List> body){
////        List sites = body.get("sites");
////        List users = body.get("users");
////        return institutionRepository.save(new Institution(sites,users));}
////    }    @PutMapping("/institution/{id}")
////    public Institution update(@PathVariable String id, @RequestBody Map<String, String> body){
////        int blogId = Integer.parseInt(id);
////        // getting institution
////        Institution blog = institutionRepository.findById(institutionId).orElse(new Institution());
////        i.setSites(body.get("sites"));
////        blog.setUsers(body.get("users"));
////        return institutionRepository.save(blog);
////    }    @DeleteMapping("institution/{id}")
////    public boolean delete(@PathVariable Long id){
////        Long instituionId = Integer.parseInt(id);
////        institutionRepository.deleteById(instituionId);
////        return true;
////    }}