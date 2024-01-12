@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
class {ControllerName}Test {

    private lateinit var mockMvc: MockMvc

    // other some mock beans

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders.standaloneSetup({ControllerName}(/* some mock beans */)).build()
    }

    // the test code
}