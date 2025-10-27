@Getter
@Setter
public class PostRequestDto {
    private String title; // 제목
    private String content; // 내용
    private List<MultipartFile> files; // 첨부파일
}
