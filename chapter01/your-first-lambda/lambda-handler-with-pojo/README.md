## Chapter 1

    AWS Credentials configuration

    ```
    aws configure --profile admin
    ```

    S3 Bucker creation to upload articats
    ```
    aws s3 mb s3://serverless-artifacts-ravindra --profile admin
    ```

    Uploading artifact to S3 bucket

    ```
    aws s3 cp target/original-lambda-handler-with-pojo-1.0-SNAPSHOT.jar s3://serverless-artifacts-ravindra/chapter01/lambda-handler-with-pojo-1.0-SNAPSHOT.jar --profile admin
    ```

    Creating a Policy for Lambda

    ```
    aws iam create-policy --policy-name lambda_iam-policy_test --policy-document file://basic-lambda-permissions.txt --profile admin
    ```

    Create a assume role 
    ```
    aws iam create-role --role-name lambda_iam-role_test --assume-role-policy-document file://iam-role-trust-relationship.txt --profile admin
    ```

    Attaching policy to Role
    ```
    aws iam attach-role-policy --role-name lambda_iam-role_test --policy-arn arn:aws:iam::582456932885:policy/lambda_iam-policy_test --profile admin
    ```

    Deploying Lambda function

    ```
    aws lambda create-function --function-name demo-lambda-with-cli --runtime java8 --role arn:aws:iam::582456932885:role/lambda_iam-role_test --handler org.cloudcafe.serverless.LambdaHandler::handleRequest --code S3Bucket=serverless-artifacts-ravindra,S3Key=chapter01/lambda-handler-with-pojo-1.0-SNAPSHOT.jar --timeout 15 --memory-size 512 --profile admin
    ```

    Invoking Lambda function

    ```
    aws lambda invoke --invocation-type RequestResponse --function-name demo-lambda-with-cli  --cli-binary-format raw-in-base64-out --payload  {\"message\":\"Ravindra\"} --profile admin outfile.text
    ```

    ### Clean Up

    Delete function
    
    ```
    aws lambda delete-function --function-name demo-lambda-with-cli --profile admin
    ```

    Detach Role

    ```
    aws iam detach-role-policy --role-name lambda_iam-role_test --policy-arn arn:aws:iam::582456932885:policy/lambda_iam-policy_test --profile admin
    ```

    Delete Role
    ```
    aws iam delete-role --role-name lambda_iam-role_test --profile admin
    ```

    Delete Policy
    ```
    aws iam delete-policy --policy-arn arn:aws:iam::582456932885:policy/lambda_iam-policy_test --profile admin
    ```
