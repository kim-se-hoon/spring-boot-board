@Entity
@Getter
@Setter
@NoArgsConstructor
public class fileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalName;
    private String sevedName;
    private String filePath;

    @ManyToOne
    private Potst post;
}
