package my.provider.filter;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

/**
 * Created by JingCai-Java on 2018/7/30.
 */
public class MyFilter extends ClientFilter {

    @Override
    public ClientResponse handle(ClientRequest clientRequest) throws ClientHandlerException {
        ClientResponse clientResponse = this.getNext().handle(clientRequest);
        return clientResponse;
    }
}
