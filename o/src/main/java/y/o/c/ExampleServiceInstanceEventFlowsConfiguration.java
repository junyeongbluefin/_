package y.o.c;

//import lombok.AllArgsConstructor;
import org.springframework.cloud.servicebroker.model.instance.*;
import org.springframework.cloud.servicebroker.service.events.EventFlowRegistries;
import org.springframework.cloud.servicebroker.service.events.flows.*;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
//@AllArgsConstructor
public class ExampleServiceInstanceEventFlowsConfiguration {

    private final EventFlowRegistries eventFlowRegistries;

    public ExampleServiceInstanceEventFlowsConfiguration(EventFlowRegistries eventFlowRegistries) {
        this.eventFlowRegistries = eventFlowRegistries;

        prepareCreateEventFlows()
                .then(prepareUpdateEventFlows())
                .then(prepareDeleteEventFlows())
                .then(prepareLastOperationEventFlows())
                .subscribe();
    }

    private Mono<Void> prepareCreateEventFlows() {
        return Mono.just(eventFlowRegistries.getCreateInstanceRegistry())
            .map(registry -> registry.addInitializationFlow(new CreateServiceInstanceInitializationFlow() {
                    @Override
                    public Mono<Void> initialize(CreateServiceInstanceRequest request) {
                        //
                        // do something before the instance is created
                        //
                        return Mono.empty();
                    }
                })
                .then(registry.addCompletionFlow(new CreateServiceInstanceCompletionFlow() {
                    @Override
                    public Mono<Void> complete(CreateServiceInstanceRequest request, CreateServiceInstanceResponse response) {
                        //
                        // do something after the instance is created
                        //
                        return Mono.empty();
                    }
                }))
                .then(registry.addErrorFlow(new CreateServiceInstanceErrorFlow() {
                    @Override
                    public Mono<Void> error(CreateServiceInstanceRequest request, Throwable t) {
                        //
                        // do something if an error occurs while creating an instance
                        //
                        return Mono.empty();
                    }
                }))
            )
            .then();
    }

    private Mono<Void> prepareUpdateEventFlows() {
        return Mono.just(eventFlowRegistries.getUpdateInstanceRegistry())
            .map(registry -> registry.addInitializationFlow(new UpdateServiceInstanceInitializationFlow() {
                    @Override
                    public Mono<Void> initialize(UpdateServiceInstanceRequest request) {
                        //
                        // do something before the instance is updated
                        //
                        return Mono.empty();
                    }
                })
                .then(registry.addCompletionFlow(new UpdateServiceInstanceCompletionFlow() {
                    @Override
                    public Mono<Void> complete(UpdateServiceInstanceRequest request, UpdateServiceInstanceResponse response) {
                        //
                        // do something after the instance is updated
                        //
                        return Mono.empty();
                    }
                }))
                .then(registry.addErrorFlow(new UpdateServiceInstanceErrorFlow() {
                    @Override
                    public Mono<Void> error(UpdateServiceInstanceRequest request, Throwable t) {
                        //
                        // do something if an error occurs while updating an instance
                        //
                        return Mono.empty();
                    }
                }))
            )
            .then();
    }

    private Mono<Void> prepareDeleteEventFlows() {
        return Mono.just(eventFlowRegistries.getDeleteInstanceRegistry())
            .map(registry -> registry.addInitializationFlow(new DeleteServiceInstanceInitializationFlow() {
                    @Override
                    public Mono<Void> initialize(DeleteServiceInstanceRequest request) {
                        //
                        // do something before the instance is deleted
                        //
                        return Mono.empty();
                    }
                })
                .then(registry.addCompletionFlow(new DeleteServiceInstanceCompletionFlow() {
                    @Override
                    public Mono<Void> complete(DeleteServiceInstanceRequest request, DeleteServiceInstanceResponse response) {
                        //
                        // do something after the instance is deleted
                        //
                        return Mono.empty();
                    }
                }))
                .then(registry.addErrorFlow(new DeleteServiceInstanceErrorFlow() {
                    @Override
                    public Mono<Void> error(DeleteServiceInstanceRequest request, Throwable t) {
                        //
                        // do something if an error occurs while deleting an instance
                        //
                        return Mono.empty();
                    }
                }))
            )
            .then();
    }

    private Mono<Void> prepareLastOperationEventFlows() {
        return Mono.just(eventFlowRegistries.getAsyncOperationRegistry())
            .map(registry -> registry.addInitializationFlow(new AsyncOperationServiceInstanceInitializationFlow() {
                @Override
                public Mono<Void> initialize(GetLastServiceOperationRequest request) {
                    //
                    // do something before returning the last operation
                    //
                    return Mono.empty();
                }
            })
            .then(registry.addCompletionFlow(new AsyncOperationServiceInstanceCompletionFlow() {
                @Override
                public Mono<Void> complete(GetLastServiceOperationRequest request,
                                           GetLastServiceOperationResponse response) {
                    //
                    // do something after returning the last operation
                    //
                    return Mono.empty();
                }
            }))
            .then(registry.addErrorFlow(new AsyncOperationServiceInstanceErrorFlow() {
                @Override
                public Mono<Void> error(GetLastServiceOperationRequest request, Throwable t) {
                    //
                    // do something if an error occurs while processing the last operation response
                    //
                    return Mono.empty();
                }
            }))
        )
        .then();
    }

}
