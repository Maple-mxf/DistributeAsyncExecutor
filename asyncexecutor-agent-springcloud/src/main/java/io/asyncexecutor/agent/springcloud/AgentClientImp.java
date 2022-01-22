package io.asyncexecutor.agent.springcloud;

import io.asyncexecutor.agent.api.AgentClient;
import io.asyncexecutor.context.dto.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class AgentClientImp implements AgentClient {

  // TODO
  @LoadBalanced
  private final RestTemplate restTemplate;

  public AgentClientImp(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public ApiResponse<SubmitAsyncTaskResponse> submitAsyncTask(SubmitAsyncTaskRequest request) {
    try {
      ResponseEntity<ApiResponse> responseEntity  = restTemplate.postForEntity("/task/submit", request, ApiResponse.class)
      return  responseEntity.getBody();
    } catch (RestClientException e) {
      if (e instanceof HttpClientErrorException.BadRequest) {
      } else if (e instanceof HttpClientErrorException.Conflict) {
      } else if (e instanceof HttpClientErrorException.Forbidden) {
      } else if (e instanceof HttpClientErrorException.Gone) {
      } else if (e instanceof HttpClientErrorException.MethodNotAllowed) {
      } else if (e instanceof HttpClientErrorException.NotFound) {
      } else if (e instanceof HttpClientErrorException.TooManyRequests) {
      } else if (e instanceof HttpClientErrorException.Unauthorized) {
      } else if (e instanceof HttpClientErrorException.UnprocessableEntity) {
      } else if (e instanceof HttpClientErrorException.UnsupportedMediaType) {
      } else if (e instanceof HttpClientErrorException.NotAcceptable) {
      }
    }

    return null;
  }

  @Override
  public ApiResponse<PostServerInstanceHeartbeatResponse> postServerInstanceHeartbeat(
      PostServerInstanceHeartbeatRequest request) {
    return null;
  }

  @Override
  public ApiResponse<AcknowledgeResponse> acknowledge(AcknowledgeRequest request) {
    return null;
  }

  @Override
  public ApiResponse<CallbackOnPerformStageResponse> callbackOnPerform(
      CallbackOnPerformStageRequest request) {
    return null;
  }

  @Override
  public ApiResponse<DescribeTimestampResponse> describeTimestamp() {
    return null;
  }
}
