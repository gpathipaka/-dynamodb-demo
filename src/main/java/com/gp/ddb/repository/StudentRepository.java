package com.gp.ddb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.gp.ddb.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public void insertStudent(Student student) {
        mapper.save(student);
    }

    public Student getoneStudent(String studentId, String lastName) {
        return mapper.load(Student.class, studentId, lastName);
    }

    public void updateStudent(Student student) {
        try {
            mapper.save(student, buildDynamoDBSaveExpression(student));
        } catch (ConditionalCheckFailedException exception) {
            System.out.println("Invalid Data " + exception.getMessage());
        }
    }

    public void deleteStudent(Student student) {
        mapper.delete(student);
    }

    public DynamoDBSaveExpression buildDynamoDBSaveExpression(Student student) {
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expected = new HashMap<>();
        expected.put("studentId", new ExpectedAttributeValue(new AttributeValue(student.getStudentId()))
                .withComparisonOperator(ComparisonOperator.EQ));
        saveExpression.setExpected(expected);

        return saveExpression;
    }
}
