package com.springframeworkguru.webapp.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "blog_post_tags")
public class BlogPostTag {
    
    @EmbeddedId
    BlogPostTagId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    private BlogPost post;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tagId")
    private BlogTag tag;
 
    @Column(name = "created_on")
    private Date createdOn = new Date();

    @SuppressWarnings("unused")
    private BlogPostTag() {}

    public BlogPostTag(BlogPost post, BlogTag tag) {
        this.post = post;
        this.tag = tag;
        this.id = new BlogPostTagId(post.getId(), tag.getId()); 
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        BlogPostTag that = (BlogPostTag) o;
        return Objects.equals(post, that.post) &&
               Objects.equals(tag, that.tag);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(post, tag);
    }    
}
