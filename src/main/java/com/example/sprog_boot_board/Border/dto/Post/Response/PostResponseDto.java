@Getter
@Setter
private class PostResponseDto {
    private Long id; // 게시글 고유 ID
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private String author; // 작성자 이름
    private int viewCount; // 조회수
    private LocalDateTime createdAt; // 작성일
    private List<CommentResponseDto> comments; // 댓글 목록
}