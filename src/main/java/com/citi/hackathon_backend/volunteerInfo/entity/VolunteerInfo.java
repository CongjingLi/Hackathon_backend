package com.citi.hackathon_backend.volunteerInfo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@Data
@DynamoDBTable(tableName = "VolunteerInfo")
public class VolunteerInfo {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute(attributeName = "nick_name")
    private String nickName;
    @DynamoDBAttribute(attributeName = "address")
    private String address;
    @DynamoDBAttribute(attributeName = "email")
    private String email;//optional
    @DynamoDBAttribute(attributeName = "organization")
    private String organization;
    @DynamoDBAttribute(attributeName = "personal_description")
    private String personalDescription;
}
