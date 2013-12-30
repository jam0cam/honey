package com.aws;

//import com.amazonaws.ClientConfiguration;
//import com.amazonaws.Protocol;
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.PutObjectResult;

/**
 * User: jitse
 * Date: 9/28/13
 * Time: 2:42 PM
 */
public class S3Service {

    private AwsCredentials awsCredentials;
//    private AmazonS3 conn = null;
//
//    private void setupConnection() {
//        if (conn == null) {
//            AWSCredentials credentials = new BasicAWSCredentials(awsCredentials.getAccessKey(), awsCredentials.getSecretKey());
//
//            ClientConfiguration clientConfig = new ClientConfiguration();
//            clientConfig.setProtocol(Protocol.HTTP);
//
//            conn = new AmazonS3Client(credentials, clientConfig);
//            conn.setEndpoint(awsCredentials.getS3Endpoint());
//        }
//    }
//
//    public void uploadFile(MultipartFile mpFile) throws Exception {
//        setupConnection();
//
//        ByteArrayInputStream input = new ByteArrayInputStream(mpFile.getBytes());
//        PutObjectResult result = conn.putObject(awsCredentials.getBucketName(), mpFile.getOriginalFilename(), input, new ObjectMetadata());
//    }

    public AwsCredentials getAwsCredentials() {
        return awsCredentials;
    }

    public void setAwsCredentials(AwsCredentials awsCredentials) {
        this.awsCredentials = awsCredentials;
    }
}
