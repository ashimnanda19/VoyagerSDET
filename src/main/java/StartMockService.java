import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.testng.annotations.*;
import io.*;

import java.net.URISyntaxException;


public class StartMockService {
    private static final String HOST= "localhost";
    private static final int PORT = 8080;
    private static WireMockServer server = new WireMockServer(PORT);

    @BeforeClass
    public void initializeServer(){
    server.start();
    WireMock.configureFor(HOST,PORT);
        ResponseDefinitionBuilder  mockGetAppResponse = new ResponseDefinitionBuilder();
        mockGetAppResponse.withStatus(200);
        mockGetAppResponse.withStatusMessage("Ok");
        mockGetAppResponse.withHeader("Content-Type","text/json");
        mockGetAppResponse.withBody("{\n" +
                "  \"id\": 1,\n" +
                "  \"slug\": \"octoapp\",\n" +
                "  \"node_id\": \"MDExOkludGVncmF0aW9uMQ==\",\n" +
                "  \"owner\": {\n" +
                "    \"login\": \"github\",\n" +
                "    \"id\": 1,\n" +
                "    \"node_id\": \"MDEyOk9yZ2FuaXphdGlvbjE=\",\n" +
                "    \"url\": \"https://api.github.com/orgs/github\",\n" +
                "    \"repos_url\": \"https://api.github.com/orgs/github/repos\",\n" +
                "    \"events_url\": \"https://api.github.com/orgs/github/events\",\n" +
                "    \"avatar_url\": \"https://github.com/images/error/octocat_happy.gif\",\n" +
                "    \"gravatar_id\": \"\",\n" +
                "    \"html_url\": \"https://github.com/octocat\",\n" +
                "    \"followers_url\": \"https://api.github.com/users/octocat/followers\",\n" +
                "    \"following_url\": \"https://api.github.com/users/octocat/following{/other_user}\",\n" +
                "    \"gists_url\": \"https://api.github.com/users/octocat/gists{/gist_id}\",\n" +
                "    \"starred_url\": \"https://api.github.com/users/octocat/starred{/owner}{/repo}\",\n" +
                "    \"subscriptions_url\": \"https://api.github.com/users/octocat/subscriptions\",\n" +
                "    \"organizations_url\": \"https://api.github.com/users/octocat/orgs\",\n" +
                "    \"received_events_url\": \"https://api.github.com/users/octocat/received_events\",\n" +
                "    \"type\": \"User\",\n" +
                "    \"site_admin\": true\n" +
                "  },\n" +
                "  \"name\": \"Octocat App\",\n" +
                "  \"description\": \"\",\n" +
                "  \"external_url\": \"https://example.com\",\n" +
                "  \"html_url\": \"https://github.com/apps/octoapp\",\n" +
                "  \"created_at\": \"2017-07-08T16:18:44-04:00\",\n" +
                "  \"updated_at\": \"2017-07-08T16:18:44-04:00\",\n" +
                "  \"permissions\": {\n" +
                "    \"metadata\": \"read\",\n" +
                "    \"contents\": \"read\",\n" +
                "    \"issues\": \"write\",\n" +
                "    \"single_file\": \"write\"\n" +
                "  },\n" +
                "  \"events\": [\n" +
                "    \"push\",\n" +
                "    \"pull_request\"\n" +
                "  ]\n" +
                "}");


        WireMock.stubFor(WireMock.get("/app").willReturn(mockGetAppResponse));

    }


    @Test
    public void testEndPoint() throws URISyntaxException{
      


    }


}
