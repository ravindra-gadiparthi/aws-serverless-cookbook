package org.cloudcafe.serverless;

import org.cloudcafe.serverless.model.HandlerRequest;
import org.cloudcafe.serverless.model.HandlerResponse;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaHandler implements RequestHandler<HandlerRequest, HandlerResponse> {

    @Override
    public HandlerResponse handleRequest(HandlerRequest input, Context context) {
        context.getLogger().log("Incoming Request is " + input.getMessage());
        return new HandlerResponse("Hello " + input.getMessage());
    }

}
