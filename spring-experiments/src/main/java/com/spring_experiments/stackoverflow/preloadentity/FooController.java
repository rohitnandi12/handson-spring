package com.spring_experiments.stackoverflow.preloadentity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foo/{fooId}/bar")
public class FooController {

    @PostMapping("/")
    public ResponseEntity<Void> createFooBar(@PreloadedFoo FooEntity prefetchedFoo,
                                             @RequestBody(required = false) SomeRequest request
    ) {
        System.out.println(prefetchedFoo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{barId}")
    public ResponseEntity<Void> getFooBar(
            @PreloadedFoo FooEntity prefetchedFoo,
            @PathVariable Long barId,
            @RequestParam String requestParam
    ) {
        System.out.println("barId " + barId);
        System.out.println(requestParam);
        System.out.println(prefetchedFoo);
        return ResponseEntity.ok().build();
    }
}