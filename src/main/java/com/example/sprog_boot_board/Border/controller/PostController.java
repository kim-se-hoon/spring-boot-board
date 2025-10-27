@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public Page<PostListDto> getPosts(
            @RequestParam(defaultBalue = "1") int page,
            @RequestParam(required = false) String keyword) {
        return postService.getPostList(page, keyword);
    }

    @GetMapping("/{id}")
    public PostDetailDto getPost(
            @PathVariable Long id) {
        return postService.getPostDetail(id);
    }

    @postMapping
    public Long createPost(
            @ModelAttribute PostRequestDto dto,
            @AuthenticationPrincipal UserDetails user) {
        return postService.createPost(dto, user.getUsername());
    }

    @PutMapping("/{id}")
    public void updatePost(
            @PathVariable Long id,
            @RequestBody PostRequestDto dto) {
        postService.updatePost(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
