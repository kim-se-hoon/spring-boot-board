@Entity
@Getter
@Setter
@NoArgsConstructor
public class commetnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 댓글 고유 ID

    @ManyToOne
    private Post post; // 댓글이 속한 게시글
    @ManyToOne
    private User user; // 댓글 작성자
    @ManyToOne
    private Comment parent; // 부모 댓글 (대댓글인 경우)

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Comment> replies = new ArrayList<>(); // 대댓글 목록

    private String content; // 댓글 내용
    private LocalDateTime createdAt; // 작성일
}
