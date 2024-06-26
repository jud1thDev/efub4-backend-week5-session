package efub.session.blog.post.service;

import efub.session.blog.account.domain.Account;
import efub.session.blog.account.service.AccountService;
import efub.session.blog.exception.CustomDeleteException;
import efub.session.blog.post.domain.Post;
import efub.session.blog.post.dto.post.PostRequestDto;
import efub.session.blog.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static efub.session.blog.exception.ErrorCode.PERMISSION_REJECTED_USER;
import static java.lang.Boolean.*;


public class PostService {
    private final PostRepository postRepository;
    private final AccountService accountService;

//    public Post createNewPost(){
//    }

    @Transactional(readOnly = true)
    public List<Post> findAllPosts(){
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    @Transactional(readOnly = true)
    public long countAllPosts(){
        return postRepository.count();
    }

    @Transactional(readOnly = true)
    public Post findPostById(Long postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new EntityNotFoundException("해당 id를 가진 Post를 찾을 수 없습니다.id="+postId));
        return post;
    }

//    public Long updatePost() {
//    }

//    public void deletePost(){
//    }
}