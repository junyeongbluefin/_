package y.o;

import org.springframework.cloud.servicebroker.model.instance.*;
import java.util.Map;

import org.springframework.cloud.servicebroker.service.ServiceInstanceService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ExampleServiceInstanceService implements ServiceInstanceService {

    @Override
    public Mono<CreateServiceInstanceResponse> createServiceInstance(CreateServiceInstanceRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        String planId = request.getPlanId();
        Map<String, Object> parameters = request.getParameters();
        String dashboardUrl = "https://dashboard.jun.com"; /* construct a dashboard URL */

        System.out.println("New requested saved properly");

        return Mono.just(CreateServiceInstanceResponse.builder()
                .instanceExisted(true)
                .dashboardUrl(dashboardUrl)
                .async(true)
                .build());
    }

    @Override
    public Mono<GetServiceInstanceResponse> getServiceInstance(GetServiceInstanceRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        String dashboardUrl = ""; /* retrieve dashboard URL */
        return Mono.just(GetServiceInstanceResponse.builder()
                .dashboardUrl(dashboardUrl)
                .build());
    }

    @Override
    public Mono<GetLastServiceOperationResponse> getLastOperation(GetLastServiceOperationRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        return Mono.just(GetLastServiceOperationResponse.builder()
                .operationState(OperationState.SUCCEEDED)
                .build());
    }

    @Override
    public Mono<UpdateServiceInstanceResponse> updateServiceInstance(UpdateServiceInstanceRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        String planId = request.getPlanId();
        String previousPlan = request.getPreviousValues().getPlanId();
        Map<String, Object> parameters = request.getParameters();
        return Mono.just(UpdateServiceInstanceResponse.builder()
                .async(true)
                .build());
    }

    @Override
    public Mono<DeleteServiceInstanceResponse> deleteServiceInstance(DeleteServiceInstanceRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        String planId = request.getPlanId();
        return Mono.just(DeleteServiceInstanceResponse.builder()
                .async(true)
                .build());
    }
}
