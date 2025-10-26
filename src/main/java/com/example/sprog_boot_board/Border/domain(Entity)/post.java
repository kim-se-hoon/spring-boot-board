@Entity
public class post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id; // 게시글 고유 ID
    private String title;  // 게시글 제목
    private String content; // 게시글 내용

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    private int viewCount; // 조회수
    private LocalDateTime createdAt; // 작성일
    private LocalDateTime updatedAt; // 수정일

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<FileEntity> likes = new ArrayList<>();
}
    
