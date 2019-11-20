package y.o;

import org.springframework.cloud.servicebroker.model.binding.*;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ExampleServiceBindingService implements ServiceInstanceBindingService {

    private static final String URI_KEY = "uri";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    @Override
    public Mono<CreateServiceInstanceBindingResponse> createServiceInstanceBinding(CreateServiceInstanceBindingRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        String bindingId = request.getBindingId();
        //
        // create credentials and store for later retrieval
        //
        String url = new String(/* build a URL to access the service instance */);
        String bindingUsername = new String(/* create a user */);
        String bindingPassword = new String(/* create a password */);

        CreateServiceInstanceBindingResponse response = CreateServiceInstanceAppBindingResponse.builder()
                .credentials("url", url)
                .credentials("username", bindingUsername)
                .credentials("password", bindingPassword)
                .bindingExisted(false)
                .async(true)
                .build();
        return Mono.just(response);
    }

    @Override
    public Mono<DeleteServiceInstanceBindingResponse> deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        String bindingId = request.getBindingId();
        //
        // delete any binding-specific credentials
        //
        return Mono.just(DeleteServiceInstanceBindingResponse.builder()
                .async(true)
                .build());
    }

    @Override
    public Mono<GetServiceInstanceBindingResponse> getServiceInstanceBinding(GetServiceInstanceBindingRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        String bindingId = request.getBindingId();
        //
        // retrieve the details of the specified service binding
        //
        String url = new String(/* retrieved URL */);
        String bindingUsername = new String(/* retrieved user */);
        String bindingPassword = new String(/* retrieved password */);

        GetServiceInstanceBindingResponse response = GetServiceInstanceAppBindingResponse.builder()
                .credentials("username", bindingUsername)
                .credentials("password", bindingPassword)
                .credentials("url", url)
                .build();
        return Mono.just(response);
    }

}
