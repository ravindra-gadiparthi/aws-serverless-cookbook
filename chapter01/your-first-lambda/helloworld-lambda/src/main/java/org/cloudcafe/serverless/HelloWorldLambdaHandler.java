package org.cloudcafe.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * HelloWorldLambdaHandler.
 */
public class HelloWorldLambdaHandler implements RequestHandler<Object,String> 
{

    /**
     * Handle the request.
     *
     * @param arg0  - input to lambda handler
     * @param context - context object
     * @return greeting text
     */
    @Override
    public String handleRequest(final Object object, final Context context) {
        context.getLogger().log("input is "+object.toString() );
        String message = "Hello "+object.toString() ;
        return message;
    }
    
}
