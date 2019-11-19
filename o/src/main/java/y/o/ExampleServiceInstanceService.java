package y.o;

import org.springframework.cloud.servicebroker.model.instance.*;
import java.util.Map;

import org.springframework.cloud.servicebroker.service.ServiceInstanceService;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceInstanceService implements ServiceInstanceService {

    @Override
    public CreateServiceInstanceResponse createServiceInstance(CreateServiceInstanceRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        String planId = request.getPlanId();
        Map<String, Object> parameters = request.getParameters();
        String dashboardUrl = ""; /* construct a dashboard URL */
        return CreateServiceInstanceResponse.builder()
                .dashboardUrl(dashboardUrl)
                .async(true)
                .build();
    }

    @Override
    public GetServiceInstanceResponse getServiceInstance(GetServiceInstanceRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        String dashboardUrl = ""; /* retrieve dashboard URL */
        return GetServiceInstanceResponse.builder()
                .dashboardUrl(dashboardUrl)
                .build();
    }

    @Override
    public GetLastServiceOperationResponse getLastOperation(GetLastServiceOperationRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        return GetLastServiceOperationResponse.builder()
                .operationState(OperationState.SUCCEEDED)
                .build();
    }

    @Override
    public UpdateServiceInstanceResponse updateServiceInstance(UpdateServiceInstanceRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        String planId = request.getPlanId();
        String previousPlan = request.getPreviousValues().getPlanId();
        Map<String, Object> parameters = request.getParameters();
        return UpdateServiceInstanceResponse.builder()
                .async(true)
                .build();
    }

    @Override
    public DeleteServiceInstanceResponse deleteServiceInstance(DeleteServiceInstanceRequest request) {
        String serviceInstanceId = request.getServiceInstanceId();
        String planId = request.getPlanId();
        return DeleteServiceInstanceResponse.builder()
                .async(true)
                .build();
    }
}
