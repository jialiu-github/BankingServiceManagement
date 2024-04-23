/* package  */
import /* some import  */
@SpringBootTest
class /* Here some be {ServiceName} */ ServiceTest {

    @Autowired
    MyService myService; // The service to be tested

    @Autowired
    MyRepository myRepository; // The real repository to be injected

    //should NOT mock anything!!

    //test method
    //the name of test method should use snake case
}
