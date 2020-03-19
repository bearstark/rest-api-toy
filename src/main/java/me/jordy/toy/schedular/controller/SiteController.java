package me.jordy.toy.schedular.controller;

import me.jordy.toy.schedular.repository.BlogRepository;
import me.jordy.toy.schedular.resource.ErrorsResource;
import me.jordy.toy.schedular.vo.entity.Site;
import me.jordy.toy.schedular.vo.dto.SiteDto;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value="/api/site", produces= MediaTypes.HAL_JSON_VALUE)
public class SiteController {

    ModelMapper modelMapper;
    BlogRepository blogRepository;

    public SiteController(BlogRepository blogRepository, ModelMapper modelMapper) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
    }
    @GetMapping
    public void blogGet() {

        return;
    }

    @PostMapping
    public ResponseEntity blogPost(@RequestBody @Valid SiteDto siteDTO, Errors errors) {
        System.out.println("errors: " + errors);
        if (errors.hasErrors()) {
//            return ResponseEntity.badRequest().build();
            return badRequest(errors);
        }

        Site site = modelMapper.map(siteDTO, Site.class);
        Site newSite = blogRepository.save(site);

        URI cretatedUri =  linkTo(SiteController.class).slash(newSite.getSeq()).toUri();;
        return ResponseEntity.created(cretatedUri).body(newSite);
    }

    // Ctrl + Alt + m -> refactor
    private ResponseEntity<ErrorsResource> badRequest(Errors errors) {
        return ResponseEntity.badRequest().body(new ErrorsResource(errors));
    }
}
