package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    ImageRepository imageRepository;

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
        Blog blog = optionalBlog.get();

        Image image = new Image();
        image.setDescription(description);
        image.setDimension(dimensions);

        blog.getImageList().add(image);
        blogRepository.save(blog);
    }

    public void deleteImage(Integer id){
        imageRepository.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        int count = 0;
        List<Image> imageList = imageRepository.findAll();

        for(Image image: imageList)
        {
            if(Objects.equals(image.getDimension(), screenDimensions)){
                count++;
            }
        }

        return count;
    }
}
