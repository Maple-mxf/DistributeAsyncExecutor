package io.asyncexecutor.agent.springcloud;

import io.asyncexecutor.agent.api.AgentEndpoint;
import io.asyncexecutor.agent.api.logic.AgentEndpointLogic;
import io.asyncexecutor.context.dto.*;
import io.asyncexecutor.context.errors.agent.AgentException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/_agent")
public class AgentEndpointImp implements AgentEndpoint {

  private final AgentEndpointLogic agentEndpointLogic;

  public AgentEndpointImp(AgentEndpointLogic agentEndpointLogic) {
    this.agentEndpointLogic = agentEndpointLogic;
  }

  private <I, R extends java.io.Serializable> ApiResponse<R> tryBlock(
      ThrowAgentErrorFunction<I, R> lambda, I request) {
    ApiResponse<R> baseResponse = new ApiResponse<>();
    try {
      R response = lambda.apply(request);
      baseResponse.setResponse(response);
      return baseResponse;
    } catch (AgentException.InternalError e) {
      baseResponse.setCode("1");
    } catch (AgentException.InvalidOperate e) {
      baseResponse.setCode("2");
    } catch (AgentException.UnknownError e) {
      baseResponse.setCode("3");
    } catch (AgentException e) {
      baseResponse.setCode("4");
    }
    return baseResponse;
  }

  @PostMapping("/task/stage")
  @Override
  public ApiResponse<PerformStageResponse> performStage(PerformStageRequest request) {
    return tryBlock(agentEndpointLogic::performStageLogic, request);
  }

  @PostMapping("/task/succ_result")
  @Override
  public ApiResponse<CallbackOnSuccessResponse> callbackOnSuccess(
      CallbackOnSuccessRequest request) {
    return tryBlock(agentEndpointLogic::callbackOnSuccessLogic, request);
  }

  @PostMapping("/task/err_result")
  @Override
  public ApiResponse<CallbackOnErrorResponse> callbackOnFailed(CallbackOnErrorRequest request) {
    return tryBlock(agentEndpointLogic::callbackOnFailedLogic, request);
  }
}
