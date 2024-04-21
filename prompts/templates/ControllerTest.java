@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
class /* Here some be {ControllerName} */ ControllerTest {

    private lateinit var mockMvc: MockMvc

    // other some mock beans

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(/* {ControllerName} */Controller(/* some mock beans */)).build()
    }

    // the test methods
}
