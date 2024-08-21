package nz.co.bnz.lapworkshop.common;

import nz.co.bnz.lapworkshop.exception.UpstreamApiException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

public class BnzRestClient {

    private final RestClient restClient;

    public BnzRestClient(String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public <T> T get(String uri, ParameterizedTypeReference<T> p) throws UpstreamApiException {
        try {
            return this.restClient.get()
                    .uri(uri)
                    .retrieve()
                    .body(p);
        } catch (Exception e) {
            throw new UpstreamApiException();
        }
    }

}
