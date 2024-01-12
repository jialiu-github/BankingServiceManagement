@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class {ControlerName}Test {

    @Autowired
    private MockMvc mockMvc;

    // mock beans
    @MockBean
    private BlogService blogService;

    // test method
}