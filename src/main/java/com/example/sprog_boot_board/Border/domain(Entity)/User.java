@Entity
public class entity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String username; // 로그인 ID
    private String password; // 비밀번호
    private String email;    // 이메일
    private String role;     // 사용자 권한

    @OneToMany(mappedBy = "user")
    private List<post> posts = new ArrayList<>();
}
