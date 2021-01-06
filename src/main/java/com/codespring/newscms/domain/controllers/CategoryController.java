package com.codespring.newscms.domain.controllers;

import com.codespring.newscms.domain.models.Category;
import com.codespring.newscms.domain.service.CategoryService;
import com.codespring.newscms.domain.vo.CategoryRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/category")
@Api(tags = "Category", description = "Category API")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService service) {
        this.categoryService = service;
    }

    @GetMapping(value="/{id}")
    @ApiOperation(value = "Find category", notes = "Find the Category by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    public ResponseEntity<Mono<Category>> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(categoryService.findOne(id));
    }

    @GetMapping
    @ApiOperation(value = "Retrieve categories", notes = "Retrieve all categories")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Categories found"),
            @ApiResponse(code = 404, message = "Cateogries not found")
    })
    public ResponseEntity<Flux<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping
    @ApiOperation(value = "Create category", notes = "Creates a new category")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Category create successfully"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Mono<Category>> newCategory(@RequestBody CategoryRequest category){
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove category", notes = "Removes a category")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Category removed successfully"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    public void removeCategory(@PathVariable("id") String id){
        categoryService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update category", notes = "Updates the corresponding category")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Category updated successfully"),
            @ApiResponse(code = 404, message = "Category not found"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Mono<Category>> updateCategory(@PathVariable("id") String id, CategoryRequest category){
        return new ResponseEntity<>(categoryService.update(id, category), HttpStatus.OK);
    }

//    @GetMapping("/
//    public ResponseEntity<List<Category>> findByNameStartingWith(@RequestParam("name") String name) {
//        return ResponseEntity.ok(categoryService.findByNameStartingWith(name));
//    }

}
